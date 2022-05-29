package com.example.assignment1_20170599

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val edtxt1: EditText = findViewById(R.id.edtxt1)
        val resultTVUSDT: TextView = findViewById(R.id.USD_ID)
        val resultTVCrypto: TextView = findViewById(R.id.Currency_ID)

        var flag : String = "USD"

        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("JOD -Jodrdan Dinnar","TRY -Turkish Lira","EUR -Euro","AED -UAE Dirham")
        spinnerVal.adapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            } //p2 is the index of selected item



            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{ view ->
        //code here
        var x: Double = edtxt1.text.toString().toDouble();
            resultTVUSDT.text = x.toString()

            if(flag =="JOD -Jodrdan Dinnar") {
                resultTVCrypto.text = calculateJOD(x).toString();

            }
            else if(flag == "TRY -Turkish Lira") {
                resultTVCrypto.text = calculateTRY(x).toString();

            }
            else if(flag == "EUR -Euro") {
                resultTVCrypto.text = calculateEUR(x).toString();

            }
            else if(flag == "AED -UAE Dirham") {
                resultTVCrypto.text = calculateAED(x).toString();

            }
        }



    }
}
public fun calculateJOD(a: Double): Double {
    return a*0.71;
}
public fun calculateTRY(a: Double): Double {
    return a*16.22;
}
public fun calculateEUR(a: Double): Double {
    return a*0.93 ;
}
public fun calculateAED(a: Double): Double {
    return a*3.67 ;
}