package com.hortifrut.backend.pokemon.infrastructure.config;

import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.pokemon.infrastructure.pokeapi.PokeApiClientPort;
import com.hortifrut.backend.pokemon.infrastructure.repository.CachedPokemonRepositoryDecorator;
import com.hortifrut.backend.pokemon.infrastructure.repository.PokemonRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonModuleConfig {
    @Bean
    PokemonRepositoryPort pokemonRepository(PokeApiClientPort client) {
        return new CachedPokemonRepositoryDecorator(
                new PokemonRepositoryAdapter(client)
        );
    }

}
