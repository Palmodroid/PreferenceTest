package digitalgarden.preferencetest.preferencematerial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;


public class PrefsActivity extends AppCompatActivity
    {
    static
        {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null)
            {
            Fragment preferenceFragment = new PrefsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, preferenceFragment);
            ft.commit();
            }
        }
}
