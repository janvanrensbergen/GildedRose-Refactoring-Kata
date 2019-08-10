package com.gildedrose.inventoryitem;

import com.gildedrose.Item;

public interface SellInUpdateable {

    default void updateSellIn(final Item item){
        item.sellIn -= 1;
    }

}
