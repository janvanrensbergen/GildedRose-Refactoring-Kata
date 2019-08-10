package com.gildedrose;


import org.junit.jupiter.api.Test;

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
        final Item defaultItem = new Item("+5 Dexterity Vest", 10, 20);

        //When:
        new GildedRose(new Item[]{defaultItem}).updateQuality();

        //Then:
        assertThat(defaultItem.sellIn).isEqualTo(9);

    }

    @Test
    void thatDefaultItemQuality_WillDecreaseByOneAfterUpdate() {

        //Given:
        final Item defaultItem = new Item("+5 Dexterity Vest", 10, 20);

        //When:
        new GildedRose(new Item[]{defaultItem}).updateQuality();

        //Then:
        assertThat(defaultItem.quality).isEqualTo(19);
    }

    @Test
    void thatDefaultItemQuality_WillDecreaseByTwoWhenSellInIsPassed() {

        //Given:
        final Item defaultItem = new Item("+5 Dexterity Vest", 0, 20);

        //When:
        new GildedRose(new Item[]{defaultItem}).updateQuality();

        //Then:
        assertThat(defaultItem.quality).isEqualTo(18);
    }

}
