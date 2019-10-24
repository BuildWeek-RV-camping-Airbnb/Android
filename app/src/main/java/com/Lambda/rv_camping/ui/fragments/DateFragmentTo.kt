package com.Lambda.rv_camping.ui.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_reserve_place.*
import java.util.*

class DateFragmentTo: DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

        var fixedMonth: String = "${month+1}"
        var fixedDay: String = day.toString()
        if(month+1 < 10){
            fixedMonth = "0${month+1}"
        }

        if(day < 10){
            fixedDay = "0${day.toString()}"
        }
        val editable = SpannableStringBuilder("$year-${fixedMonth}-$fixedDay")
        activity?.tv_reserve_date_end?.text = editable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(context!!, this, year, month, day)
    }
}