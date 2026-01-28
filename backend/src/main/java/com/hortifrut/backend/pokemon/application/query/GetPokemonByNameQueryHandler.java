package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.assembler.PokemonAssetUrlBuilder;
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
    private final PokemonAssetUrlBuilder assetUrlBuilder;

    public GetPokemonByNameQueryHandler(PokemonRepositoryPort repository, PokemonAssetUrlBuilder assetUrlBuilder) {
        this.repository = repository;
        this.assetUrlBuilder = assetUrlBuilder;
    }
    @Override
    public PokemonDTO handle(GetPokemonByNameQuery query) {
        Pokemon pokemon = repository.findByName(query.search().describeConstable()
                .orElseThrow(() -> new PokemonNotFoundException(query.search()))
        );
        return new PokemonDTO(
                pokemon.id(),
                pokemon.name(),
                assetUrlBuilder.spriteUrl(pokemon.id()),
                assetUrlBuilder.cryUrl(pokemon.id()),
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
