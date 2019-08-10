package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.DecreasingQualityInventoryItem;

import static java.lang.Math.*;

public class NormalItem implements DecreasingQualityInventoryItem {

    private final Item item;

    NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public void decreaseQuality(Item item) {
        item.quality = max(0, item.quality - (isPassed(item) ? 2 : 1));
    }

    @Override
    public Item getItem() {
        return item;
    }

    private boolean isPassed(Item item) {
        return item.sellIn < 0;
    }
}
