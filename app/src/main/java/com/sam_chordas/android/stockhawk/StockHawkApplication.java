package com.sam_chordas.android.stockhawk;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by hbaxamoosa on 2/27/17.
 */

public class StockHawkApplication extends Application {

    private static Context context;

    public static Context getAppContext() {
        return StockHawkApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        StockHawkApplication.context = getApplicationContext();

        //Including Jake Wharton's Timber logging library
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.v("Timber.plant(new Timber.DebugTree());");
        } else {
            // Timber.plant(new CrashReportingTree());
        }

        // Facebook Stetho
        Stetho.initializeWithDefaults(this);
    }
}
