package com.hortifrut.backend.shared.bus;

public interface QueryBus {
    <R> R dispatch(Query<R> query);
}
