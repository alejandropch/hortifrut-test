import { create } from "zustand";

interface PokemonState {
  limit: number;
  offset: number;
  setLimit: (limit: number) => void;
  setPage: (page: number) => void;
}

export const usePokemonStore = create<PokemonState>((set, get) => ({
  limit: 12,
  offset: 0,

  setLimit: (limit) => set({ limit }),
  setPage: (page) => {
    const { limit } = get();
    set({ offset: page * limit });
  },
}));

