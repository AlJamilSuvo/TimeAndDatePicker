package al.jamil.suvo.timeanddatepicker;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;


import java.util.Calendar;
;
import al.jamil.suvo.timeanddatepicker.databinding.DatePickerDialogLayoutBinding;

public class DatePickerDialog extends Dialog {


    public DatePickerDialog(@NonNull Context context, DatePickerDialogListener listener, Calendar calendar) {
        super(context);
        DatePickerDialogLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.date_picker_dialog_layout, null, false);
        setContentView(binding.getRoot());
        binding.datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        binding.ok.setOnClickListener(v -> {
            listener.onDatePicked(binding.datePicker.getYear(), binding.datePicker.getMonth(), binding.datePicker.getDayOfMonth());
            dismiss();
        });
        binding.cancel.setOnClickListener(v -> {
            dismiss();
        });


    }
}
