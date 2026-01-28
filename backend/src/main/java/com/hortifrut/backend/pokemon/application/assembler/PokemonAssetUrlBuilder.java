package com.hortifrut.backend.pokemon.application.assembler;

public interface PokemonAssetUrlBuilder {
    String spriteUrl(int id);
    String cryUrl(int id);
    int extractIdFromUrl(String url);
}
