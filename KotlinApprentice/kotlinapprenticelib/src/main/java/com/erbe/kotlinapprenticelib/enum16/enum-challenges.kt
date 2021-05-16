package com.erbe.kotlinapprenticelib.enum16

import java.util.*

enum class DayOfTheWeek1(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday(true),
    Thursday(true),
    Friday,
    Saturday,
    Sunday;

    fun daysUntil(other: DayOfTheWeek1): Int {
        if (this.ordinal < other.ordinal) {
            return other.ordinal - this.ordinal
        } else {
            return other.ordinal - this.ordinal + DayOfTheWeek1.values().count()
        }
    }

    fun daysUntilWeekend(): Int {
        return daysUntil(DayOfTheWeek1.firstWeekendDay())
    }

    companion object {
        fun today(): DayOfTheWeek1 {
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            var adjustedDay = calendarDayOfWeek - 2
            val days = DayOfTheWeek1.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }

        fun forIndex(index: Int): DayOfTheWeek1? {
            return DayOfTheWeek1.values().firstOrNull { it.ordinal == index }
        }

        fun forString(string: String): DayOfTheWeek1? {
            return DayOfTheWeek1.values().firstOrNull { it.name == string }
        }

        fun firstWeekendDay(): DayOfTheWeek1 {
            return DayOfTheWeek1.values().first { it.isWeekend }
        }
    }
}

sealed class AcceptedCurrency1 {
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    class Dollar : AcceptedCurrency1() {
        override val valueInDollars = 1.0f
    }

    class Euro : AcceptedCurrency1() {
        override val valueInDollars = 1.25f
    }

    class Crypto : AcceptedCurrency1() {
        override val valueInDollars = 2534.92f
    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "NerdCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    companion object {
        fun checkSufficientFunds(
            fundsAvailable: List<AcceptedCurrency1>,
            purchasePriceInDollars: Float
        ): Boolean {
            val totalFundsInDollars = fundsAvailable.fold(
                0.0f,
                { accumulator, currency -> accumulator + currency.valueInDollars })
            return totalFundsInDollars >= purchasePriceInDollars
        }
    }

    operator fun plus(otherFunds: AcceptedCurrency1): AcceptedCurrency1 {
        if (this::class == otherFunds::class) {
            this.amount += otherFunds.amount
            return this
        } else {
            // NOTE: There are other ways to think about this, but this is probably the most straightforward one.
            val dollars = Dollar()
            dollars.amount = this.valueInDollars + otherFunds.valueInDollars
            return dollars
        }
    }
}

fun main() {
    for (day in DayOfTheWeek1.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek1.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    val tuesday = DayOfTheWeek1.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")

    val today = DayOfTheWeek1.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    val secondDay = DayOfTheWeek1.Friday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

    when (today) {
        DayOfTheWeek1.Friday -> println("It's $today, I'm in love")
        else -> println("I'm tired of this warning about not all cases being handled")
    }

    val dayAtIndex3 = DayOfTheWeek1.forIndex(3)
    println("Day at index 3: $dayAtIndex3")

    val dayAtIndex7 = DayOfTheWeek1.forIndex(7)
    println("Day at index 7: $dayAtIndex7")

    val thursdayString = "Thursday"
    val thursdayDay = DayOfTheWeek1.forString(thursdayString)
    println("Day of the week for string \"$thursdayString\": $thursdayDay")

    val blernsdayString = "Blernsday"
    val blerndsayDay = DayOfTheWeek1.forString(blernsdayString)
    println("Day of the week for string \"$blernsdayString\": $blerndsayDay")

    val firstWeekendDay = DayOfTheWeek1.firstWeekendDay()
    val daysUntilWeekendFromWednesday = DayOfTheWeek1.Wednesday.daysUntilWeekend()
    println("From Wednesday there are $daysUntilWeekendFromWednesday days until the weekend, which starts on $firstWeekendDay")

    val daysUntilWeekendFromSaturday = DayOfTheWeek1.Saturday.daysUntilWeekend()
    println("From Saturday there are $daysUntilWeekendFromSaturday days until the weekend, which starts on $firstWeekendDay")

    val currency = AcceptedCurrency1.Crypto()
    println("You've got some ${currency.name}!")
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

    val dollars = AcceptedCurrency1.Dollar()
    dollars.amount = 2000f

    val sufficentBalance = AcceptedCurrency1.checkSufficientFunds(listOf(currency, dollars), 1000f)
    println("You ${if (sufficentBalance) "do" else "do not"} have enough money to buy the thing!")

    Downloader().downloadData("foo.com/bar",
        progress = { downloadState ->
            when (downloadState) {
                null -> println("No download state yet")
                DownloadState.Starting -> println("Starting download...")
                DownloadState.InProgress -> println("Downloading data...")
                DownloadState.Error -> println("An error occurred. Download terminated.")
                DownloadState.Success -> println("Download completed successfully.")
            }
        },
        completion = { error, list ->
            error?.let { println("Got error: ${error.message}") }
            list?.let { println("Got list with ${list.size} items") }
        })
}