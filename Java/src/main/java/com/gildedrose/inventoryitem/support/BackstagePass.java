package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.IncreasingQualityInventoryItem;

import static java.lang.Math.*;

public class BackstagePass implements IncreasingQualityInventoryItem {

    private static final int BUMP_QUALITY_ONCE = 1;
    private static final int BUMP_QUALITY_TWICE = 2;
    private static final int BUMP_QUALITY_THRICE = 3;

    private final Item item;

    BackstagePass(Item item) {
        this.item = item;
    }

    @Override
    public void increaseQuality(Item item) {
        if(concertIsPassed(item)) {
            item.quality = 0;
        } else {
            item.quality = min(bumpQuality(item), 50);
        }

    }

    private int bumpQuality(Item item) {
        if (concertInXDaysOrLess(item, 5)) {
            return item.quality + BUMP_QUALITY_THRICE;
        } else if (concertInXDaysOrLess(item, 10)) {
            return item.quality + BUMP_QUALITY_TWICE;
        } else {
            return item.quality + BUMP_QUALITY_ONCE;
        }
    }

    private boolean concertInXDaysOrLess(Item item, int days) {
        return item.sellIn <= days;
    }

    private boolean concertIsPassed(Item item) {
        return item.sellIn < 0;
    }

    @Override
    public Item getItem() {
        return item;
    }
}
