package com.hortifrut.backend.pokemon.infrastructure.pokeapi;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PokeApiClientImpl implements PokeApiClientPort {

    private static final String BASE_URL = "https://pokeapi.co/api/v2";
    private final RestClient client = RestClient.builder()
            .baseUrl(BASE_URL)
            .build();

    @Override
    public PokeApiListResponse fetchPage(int limit, int offset) {
        return client.get()
                .uri(uri -> uri.path("/pokemon")
                        .queryParam("limit", limit)
                        .queryParam("offset", offset)
                        .build())
                .retrieve()
                .body(PokeApiListResponse.class);

    }
    @Override
    public PokeApiPokemonResponse fetchByName(String name) {
        return client.get()
                .uri("/pokemon/{name}", name.trim().toLowerCase())
                .retrieve()
                .body(PokeApiPokemonResponse.class);
    }
}
