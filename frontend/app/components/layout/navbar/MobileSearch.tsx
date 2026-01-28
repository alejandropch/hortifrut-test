"use client";

import clsx from "clsx";
import { useState } from "react";
import Search from "./Search";

const SEARCH_WIDTH = "max-w-3xl"; 

const MobileSearch = () => {
  const [search, setSearch] = useState(false);

  return (
    <>
      {/* Toggle button – mobile only */}
      <button
        onClick={() => setSearch(!search)}
        aria-label="Open search"
        className="size-9 lg:size-11 flex cursor-pointer items-center justify-center rounded-sm border border-solid border-neutral-200 dark:border-neutral-700 md:hidden"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth="1.5"
          stroke="currentColor"
          className="size-5"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z"
          />
        </svg>
      </button>

      {/* Overlay search (mobile dropdown) */}
      <div
        className={clsx(
          "absolute inset-x-0 top-0 z-50 flex justify-center bg-neutral-50 dark:bg-neutral-900 p-4 transition-all duration-300 md:hidden",
          search
            ? "translate-y-0 opacity-100"
            : "-translate-y-full opacity-0 pointer-events-none"
        )}
      >
        <div className={`w-full ${SEARCH_WIDTH}`}>
          <Search search={search} setSearch={setSearch} />
        </div>
      </div>
    </>
  );
};

export const MobileSearchBar = () => {
  return (
    <div className="flex justify-center px-4 mt-8 z-10">
      <div className={`w-full ${SEARCH_WIDTH}`}>
        <Search search={false} />
      </div>
    </div>
  );
};

export default MobileSearch;

