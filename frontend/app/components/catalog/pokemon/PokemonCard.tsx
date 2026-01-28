import Link from "next/link";
import { FC, useRef } from "react";
import Grid from "@/components/theme/ui/grid/Grid";
import { NextImage } from "@/components/common/NextImage";
import { Pokemon } from "../type";

export const PokemonCard: FC<{
  pokemon: Pokemon; 
}> = ({ pokemon }) => {

  const audioRef = useRef<HTMLAudioElement | null>(null);
  const playCry = (e: React.MouseEvent) => {
    e.preventDefault();
    e.stopPropagation();

    if (!audioRef.current) {
      audioRef.current = new Audio(pokemon.cry);
    }

    audioRef.current.currentTime = 0;
    audioRef.current.play();
  };

  return (
    <Grid.Item
      key={pokemon.id}
      className="animate-fadeIn gap-y-4.5 flex flex-col cursor-pointer"
    >
      <div className="group relative overflow-hidden rounded-lg ">
        <div onClick={playCry} className="aspect-[353/283] h-auto truncate rounded-lg">
          <NextImage
            alt={pokemon?.name || "Product image"}
            src={pokemon.image}
            width={353}
            height={283}
            className={`rounded-lg bg-neutral-100 object-cover transition duration-300 ease-in-out group-hover:scale-105`}
          />
        </div>
      </div>

      <div>
        <h3 className="mb-2.5 text-lg font-bold text-center md:text-lg">
          {pokemon?.name}
        </h3>
      </div>
    </Grid.Item>
  );
};

