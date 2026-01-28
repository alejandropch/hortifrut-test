package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.dto.PokemonDTO;
import com.hortifrut.backend.shared.bus.Query;
import com.hortifrut.backend.shared.pagination.PageResult;


public record GetPokemonByNameQuery(
    String search
) implements Query<PokemonDTO> {}
