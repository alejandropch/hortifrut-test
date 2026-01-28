package com.hortifrut.backend.shared.bus;

public interface QueryHandler <Q extends Query<R>, R> {
    R handle(Q query);
}
