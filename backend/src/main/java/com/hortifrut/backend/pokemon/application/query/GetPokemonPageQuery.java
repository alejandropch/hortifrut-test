package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.dto.PokemonListItemDto;
import com.hortifrut.backend.shared.bus.Query;
import com.hortifrut.backend.shared.pagination.PageResult;


public record GetPokemonPageQuery (
    int limit,
    int offset
) implements Query<PageResult<PokemonListItemDto>> {}
