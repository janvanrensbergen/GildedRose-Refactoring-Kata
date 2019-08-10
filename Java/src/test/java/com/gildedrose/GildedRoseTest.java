package com.gildedrose;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.gildedrose.GildedRoseFixtures.gildedRose;
import static com.gildedrose.ItemFixtures.item;

class GildedRoseTest {

    @ParameterizedTest(name = "Given: An item \"{0}\" with sellIn \"{1}\" and quality \"{2}\" When: quality is updated Then: sellIn should be \"{3}\" And quality should be \"{4}\"")
    @CsvSource(delimiter = '|', value = {
            //                                     name | sellin | quality | expected sellin | expected quality
            "                         +5 Dexterity Vest |     10 |      20 |               9 |               19 ",
            "                         +5 Dexterity Vest |      0 |      20 |              -1 |               18 ",
            "                         +5 Dexterity Vest |     10 |       0 |               9 |                0 ",
            "                         +5 Dexterity Vest |     -1 |       0 |              -2 |                0 ",
            "                         +5 Dexterity Vest |     10 |      60 |               9 |               59 ",
            "                                 Aged Brie |     10 |      10 |               9 |               11 ",
            "                                 Aged Brie |     10 |      50 |               9 |               50 ",
            "                                 Aged Brie |     -5 |      10 |              -6 |               12 ",
            "                Sulfuras, Hand of Ragnaros |     10 |      80 |              10 |               80 ",
            "                Sulfuras, Hand of Ragnaros |     -1 |      80 |              -1 |               80 ",
            "                Sulfuras, Hand of Ragnaros |      9 |      60 |               9 |               60 ",
            " Backstage passes to a TAFKAL80ETC concert |     20 |      20 |              19 |               21 ",
            " Backstage passes to a TAFKAL80ETC concert |     10 |      20 |               9 |               22 ",
            " Backstage passes to a TAFKAL80ETC concert |      9 |      20 |               8 |               22 ",
            " Backstage passes to a TAFKAL80ETC concert |      5 |      20 |               4 |               23 ",
            " Backstage passes to a TAFKAL80ETC concert |      0 |      20 |              -1 |                0 ",
            "                        Conjured Mana Cake |     10 |      20 |               9 |               19 "

    })
    void thatItemsQualityIsUpdatedAsSpecifiedAfterOneDay(final String name, final int sellIn, final int quality, final int expectedSellIn, final int expectedQuality) {

        //Given:
        final var item = item(name).withSellIn(sellIn).withQuality(quality).build();

        //When:
        gildedRose(item).updateQuality();

        //Then:
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(item.sellIn).isEqualTo(expectedSellIn);
            softly.assertThat(item.quality).isEqualTo(expectedQuality);
        });
    }
}
