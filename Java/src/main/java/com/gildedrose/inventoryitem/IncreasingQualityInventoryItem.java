package com.gildedrose.inventoryitem;

import com.gildedrose.Item;

public interface IncreasingQualityInventoryItem extends InventoryItem, SellInUpdateable {

    @Override
    default void ageOneDay() {
        updateSellIn(getItem());
        increaseQuality(getItem());
    }

    void increaseQuality(final Item item);
}
