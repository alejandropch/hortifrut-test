import { create } from "zustand";

interface PokemonState {
  search: string;

  setSearch: (search: string) => void;
}

export const useSearchStore = create<PokemonState>((set, get) => ({
  search: "",
  setSearch: (search) =>
    set({
      search
    }),
}));

