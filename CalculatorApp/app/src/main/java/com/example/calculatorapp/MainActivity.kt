package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tipTotal = findViewById<TextView>(R.id.tipTotal)
        var total = findViewById<TextView>(R.id.totalLb)
        var numppl = findViewById<TextView>(R.id.perPerson)

         var amount = findViewById<TextView>(R.id.amountValue)
         var tip = findViewById<Spinner>(R.id.tipSpinner)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.Tip_Percent
//        )

         var tipValue = findViewById<TextView>(R.id.othertipValue)
             tipValue.setEnabled(false)

        var numofppl = findViewById<Spinner>(R.id.numOfPplValue)

        var clear = findViewById<Button>(R.id.clear)
        var calculateTotal = findViewById<Button>(R.id.calc)

        calculateTotal.setOnClickListener(){

            var amountString: String = (amount.text).toString();
            var tipamount:Double = amountString.toDouble() * (tip.getSelectedItem().toString()).toDouble();
            tipTotal.text = "Tip Total: " + ".2f".format(tipamount);

            var totalAmount:Double = amountString.toDouble() + tipamount;
            total.text = "Amount Total: " + ".2f".format(totalAmount);

            var perPerson:Double =totalAmount/(numofppl.getSelectedItem().toString()).toInt();

            var s = (numofppl.getSelectedItem().toString()).toInt()
            if (s > 1){
               numppl.text = "Per Person: " + ".2f".format(perPerson);
            }


        }

        clear.setOnClickListener(){
            amount.text = "";
            tipValue.text = "";

            tipTotal.text = "";
            total.text = "";

        }

    }



}
