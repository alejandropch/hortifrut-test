package com.hortifrut.backend.pokemon.domain.port;

import com.hortifrut.backend.pokemon.domain.model.Pokemon;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.shared.pagination.PageResult;

public interface PokemonRepositoryPort {
    PageResult<PokemonRef> findPage(int limit, int offset);
    Pokemon findByName(String name);
}
