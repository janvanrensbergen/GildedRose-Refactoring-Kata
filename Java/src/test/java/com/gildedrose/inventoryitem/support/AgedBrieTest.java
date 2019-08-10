package com.gildedrose.inventoryitem.support;

import com.gildedrose.ItemFixtures;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieTest {


    @Test
    void thatSellInWillDecreaseByOneWhenItemAgesOneDay() {

        //Given:
        final var item = agedBrie().withSellIn(10).build();

        //When:
        new AgedBrie(item).ageOneDay();

        //Then:
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    void thatQualityIncreasesByOneWhenSellInIsNotPassedAndItemAgesOneDay() {

        //Given:
        final var item = agedBrie().withQuality(10).build();

        //When:
        new AgedBrie(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void thatMaximumQualityIsFifty() {

        //Given:
        final var item = agedBrie().withQuality(50).build();

        //When:
        new AgedBrie(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(50);

    }

    @Test
    void thatQualityWillIncreaseDoubleWhenSellInIsPassed() {

        //Given:
        final var item = agedBrie().withSellIn(0).withQuality(10).build();
        final var otherItem = agedBrie().withSellIn(-1).withQuality(10).build();

        //When:
        new AgedBrie(item).ageOneDay();
        new AgedBrie(otherItem).ageOneDay();

        //Then:
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(item.quality).isEqualTo(12);
            softly.assertThat(otherItem.quality).isEqualTo(12);
        });
    }


}