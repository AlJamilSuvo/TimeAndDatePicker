package al.jamil.suvo.timeanddatepicker

interface DataPickerListener {
    fun onDatePicked(year: Int, month: Int, dayOfMonth: Int)
}