package com.Lambda.rv_camping.ui.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DateFragment: DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val editable = SpannableStringBuilder("$year-$month-$day")
        context?.text_purchase_date_add?.editText?.text = editable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(context!!, this, year, month, day)
    }
}