package com.hortifrut.backend.pokemon.infrastructure.pokeapi;

public interface PokeApiClientPort {
    PokeApiListResponse fetchPage(int limit, int offset);
    PokeApiPokemonResponse fetchByName(String name);
}
