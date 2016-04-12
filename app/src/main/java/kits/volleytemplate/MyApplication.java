package kits.volleytemplate;

import android.app.Application;
import android.content.Context;

/**
 * Created by Carl on 2016-03-07.
 */

/**
 * This class is keeping a record of the application context and making it available in the entire application
 */

public class MyApplication extends Application{
    private static MyApplication instance;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    /**
     * Simply return the application context
     * @return Context
     */
    public static Context getAppContext(){
        return instance.getApplicationContext();
    }
}
