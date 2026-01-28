package com.hortifrut.backend.shared.pagination;

import java.util.List;

public record PageResult<T> (List<T> items, long total) {}
