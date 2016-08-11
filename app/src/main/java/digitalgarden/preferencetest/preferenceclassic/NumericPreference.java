package digitalgarden.preferencetest.preferenceclassic;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

import digitalgarden.preferencetest.R;

/**
 https://www.staldal.nu/tech/2015/05/16/custom-preference-for-android/
 */
public class NumericPreference extends DialogPreference
    {
    private static final int DEFAULT_VALUE = 0;

    private NumberPicker mWidget;

    private int value = DEFAULT_VALUE;

    public NumericPreference(Context context, AttributeSet attrs) {
    super(context, attrs);

    setDialogLayoutResource(R.layout.numeric_preference_dialog);
    }

    @Override
    protected void onBindDialogView(View view) {
    mWidget = (NumberPicker)view.findViewById(R.id.numeric_picker);
    mWidget.setMinValue(0);
    mWidget.setMaxValue(10);
    mWidget.setValue(value);
    super.onBindDialogView(view);
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
    return a.getInteger(index, DEFAULT_VALUE);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
    if (restorePersistedValue) {
    value = getPersistedInt(DEFAULT_VALUE);
    } else {
    value = (Integer)defaultValue;
    persistInt(value);
    }
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
    if (positiveResult) {
    value = mWidget.getValue();
    persistInt(value);
    }
    }
    }
