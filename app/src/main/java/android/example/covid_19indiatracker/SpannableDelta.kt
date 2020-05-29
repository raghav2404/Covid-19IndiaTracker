package android.example.covid_19indiatracker

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan

class SpannableDelta(text:String,color:String,start:Int):SpannableString(text){
//INIT IS KIND OF KOTLIN CONSTRUCTOR
    init {
    //SET SPAN IS USED TO MODIFY A SUBSTRING OF THE ACTUAL TEXT
    //WE Change THE FG COLOR OF STRING FROM start to text.length with color Color excluding start and text.length
        setSpan(ForegroundColorSpan(Color.parseColor(color)),start,text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }





}