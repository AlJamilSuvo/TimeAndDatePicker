package al.jamil.suvo.timeanddatepicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import java.util.Calendar;

import al.jamil.suvo.timeanddatepicker.databinding.TimePickerDialogLayoutBinding;


public class TimePickerDialog extends Dialog {
    public TimePickerDialog(@NonNull Context context, TimePickerDialogListener listener, Calendar calendar) {

        super(context);
        TimePickerDialogLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.time_picker_dialog_layout, null, false);
        setContentView(binding.getRoot());
        binding.timePicker.setIs24HourView(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.timePicker.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            binding.timePicker.setMinute(calendar.get(Calendar.MINUTE));
        } else {
            binding.timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
            binding.timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
        }


        final int[] hh = new int[1];
        final int[] mm = new int[1];
        binding.timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            hh[0] = hourOfDay;
            mm[0] = minute;
        });

        binding.ok.setOnClickListener(v -> {
            listener.onTimePicked(hh[0], mm[0]);
            dismiss();
        });

        binding.cancel.setOnClickListener(v -> {
            dismiss();
        });

    }
}
