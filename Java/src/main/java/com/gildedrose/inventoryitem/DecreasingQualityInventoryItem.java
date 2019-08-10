package com.gildedrose.inventoryitem;

import com.gildedrose.Item;

public interface DecreasingQualityInventoryItem extends InventoryItem, SellInUpdateable {

    @Override
    default void ageOneDay() {
        updateSellIn(getItem());
        decreaseQuality(getItem());
    }

    void decreaseQuality(final Item item);

}
