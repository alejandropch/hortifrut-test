package com.hortifrut.backend.pokemon.application.query;

import com.hortifrut.backend.pokemon.application.assembler.PokemonAssetUrlBuilder;
import com.hortifrut.backend.pokemon.application.dto.PokemonListItemDto;
import com.hortifrut.backend.pokemon.domain.model.PokemonRef;
import com.hortifrut.backend.pokemon.domain.port.PokemonRepositoryPort;
import com.hortifrut.backend.shared.bus.QueryHandler;
import com.hortifrut.backend.shared.pagination.PageResult;
import org.springframework.stereotype.Component;

@Component("GetPokemonPageQueryHandler")
public class GetPokemonPageQueryHandler implements QueryHandler<GetPokemonPageQuery, PageResult<PokemonListItemDto>> {
    private final PokemonRepositoryPort repository;
    private final PokemonAssetUrlBuilder assetUrlBuilder;

    public  GetPokemonPageQueryHandler(PokemonRepositoryPort repository, PokemonAssetUrlBuilder assetUrlBuilder) {
        this.repository = repository;
        this.assetUrlBuilder = assetUrlBuilder;
    }
    @Override
    public PageResult<PokemonListItemDto> handle(GetPokemonPageQuery query) {
        PageResult<PokemonRef> page = repository.findPage(query.limit(), query.offset());

        var items = page.items()
                .stream()
                .map(pokemon -> {
                    int id =  assetUrlBuilder.extractIdFromUrl(pokemon.url());
                    return new PokemonListItemDto(
                            id,
                            pokemon.name(),
                            assetUrlBuilder.spriteUrl(id),
                            assetUrlBuilder.cryUrl(id)
                    );
                })
                .toList();

        return new PageResult<>(
                items,
                page.total()
        );
    }
}
