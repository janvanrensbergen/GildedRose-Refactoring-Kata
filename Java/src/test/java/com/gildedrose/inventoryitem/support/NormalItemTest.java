package com.gildedrose.inventoryitem.support;

import com.gildedrose.ItemFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalItemTest {

    @Test
    void thatSellInWillDecreaseByOneWhenNormalItemAgesOneDay() {

        //Given:
        final var item = ItemFixtures.normalItem().withSellIn(20).build();

        //When:
        new NormalItem(item).ageOneDay();

        //Then:
        assertThat(item.sellIn).isEqualTo(19);
    }

    @Test
    void thatQualityWillDecreaseByOneWhenItemAgesOneDay() {

        //Given:
        final var item = ItemFixtures.normalItem().withQuality(20).build();

        //When:
        new NormalItem(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(19);

    }

    @Test
    void thatQualityWillDecreaseTwiceAsFastWhenSellInIsPassed() {

        //Given:
        final var item = ItemFixtures.normalItem().withSellIn(0).withQuality(20).build();

        //When:
        new NormalItem(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(18);

    }

    @Test
    void thatQualityWillNeverBeNegativeWhenItemAgesOneDay() {

        //Given:
        final var item = ItemFixtures.normalItem().withSellIn(10).withQuality(0).build();

        //When:
        new NormalItem(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(0);

    }
}