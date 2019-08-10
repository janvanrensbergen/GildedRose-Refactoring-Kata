package com.gildedrose;

import com.gildedrose.inventoryitem.support.InventoryItemFactory;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items)
                .forEach(item -> InventoryItemFactory.from(item).ageOneDay());
    }
}