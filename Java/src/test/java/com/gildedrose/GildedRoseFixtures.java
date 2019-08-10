package com.gildedrose;

import com.gildedrose.Item;

public class GildedRoseFixtures {

    public static GildedRose gildedRose(final Item ... items) {
        return new GildedRose(items);
    }

}
