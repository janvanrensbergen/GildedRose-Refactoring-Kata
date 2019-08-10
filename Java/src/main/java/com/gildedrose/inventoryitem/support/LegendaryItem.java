package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.InventoryItem;

public class LegendaryItem implements InventoryItem {

    private final Item item;

    LegendaryItem(Item item) {
        this.item = item;
    }

    @Override
    public void ageOneDay() {}

    @Override
    public Item getItem() {
        return item;
    }
}
