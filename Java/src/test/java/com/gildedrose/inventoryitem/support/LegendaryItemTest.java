package com.gildedrose.inventoryitem.support;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemFixtures.legendaryItem;
import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemTest {

    @Test
    void thatSellInDoesNotChangeWhenItemIsAgedByOneDay() {

        //Given:
        final var item = legendaryItem().withSellIn(10).withQuality(80).build();

        //When:
        new LegendaryItem(item).ageOneDay();

        //Then:
        assertThat(item.sellIn).isEqualTo(10);
    }

    @Test
    void thatQualityDoesNotChangeWhenItemIsAgedByOneDay() {

        //Given:
        final var item = legendaryItem().withSellIn(10).withQuality(80).build();

        //When:
        new LegendaryItem(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(80);
    }
}