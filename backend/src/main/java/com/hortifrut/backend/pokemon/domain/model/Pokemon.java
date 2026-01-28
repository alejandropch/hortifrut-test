package com.hortifrut.backend.pokemon.domain.model;

import com.hortifrut.backend.pokemon.domain.model.valueobject.BaseStat;

import java.util.List;

public record Pokemon(
        int id,
        String name,
        List<String> types,
        List<BaseStat> stats
) {}
