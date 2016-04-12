package kits.volleytemplate;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Carl on 2016-03-07.
 */

/**
 * Class will contain everything related to Volley to maintain a correct request queue
 */
public class VolleySingleton {
    private static VolleySingleton instance = null;
    private RequestQueue requestQueue;

    private VolleySingleton(){
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getInstance(){
        if(instance == null){
            instance = new VolleySingleton();
        }
        return instance;
    }

    /**
     *
     * Return the universal request queue
     * @return RequestQueue
     */
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
