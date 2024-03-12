package com.jamesmobiledev.testapp.data

import com.jamesmobiledev.testapp.models.Cashier
import com.jamesmobiledev.testapp.models.Plan
import java.text.DecimalFormatSymbols

class DummyPlanData {
    var planList = listOf(
        Plan("Basic", "1", "2"),
        Plan("Pro", "2", "4"),
        Plan(
            "Pro+",
            "∞",
            "∞"
        ),
    )
}