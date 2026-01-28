package com.hortifrut.backend.pokemon.application.assembler;

import org.springframework.stereotype.Component;

@Component
public class PokemonAssetUrlBuilderImpl implements PokemonAssetUrlBuilder {
    private final String pokemonAssetUrl = "https://raw.githubusercontent.com/PokeAPI";
    @Override
    public String spriteUrl(int id) {
        return pokemonAssetUrl + "/sprites/master/sprites/pokemon/" + id + ".png";
    }

    @Override
    public String cryUrl(int id) {
        return pokemonAssetUrl + "/cries/main/cries/pokemon/legacy/" + id + ".ogg";
    }

    @Override
    public int extractIdFromUrl(String url) {
        String trimmed = url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
        return Integer.parseInt(trimmed.substring(trimmed.lastIndexOf("/") + 1));
    }
}
