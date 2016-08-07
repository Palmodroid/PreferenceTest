package digitalgarden.preferencetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity
    {

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);

        // Activity is ready after onAttach()
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        /* Testing default preferences
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Scribe.note( Debug.PREF,  "Testing. Preferences are cleared completely" );
        editor.clear();
        editor.apply();
        Scribe.note( Debug.PREF, "BEFORE SETTING DEFAULT VALUE - Prefs contains sample preference: "
                + sharedPrefs.contains( context.getString( R.string.debug_key ) ));
        PreferenceManager.setDefaultValues(context, R.xml.prefs_classic, true);
        Scribe.note( Debug.PREF, "AFTER SETTING DEFAULT VALUE - Prefs contains sample preference: "
                + sharedPrefs.contains( context.getString( R.string.debug_key ) ));
        */

        // OR

        // Default preference values are set only at start
        PreferenceManager.setDefaultValues(this, R.xml.prefs_classic, false);



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
        {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_classic_settings)
            {
            Intent preferenceIntent = new Intent( this, digitalgarden.preferencetest.preferenceclassic.PrefsActivity.class );
            startActivity( preferenceIntent );
            return true;
            }
        else if (id == R.id.action_material_settings)
            {
            Intent preferenceIntent = new Intent( this, digitalgarden.preferencetest.preferencematerial.PrefsActivity.class );
            startActivity( preferenceIntent );
            return true;
            }

        return super.onOptionsItemSelected(item);
        }
    }
