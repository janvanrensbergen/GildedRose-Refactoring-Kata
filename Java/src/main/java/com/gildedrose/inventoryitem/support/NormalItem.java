package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.DecreasingQualityInventoryItem;

import static java.lang.Math.*;

public class NormalItem implements DecreasingQualityInventoryItem {

    private static final int DROP_QUALITY = 1;
    private static final int DOUBLE_DROP_QUALITY = DROP_QUALITY * 2;

    private final Item item;

    NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public void decreaseQuality(Item item) {
        item.quality = max(0, dropQuality(item.quality, item.sellIn));
    }

    @Override
    public Item getItem() {
        return item;
    }

    private int dropQuality(int quality, int sellIn) {
        return quality - (isPassed(sellIn) ? DOUBLE_DROP_QUALITY : DROP_QUALITY);
    }

    private boolean isPassed(int sellIn) {
        return sellIn < 0;
    }
}
