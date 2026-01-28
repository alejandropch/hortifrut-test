import { PokemonDetail, PokemonPage } from "@/components/catalog/type";
import { API_URL } from "@utils/constants";

export async function fetchPokemonsByName(
  name: string,
): Promise<PokemonDetail> {
  const res = await fetch(
    `${API_URL}/pokemons/${name}`
  );

  if (!res.ok) {
    throw new Error("Pokemon not found");
  }

  return res.json();
}

export async function fetchPokemons(
  limit: number,
  offset: number
): Promise<PokemonPage> {
  const res = await fetch(
    `${API_URL}/pokemons?limit=${limit}&offset=${offset}`
  );

  if (!res.ok) {
    throw new Error("Failed to fetch pokemons");
  }

  return res.json();
}

