package digitalgarden.preferencetest.preferencematerial;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.Toast;

import digitalgarden.preferencetest.R;


public class PrefsFragment extends PreferenceFragmentCompat
    {
    @Override
    public void onCreate(final Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs_material);

        // Preference as button - only click behavior is used
        findPreference(getString(R.string.first_pref_key)).
                setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
                    {
                    @Override
                    public boolean onPreferenceClick(Preference preference)
                        {
                        // getActivity() cannot be null, when button is displayed
                        Toast.makeText(getActivity(), "Preference was touched!", Toast.LENGTH_SHORT).show();
                        return true;
                        }
                    });
        }

    @Override
    public void onCreatePreferences(Bundle bundle, String s)
        {
        }
    }
