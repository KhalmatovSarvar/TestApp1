package com.jamesmobiledev.testapp.data

import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.models.Loan

class DummyLoanData {

    val loanList = listOf(
        Loan("John Doe", "+1234567890", "1000", R.color.yellow),
        Loan("Jane Smith", "+1987654321", "-2000", R.color.green),
        Loan("Alice Johnson", "+1122334455", "500", R.color.green),
        Loan("Bob Brown", "+1555555555", "-4000", R.color.red),
        Loan("Emily Davis", "+1666666666", "3000", R.color.yellow),
        Loan("Michael Wilson", "+1777777777", "-1000", R.color.green),
        Loan("Emma Martinez", "+1888888888", "2000", R.color.red),
        Loan("William Taylor", "+1999999999", "-3000", R.color.green),
        Loan("Olivia Anderson", "+1818181818", "1500", R.color.red),
        Loan("James Thomas", "+1727272727", "-500", R.color.yellow)
    )

}