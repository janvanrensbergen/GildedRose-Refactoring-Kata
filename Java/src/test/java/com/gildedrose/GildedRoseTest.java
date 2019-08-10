package com.gildedrose;


import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseFixtures.*;
import static com.gildedrose.ItemFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {


    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void thatDefaultItemSellIn_WillDecreasesByOneAfterUpdate() {

        //Given:
        final var defaultItem = defaultItem().withSellIn(10).build();

        //When:
        gildedRose(defaultItem).updateQuality();

        //Then:
        assertThat(defaultItem.sellIn).isEqualTo(9);

    }

    @Test
    void thatDefaultItemQuality_WillDecreaseByOneAfterUpdate() {

        //Given:
        final var defaultItem = defaultItem().withQuality(20).build();

        //When:
        gildedRose(defaultItem).updateQuality();

        //Then:
        assertThat(defaultItem.quality).isEqualTo(19);
    }

    @Test
    void thatDefaultItemQuality_WillDecreaseByTwoWhenSellInIsPassed() {

        //Given:
        final var defaultItem = defaultItem().withSellIn(0).withQuality(20).build();

        //When:
        gildedRose(defaultItem).updateQuality();

        //Then:
        assertThat(defaultItem.quality).isEqualTo(18);
    }

    @Test
    void thatDefaultItemQuality_WillNeverBeNegative() {

        //Given:
        final var defaultItem = defaultItem().withQuality(0).build();

        //When:
        gildedRose(defaultItem).updateQuality();

        //Then:
        assertThat(defaultItem.quality).isEqualTo(0);
    }
}
