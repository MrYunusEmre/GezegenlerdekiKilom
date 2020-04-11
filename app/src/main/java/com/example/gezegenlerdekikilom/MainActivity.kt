package com.example.gezegenlerdekikilom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val KILO_TO_POUND = 2.2045
    val POUND_TO_KILO = 0.45359237
    var MARS = 0.38
    val VENUS = 0.91
    val JUPITER = 2.34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbMars.setOnClickListener(this)
        cbVenus.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)


/*
        btnHesapla.setOnClickListener{

            var kullanıcıAgırlıkPound = kiloToPound(kullanıcıKilo.toString().toDouble())
            var marstakiAgırlıkPound = kullanıcıAgırlıkPound * MARS
            var marstakiAgırlıkKilo = poundToKilo(marstakiAgırlıkPound)

            textViewSonuc.text = marstakiAgırlıkKilo.formatla(2).toString()

        } */
    }

    fun kiloToPound(kilo : Double) : Double{

        return kilo * KILO_TO_POUND
    }

    fun poundToKilo(pound : Double):Double{

        return pound * POUND_TO_KILO
    }

    fun Double.formatla (kacTaneRakam : Int) = java.lang.String.format("%.${kacTaneRakam}f" , this)

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked


        if(!TextUtils.isEmpty(editTextKilo.text.toString())){
            var kullanıcıKilo = editTextKilo.text.toString().toDouble()

            when(v.id){
                R.id.cbMars -> if(v.isChecked ){
                    cbJupiter.isChecked = false
                    cbVenus.isChecked = false
                    hesaplaAgırlıkPound(kiloToPound(kullanıcıKilo),v)
                }
                R.id.cbVenus -> if(v.isChecked ){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    hesaplaAgırlıkPound(kiloToPound(kullanıcıKilo),v)
                }
                R.id.cbJupiter -> if(v.isChecked ){
                    cbMars.isChecked = false
                    cbVenus.isChecked = false
                    hesaplaAgırlıkPound(kiloToPound(kullanıcıKilo),v)
                }
            }
        }


    }

    fun hesaplaAgırlıkPound(pound:Double, checkBox: CheckBox){

        var sonuc:Double = 0.0

        when(checkBox.id){
            R.id.cbMars -> sonuc = pound * MARS
            R.id.cbJupiter -> sonuc = pound * JUPITER
            R.id.cbVenus -> sonuc = pound * VENUS
            else -> sonuc = 0.0
        }

        var sonucKilo = poundToKilo(sonuc)

        textViewSonuc.text = sonucKilo.toString().toDouble().formatla(2).toString()

    }

}
