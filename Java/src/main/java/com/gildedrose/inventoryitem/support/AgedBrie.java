package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.IncreasingQualityInventoryItem;

import static java.lang.Math.*;

public class AgedBrie implements IncreasingQualityInventoryItem {

    private static final int BUMP_QUALITY = 1;

    private final Item item;

    AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void increaseQuality(Item item) {
        this.item.quality = min(bumpQuality(this.item.quality, this.item.sellIn),  50);
    }

    private int bumpQuality(int quality, int sellIn) {
        return quality + (sellIn < 0 ? BUMP_QUALITY * 2 : BUMP_QUALITY);
    }

    @Override
    public Item getItem() {
        return item;
    }
}
