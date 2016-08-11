package digitalgarden.preferencetest.preferencematerial;


import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import digitalgarden.preferencetest.R;

/**
 * A {@link android.preference.PreferenceActivity} which implements and proxies the necessary calls
 * to be used with AppCompat.
 *
 * This technique can be used with an {@link android.app.Activity} class, not just
 * {@link android.preference.PreferenceActivity}.
 */
public class PrefsActivity extends PreferenceActivity
    {
    @Override
    public void onBuildHeaders(List<Header> target)
        {
        loadHeadersFromResource(R.xml.prefs_classic_header, target);
        }

    protected boolean isValidFragment(String fragmentName) {
    return true;
    }


    private AppCompatDelegate mDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

        // setContentView( R.layout.one_pane_layout );
        // getSupportFragmentManager() cannot be reached
        // Two ideas:
        // - store it at application level temporary
        // - invoke an other AppCompatActivity, if no headers are involved (seems better)
        // static xml creation for preferenceFragmentCompat doesn't seem to work
        // http://stackoverflow.com/questions/32487206/inner-preferencescreen-not-opens-with-preferencefragmentcompat

        }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
        {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
        }

    public ActionBar getSupportActionBar()
        {
        return getDelegate().getSupportActionBar();
        }

    public void setSupportActionBar(@Nullable Toolbar toolbar)
        {
        getDelegate().setSupportActionBar(toolbar);
        }

    @Override
    public MenuInflater getMenuInflater()
        {
        return getDelegate().getMenuInflater();
        }

    @Override
    public void setContentView(@LayoutRes int layoutResID)
        {
        getDelegate().setContentView(layoutResID);
        }

    @Override
    public void setContentView(View view)
        {
        getDelegate().setContentView(view);
        }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params)
        {
        getDelegate().setContentView(view, params);
        }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params)
        {
        getDelegate().addContentView(view, params);
        }

    @Override
    protected void onPostResume()
        {
        super.onPostResume();
        getDelegate().onPostResume();
        }

    @Override
    protected void onTitleChanged(CharSequence title, int color)
        {
        super.onTitleChanged(title, color);
        getDelegate().setTitle(title);
        }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
        {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
        }
    @Override
    protected void onStop()
        {
        super.onStop();
        getDelegate().onStop();
        }
    @Override
    protected void onDestroy()
        {
        super.onDestroy();
        getDelegate().onDestroy();
        }

    public void invalidateOptionsMenu()
        {
        getDelegate().invalidateOptionsMenu();
        }

    private AppCompatDelegate getDelegate()
        {
        if (mDelegate == null)
            {
            mDelegate = AppCompatDelegate.create(this, null);
            }
        return mDelegate;
        }

    /*static
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
        }*/
    }
