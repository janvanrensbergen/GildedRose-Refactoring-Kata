package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.InventoryItem;

public class InventoryItemFactory {

    private InventoryItemFactory() {}

    public static InventoryItem from(final Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Conjured Mana Cake":
                return new ConjuredItem(item);
            default:
                return new NormalItem(item);
        }
    }
}
