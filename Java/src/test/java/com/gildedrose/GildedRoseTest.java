package com.gildedrose;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.gildedrose.GildedRoseFixtures.gildedRose;
import static com.gildedrose.ItemFixtures.item;

public class GildedRoseTest {


    @ParameterizedTest(name = "Given: An item \"{0}\" with sellIn \"{1}\" and quality \"{2}\" When: quality is updated Then: sellIn should be \"{3}\" And quality should be \"{4}\"")
    @CsvSource(value = {
            "+5 Dexterity Vest | 10 | 20 |  9 | 19",
            "+5 Dexterity Vest |  0 | 20 | -1 | 18",
            "+5 Dexterity Vest | 10 |  0 |  9 |  0"
    }, delimiter = '|')
    void thatGildedRoseUpdatesSellInAndQualityAsExpected(final String name, final int sellIn, final int quality, final int expectedSellIn, final int expectedQuality) {

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
