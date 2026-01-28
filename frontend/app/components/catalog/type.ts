export interface Pokemon {
  id: number;
  name: string;
  image: string;
  cry: string;
}

export interface PokemonPage {
  items: Pokemon[];
  total: number;
}

interface Stat {
  name: string;
  value: number;
}

export interface PokemonDetail {
  id: number;
  name: string;
  image: string;
  cry: string;
  types: string[];
  stats: Stat[];
}
