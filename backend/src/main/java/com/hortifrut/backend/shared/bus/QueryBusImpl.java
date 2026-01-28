package com.hortifrut.backend.shared.bus;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class QueryBusImpl implements QueryBus {
    private final ApplicationContext context;
    public QueryBusImpl(ApplicationContext context) {
        this.context = context;
    }
    @SuppressWarnings("unchecked")
    public <R> R dispatch(Query<R> query) {
        String handlerName = query.getClass().getSimpleName() + "Handler";
        QueryHandler<Query<R>, R> handler = (QueryHandler<Query<R>, R>) context.getBean(handlerName);
        return handler.handle(query);
    }
}
