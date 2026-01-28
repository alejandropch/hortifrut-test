package com.hortifrut.backend.pokemon.infrastructure.repository;

import com.hortifrut.backend.pokemon.domain.model.Pokemon;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.shared.pagination.PageResult;
import org.springframework.cache.annotation.Cacheable;

public class CachedPokemonRepositoryDecorator implements PokemonRepositoryPort {

    private final PokemonRepositoryPort delegate;
    public CachedPokemonRepositoryDecorator(PokemonRepositoryPort delegate) {
        this.delegate = delegate;
    }

    @Override
    @Cacheable(value = "pokemon-pages", key = "{#limit, #offset}")
    public PageResult<PokemonRef> findPage(int limit, int offset) {
        return delegate.findPage(limit, offset);
    }

    @Override
    @Cacheable(value = "pokemon-by-name", key = "#name")
    public Pokemon findByName(String name) {
        return delegate.findByName(name);
    }
}
