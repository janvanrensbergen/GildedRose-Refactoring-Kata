package com.gildedrose

import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        items.forEach { InventoryItem.from(it).ageOneDay() }
    }
}


sealed class InventoryItem(val item: Item) {
    open fun ageOneDay() {
        item.sellIn = item.decreaseSellIn()
        item.quality = calculateQuality()
    }

    abstract fun calculateQuality(): Int

    companion object {
        fun from(item: Item): InventoryItem =
                when (item.name) {
                    "Aged Brie" -> AgedBrie(item)
                    "Sulfuras, Hand of Ragnaros" -> LegendaryItem(item)
                    "Backstage passes to a TAFKAL80ETC concert" -> BackStagePass(item)
                    "Conjured Mana Cake" -> ConjuredItem(item)
                    else -> NormalItem(item)
                }
    }
}

class AgedBrie(item: Item) : InventoryItem(item) {
    override fun calculateQuality(): Int =
            when {
                item.sellIn < 0 -> item.increaseQualityBy(2)
                else -> item.increaseQualityBy(1)
            }

}

class BackStagePass(item: Item) : InventoryItem(item) {
    override fun calculateQuality(): Int =
            when {
                item.sellIn < 0 -> 0
                item.sellIn < 6 -> item.increaseQualityBy(3)
                item.sellIn < 11 -> item.increaseQualityBy(2)
                else -> item.increaseQualityBy(1)
            }

}

class LegendaryItem(item: Item) : InventoryItem(item) {
    override fun ageOneDay() {}
    override fun calculateQuality(): Int = 0
}

class NormalItem(item: Item) : InventoryItem(item) {
    override fun calculateQuality(): Int =
            when {
                item.quality <= 0 -> 0
                item.sellIn < 0 -> item.decreaseQualityBy(2)
                else -> item.decreaseQualityBy(1)
            }

}

class ConjuredItem(item: Item) : InventoryItem(item) {
    override fun calculateQuality(): Int =
            when {
                item.quality <= 0 -> 0
                item.sellIn < 0 -> item.decreaseQualityBy(4)
                else -> item.decreaseQualityBy(2)
            }
}


private fun Item.decreaseSellIn() = this.sellIn - 1

private fun Item.increaseQualityBy(value: Int, max: Int = 50) =
        min(this.quality + value, max)

private fun Item.decreaseQualityBy(value: Int, min: Int = 0) =
        max(this.quality - value, min)