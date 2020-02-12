package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var amountString: String //amountString does not need to initialized
    private var tipAmount: Double = 0.0
    private var actualTipAmount:Double = 0.0
    private var totalAmount: Double = 0.0
    private var perPerson: Double = 0.0
    private var tipValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var otherTipValueET = findViewById<TextView>(R.id.othertipValue)
        var tipTotalTV = findViewById<TextView>(R.id.tipTotal)
        var totalTV = findViewById<TextView>(R.id.totalLb)
        var numpplTV = findViewById<TextView>(R.id.perPerson)
        var amountET = findViewById<TextView>(R.id.amountValue)
        var tipSpinner = findViewById<Spinner>(R.id.tipSpinner)
        var numofpplSpinner = findViewById<Spinner>(R.id.numOfPplValue)
        var clearButton = findViewById<Button>(R.id.clear)
        var calculateTotalButton = findViewById<Button>(R.id.calc)

        otherTipValueET.isEnabled = false

        if (tipSpinner != null) {
            tipSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    otherTipValueET.isEnabled = tipSpinner.selectedItem.toString() == "Other"
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        /*if (numofpplSpinner != null) {
            numofpplSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }*/

        clearButton.setOnClickListener {
            amountET.text = ""
            otherTipValueET.text = ""

            tipTotalTV.text = ""
            totalTV.text = ""
            numpplTV.text = ""
            tipSpinner.setSelection(0)
            numofpplSpinner.setSelection(0)
        }

        calculateTotalButton.setOnClickListener {
            amountString = (amountET.text).toString() //Get amount entered
            if (tipSpinner.selectedItem.toString() == "Other") {
                tipValue = ((otherTipValueET.text).toString()).toDouble()
            } else {
                tipValue = (tipSpinner.selectedItem.toString()).toDouble()
            }

            tipAmount = amountString.toDouble() * (tipValue).toDouble()
            actualTipAmount = (tipAmount / 100)
            tipTotalTV.text = "Tip Total: " + actualTipAmount + ""
            totalAmount = amountString.toDouble() + actualTipAmount
            totalTV.text = "Amount Total: " + totalAmount + ""
            perPerson = totalAmount / (numofpplSpinner.selectedItem.toString()).toInt()
            var s = (numofpplSpinner.selectedItem.toString()).toInt()
            if (s > 1) {
                numpplTV.text = "Per Person: " + perPerson
            } else {
                // Do nothing
            }
        }


    }


}
