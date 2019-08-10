package com.gildedrose;


import com.gildedrose.Item;

public class ItemFixtures {

    public static ItemBuilder item(final String name) {
        return new ItemBuilder(name);
    }

    public static ItemBuilder normalItem() {
        return new ItemBuilder("+5 Dexterity Vest");
    }

    public static ItemBuilder legendaryItem() {
        return new ItemBuilder("Sulfuras, Hand of Ragnaros");
    }

    public static class ItemBuilder {

        private final String name;

        private int sellIn = 10;

        private int quality = 20;

        public ItemBuilder(String name) {
            this.name = name;
        }

        public ItemBuilder withSellIn(final int sellIn) {
            this.sellIn = sellIn;
            return this;
        }

        public ItemBuilder withQuality(final int quality){
            this.quality = quality;
            return this;
        }

        public Item build() {
            return new Item(this.name, this.sellIn, this.quality);
        }
    }
}
