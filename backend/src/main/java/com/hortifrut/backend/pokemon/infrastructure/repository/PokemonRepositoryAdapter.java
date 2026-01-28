package com.hortifrut.backend.pokemon.infrastructure.repository;

import com.hortifrut.backend.pokemon.domain.model.Pokemon;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.pokemon.domain.model.valueobject.BaseStat;
import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.pokemon.infrastructure.pokeapi.PokeApiClientPort;
import com.hortifrut.backend.shared.pagination.PageResult;

public class PokemonRepositoryAdapter implements PokemonRepositoryPort {
    private final PokeApiClientPort client;

    public PokemonRepositoryAdapter(PokeApiClientPort client) {
        this.client = client;
    }

    @Override
    public PageResult<PokemonRef> findPage(int limit, int offset) {
        var response = client.fetchPage(limit, offset);
        var items = response.results().stream()
                .map(r -> new PokemonRef(r.name(), r.url()))
                .toList();

        return new PageResult<>(items, response.count());
    }

    public Pokemon findByName(String name) {
        var p = client.fetchByName(name);
        return new Pokemon(
                p.id(),
                p.name(),
                p.flatTypes(),
                p.flatStats().stream()
                        .map(s -> new BaseStat(
                                s.name(),
                                s.value()
                        )).toList()
                );
    }

}
