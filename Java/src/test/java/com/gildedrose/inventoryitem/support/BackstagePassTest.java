package com.gildedrose.inventoryitem.support;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemFixtures.backstagePass;
import static java.util.stream.Stream.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BackstagePassTest {

    @Test
    void thatSellInWillDecreaseWithOneWhenItmeAgesOneDay() {

        //Given:
        final var item = backstagePass().withSellIn(20).build();

        //When:
        new BackstagePass(item).ageOneDay();

        //Then:
        assertThat(item.sellIn).isEqualTo(19);

    }

    @Test
    void thatQualityWillIncreaseByOneWhenSellInIsMoreThan10() {

        //Given:
        final var item = backstagePass().withSellIn(12).withQuality(20).build();

        //When:
        new BackstagePass(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(21);

    }

    @Test
    void thatQualityWillIncreaseByTwoWhenSellInIsTenDaysOrLess() {

        //Given:
        final var item = backstagePass().withSellIn(11).withQuality(20).build();
        final var otherItem = backstagePass().withSellIn(10).withQuality(20).build();
        final var yetAnOtherItem = backstagePass().withSellIn(9).withQuality(20).build();

        //When:
        of(item, otherItem, yetAnOtherItem).forEach( it -> new BackstagePass(it).ageOneDay());

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(item.quality).isEqualTo(22);
            softly.assertThat(otherItem.quality).isEqualTo(22);
            softly.assertThat(yetAnOtherItem.quality).isEqualTo(22);
        });
    }

    @Test
    void thatQualityWillIncreaseByThreeWhenSellIsFiveDaysOrLEss() {

        //Given:
        final var item = backstagePass().withSellIn(6).withQuality(20).build();
        final var otherItem = backstagePass().withSellIn(5).withQuality(20).build();
        final var yetAnOtherItem = backstagePass().withSellIn(4).withQuality(20).build();

        //When:
        of(item, otherItem, yetAnOtherItem).forEach( it -> new BackstagePass(it).ageOneDay());

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(item.quality).isEqualTo(23);
            softly.assertThat(otherItem.quality).isEqualTo(23);
            softly.assertThat(yetAnOtherItem.quality).isEqualTo(23);
        });
    }

    @Test
    void thatQualityDropsToZeroWhenTheConcertIsPassed() {

        //Given:
        final var item = backstagePass().withSellIn(0).withQuality(200).build();

        //When:
        new BackstagePass(item).ageOneDay();

        //Then:
        assertThat(item.quality).isEqualTo(0);
    }
}