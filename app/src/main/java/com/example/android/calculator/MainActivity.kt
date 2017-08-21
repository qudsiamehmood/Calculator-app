package com.example.android.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun bNumberClick(view: View) {

        if (isNewop) {
            DpScreen.setText("")
        }
        isNewop = false
        val Btnselected = view as Button
        var onClickBtn=DpScreen.text.toString()
        when (Btnselected.id) {
            B5.id -> {
                onClickBtn += "7"
            }

            B6.id -> {
                onClickBtn += "8"
            }

            B7.id -> {
                onClickBtn += "9"
            }
            B9.id -> {
                onClickBtn += "4"
            }
            B10.id -> {
                onClickBtn += "5"
            }
            B11.id -> {
                onClickBtn += "6"
            }
            B13.id -> {
                onClickBtn += "1"
            }
            B14.id -> {
                onClickBtn += "2"
            }
            B15.id -> {
                onClickBtn += "3"
            }
            B2.id -> {
                onClickBtn = "-" + onClickBtn
            }

            B17.id -> {
                onClickBtn += "0"
            }
            B18.id -> {
                onClickBtn += "."
            }
        }
        DpScreen.setText(onClickBtn)


    }

    var op = "*"
    var oldNumber = ""
    var isNewop = true
    fun OpBtn(view: View) {
        val Btnselected = view as Button
        when (Btnselected.id) {
            Bmul.id -> {
                op = "*"
            }
            Bdiv.id -> {
                op = "/"
            }
            Bsub.id -> {
                op = "-"
            }
            Bsum.id -> {
                op = "+"
            }
        }
        oldNumber = DpScreen.text.toString()
        isNewop = true
    }

    fun BuEqual(view: View) {
        var newNumber = DpScreen.text.toString()
        var finalNum: Double? = null
        when (op) {
            "*" -> {
                finalNum = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNum = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNum = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNum = oldNumber.toDouble() + newNumber.toDouble()
            }

        }
        DpScreen.setText(finalNum.toString())
        isNewop=true
    }
    fun Bpercent(view: View)
    {
        val number:Double= DpScreen.text.toString().toDouble()/100
        DpScreen.setText(number.toString())
        isNewop=true

    }
    fun Ac(view: View)
    {
        DpScreen.setText("0")
        isNewop=true
    }
}