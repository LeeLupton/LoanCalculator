// src/main/java/com/example/loancalculator/MainActivity.kt
package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etLoanAmount: EditText
    private lateinit var etInterestRate: EditText
    private lateinit var etLoanTerm: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvMonthlyPayment: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        etLoanAmount = findViewById(R.id.etLoanAmount)
        etInterestRate = findViewById(R.id.etInterestRate)
        etLoanTerm = findViewById(R.id.etLoanTerm)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvMonthlyPayment = findViewById(R.id.tvMonthlyPayment)

        btnCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan() {
        val loanAmount = etLoanAmount.text.toString().toDoubleOrNull()
        val interestRate = etInterestRate.text.toString().toDoubleOrNull()
        val loanTerm = etLoanTerm.text.toString().toDoubleOrNull()

        if (loanAmount == null || interestRate == null || loanTerm == null) {
            tvMonthlyPayment.text = getString(R.string.error_invalid_input)
            return
        }

        val monthlyRate = interestRate / 100 / 12
        val numberOfPayments = loanTerm * 12
        val monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments))

        tvMonthlyPayment.text = getString(R.string.monthly_payment, monthlyPayment)
    }
}
