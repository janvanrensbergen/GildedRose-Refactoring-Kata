package com.gildedrose.inventoryitem.support;

import com.gildedrose.Item;
import com.gildedrose.inventoryitem.DecreasingQualityInventoryItem;

import static java.util.stream.IntStream.range;

public class ConjuredItem implements DecreasingQualityInventoryItem {

    private final NormalItem delegate;

    ConjuredItem(final Item item) {
        this.delegate = new NormalItem(item);
    }

    @Override
    public void decreaseQuality(Item item) {
        range(0, 2).forEach(i -> {
            delegate.decreaseQuality(item);
        });
    }

    @Override
    public Item getItem() {
        return delegate.getItem();
    }
}
