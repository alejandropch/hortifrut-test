'use client';
import Script from 'next/script';

export function SpeculationRules() {
  return (
    <Script
      id="speculation-rules"
      type="speculationrules"
      dangerouslySetInnerHTML={{
        __html: JSON.stringify({
          prerender: [
            {
              where: {
                and: [
                  { href_matches: '.*' },
                  { not: { selector_matches: '.no-prerender' } },
                  { not: { selector_matches: '[rel~=nofollow]' } },
                ],
              },
              eagerness: 'moderate',
            },
          ],
          prefetch: [
            {
              urls: ['/'],
              requires: ['anonymous-client-ip-when-cross-origin'],
              referrer_policy: 'no-referrer',
            },
          ],
        }),
      }}
    />
  );
}

