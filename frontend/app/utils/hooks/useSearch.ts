import { useSearchStore } from "@/stores/useSearchStore";
import { Pokemon } from "@components/catalog/type";
import { useQuery } from "@tanstack/react-query";
import { fetchPokemons, fetchPokemonsByName } from "@utils/api/pokemon";

const LIMIT = 12;

type PokemonPage = {
  items: Pokemon[];
  total: number;
};

export function useSearch() {
  const search = useSearchStore((s) => s.search)

  return useQuery({
    queryKey: ["pokemon-search", search],

    queryFn: () => fetchPokemonsByName(search),

    enabled: Boolean(search),

    staleTime: 60_000,
  });
}


