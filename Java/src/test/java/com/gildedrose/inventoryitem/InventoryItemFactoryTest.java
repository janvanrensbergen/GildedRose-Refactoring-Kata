package com.gildedrose.inventoryitem;

import com.gildedrose.inventoryitem.support.*;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemFixtures.item;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class InventoryItemFactoryTest {

    @Test
    void thatFactoryWillReturnNormalIInventoryItemForNormalItem() {

        //Given:
        final var item = item("+5 Dexterity Vest").build();

        //When:
        final var result = InventoryItemFactory.from(item);

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isInstanceOf(NormalItem.class);
            softly.assertThat(result.getItem()).isEqualTo(item);
        });
    }

    @Test
    void thatAgedBrieWillBeReturnAgedBrieInventoryItem() {

        //Given:
        final var item = item("Aged Brie").build();

        //When:
        final var result = InventoryItemFactory.from(item);

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isInstanceOf(AgedBrie.class);
            softly.assertThat(result.getItem()).isEqualTo(item);
        });
    }


    @Test
    void thatLegendaryItemWillReturnedForSulfuras() {

        //Given:
        final var item = item("Sulfuras, Hand of Ragnaros").build();

        //When:
        final var result = InventoryItemFactory.from(item);

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isInstanceOf(LegendaryItem.class);
            softly.assertThat(result.getItem()).isEqualTo(item);
        });
      }

    @Test
    void thatBackstagePassWillBeReturnedForBackstagePassItem() {

        //Given:
        final var item = item("Backstage passes to a TAFKAL80ETC concert").build();

        //When:
        final var result = InventoryItemFactory.from(item);

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isInstanceOf(BackstagePass.class);
            softly.assertThat(result.getItem()).isEqualTo(item);
        });
    }

    @Test
    void thatConjuredItemWillBeReturnedForConjuredItem() {

        //Given:
        final var item = item("Conjured Mana Cake").build();

        //When:
        final var result = InventoryItemFactory.from(item);

        //Then:
        assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isInstanceOf(ConjuredItem.class);
            softly.assertThat(result.getItem()).isEqualTo(item);
        });
    }
}