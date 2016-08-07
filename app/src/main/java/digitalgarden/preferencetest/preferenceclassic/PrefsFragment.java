package digitalgarden.preferencetest.preferenceclassic;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import digitalgarden.preferencetest.R;

public class PrefsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener
    {
    /**
     * Preferences are initialized
     * @param savedInstanceState - not used
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        //Scribe.locus(Debug.PREF);

        // Load preferences from resources
        addPreferencesFromResource(R.xml.prefs_classic);

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


    /**
     * Entry point of preference fragment
     * Registers on SharedPreferenceChangeListener
     * (getActivity() cannot be null in onResume())
     */
    @Override
    public void onResume()
        {
        super.onResume();
        // Scribe.locus(Debug.PREF);

        // Change listener is registered
        PreferenceManager.getDefaultSharedPreferences( getActivity() )
                .registerOnSharedPreferenceChangeListener(this);
        }


    /**
     * Exit point of preference fragment - pair of onResume
     * unregisters on SharedPreferenceChangeListener
     * (getActivity() cannot be null in onResume())
     */
    @Override
    public void onPause()
        {
        super.onPause();
        // Scribe.locus( Debug.PREF );

        // Change listener is unregistered
        PreferenceManager.getDefaultSharedPreferences( getActivity() )
                .unregisterOnSharedPreferenceChangeListener( this );
        }


    /**
     * Check of every change in preferences
     * If service should react, then PREFS_COUNTER is increased, and PREFS_TYPE is set
     * (getActivity() cannot be null between onResume() and onPause())
     * @param sharedPrefs shared preferences
     * @param key key changed preferences
     */
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPrefs, String key)
        {
        // Scribe.locus( Debug.PREF );
        }

    }
