package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.dto.PokemonListItemDto;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.shared.bus.QueryHandler;
import com.hortifrut.backend.shared.pagination.PageResult;
import org.springframework.stereotype.Component;

@Component("GetPokemonPageQueryHandler")
public class GetPokemonPageQueryHandler implements QueryHandler<GetPokemonPageQuery, PageResult<PokemonListItemDto>> {
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

    public  GetPokemonPageQueryHandler(PokemonRepositoryPort repository) {
        this.repository = repository;
    }
    @Override
    public PageResult<PokemonListItemDto> handle(GetPokemonPageQuery query) {
        PageResult<PokemonRef> page = repository.findPage(query.limit(), query.offset());

        var items = page.items()
                .stream()
                .map(pokemon -> {
                    int id = extractIdFromUrl(pokemon.url());
                    return new PokemonListItemDto(
                            id,
                            pokemon.name(),
                            spriteUrl(id),
                            cryUrl(id)
                    );
                })
                .toList();

        return new PageResult<>(
                items,
                page.total()
        );
    }
}
