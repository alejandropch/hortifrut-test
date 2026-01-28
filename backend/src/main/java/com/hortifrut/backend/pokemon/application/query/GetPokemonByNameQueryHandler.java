package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.dto.PokemonDTO;
import com.hortifrut.backend.pokemon.domain.exception.PokemonNotFoundException;
import com.hortifrut.backend.pokemon.domain.model.Pokemon;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.shared.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component("GetPokemonByNameQueryHandler")
public class GetPokemonByNameQueryHandler implements QueryHandler<GetPokemonByNameQuery, PokemonDTO> {
    private final PokemonRepositoryPort repository;
    private String spriteUrl(int id) {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png";
    }
    private String cryUrl(int id) {
        return "https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/legacy/" + id + ".ogg";
    }

    private int extractIdFromUrl(String url) {
        String trimmed = url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
        return Integer.parseInt(trimmed.substring(trimmed.lastIndexOf("/") + 1));
    }

    public GetPokemonByNameQueryHandler(PokemonRepositoryPort repository) {
        this.repository = repository;
    }
    @Override
    public PokemonDTO handle(GetPokemonByNameQuery query) {
        Pokemon pokemon = repository.findByName(query.search().describeConstable()
                .orElseThrow(() -> new PokemonNotFoundException(query.search()))
        );
        return new PokemonDTO(
                pokemon.id(),
                pokemon.name(),
                spriteUrl(pokemon.id()),
                cryUrl(pokemon.id()),
                pokemon.types(),
                pokemon.stats()
                        .stream()
                        .map(stat ->
                                new PokemonDTO.BaseStat(
                                        stat.name(),
                                        stat.value()
                                )
                        )
                        .toList()
        );
    }
}
