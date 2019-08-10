package com.gildedrose.inventoryitem.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.gildedrose.ItemFixtures.conjuredItem;
import static com.gildedrose.ItemFixtures.normalItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class ConjuredItemTest {

    @Test
    void thatSellInDescreasesByOneWhenItemAgesOneDay() {

        //Given:
        final var item = conjuredItem().withSellIn(10).build();

        //When:
        new ConjuredItem(item).ageOneDay();

        //Then:
        assertThat(item.sellIn).isEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            // sellIn | quality | expected normal quality | expected conjured quality
            "      10 |     100 |                      99 |                       98",
            "      -1 |     100 |                      98 |                       96",
            "      10 |       0 |                       0 |                        0",
            "      -1 |       0 |                       0 |                        0"
    })
    void thatQualityWillDropTwiceAsFastAsNormalItem(final int sellIn, final int quality, final int expectedNormalQuality, final int expectedConjuredQuality) {

        //Given:
        final var normalItem = new NormalItem(normalItem().withSellIn(sellIn).withQuality(quality).build());
        final var conjuredItem = new ConjuredItem(conjuredItem().withSellIn(sellIn).withQuality(quality).build());

        //When:
        normalItem.ageOneDay();
        conjuredItem.ageOneDay();

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(normalItem.getItem().quality).isEqualTo(expectedNormalQuality);
            softly.assertThat(conjuredItem.getItem().quality).isEqualTo(expectedConjuredQuality);
        });

    }
}