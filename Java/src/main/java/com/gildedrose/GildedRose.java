package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(itemShouldBeUpdated(item)) {
                updateSellIn(item);
                updateQuality(item);
            }
        }
    }

    private boolean itemShouldBeUpdated(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie") && item.quality < 50) {
                item.quality = item.quality + 1;
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}