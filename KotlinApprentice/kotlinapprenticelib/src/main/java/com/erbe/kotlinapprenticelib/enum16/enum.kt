package com.erbe.kotlinapprenticelib.enum16

import java.util.*

enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

    fun daysUntil(other: DayOfTheWeek): Int {
        if (this.ordinal < other.ordinal) {
            return other.ordinal - this.ordinal
        } else {
            return other.ordinal - this.ordinal + DayOfTheWeek.values().count()
        }
    }

    companion object {
        fun today(): DayOfTheWeek {
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            var adjustedDay = calendarDayOfWeek - 2
            val days = DayOfTheWeek.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }
    }
}

sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    class Dollar : AcceptedCurrency() {
        override val valueInDollars = 1.0f
    }

    class Euro : AcceptedCurrency() {
        override val valueInDollars = 1.25f
    }

    class Crypto : AcceptedCurrency() {
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
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")

    val today = DayOfTheWeek.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    val secondDay = DayOfTheWeek.Friday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

    when (today) {
        DayOfTheWeek.Friday -> println("It's $today, I'm in love")
    }

    val currency = AcceptedCurrency.Crypto()
    println("You've got some ${currency.name}!")
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

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