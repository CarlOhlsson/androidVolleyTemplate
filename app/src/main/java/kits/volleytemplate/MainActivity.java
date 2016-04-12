package kits.volleytemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button postButton;
    private Button putButton;
    private Button getButton;
    private Button deleteButton;

    private TextView responseDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        responseDisplay = (TextView) findViewById(R.id.responseDisplay);

        postButton = (Button) findViewById(R.id.postButton);
        putButton = (Button) findViewById(R.id.putButton);
        getButton = (Button) findViewById(R.id.getButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        postButton.setOnClickListener(handlePostClick);
        putButton.setOnClickListener(handlePutClick);
        getButton.setOnClickListener(handleGetClick);
        deleteButton.setOnClickListener(handleDeleteClick);
    }

    /**
     * This object listens for the POST button click
     */
    View.OnClickListener handlePostClick = new View.OnClickListener(){
        public void onClick(View v){
            // The API endpoint
            String URL = "http://FoobarApi.com/users/addPrivate";

            // Store the parameters in a HashMap of Strings
            HashMap<String, String> params = new HashMap<String, String>();

            // The first value is the variable name specified by the API, second value is the data you want to send
            params.put("facebookId", "MyFacebookId");
            params.put("gcmToken", "MyGcmToken");

            // Create a request object for POST
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Remember that response is a JSON object!
                            responseDisplay.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            // Now add the request to the request queue
            VolleySingleton.getInstance().getRequestQueue().add(req);
        }
    };

    /**
     * This object listens for the PUT button click
     */
    View.OnClickListener handlePutClick = new View.OnClickListener(){
        public void onClick(View v){
            // The API endpoint
            String URL = "http://FoobarApi.com/users/updateGcm";

            // Store the parameters in a HashMap of Strings
            HashMap<String, String> params = new HashMap<String, String>();

            // The first value is the variable name specified by the API, second value is the data you want to send
            params.put("userId", "2");
            params.put("gcmToken", "MyNewToken");

            // Create a request object for PUT
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.PUT, URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Remember that response is a JSON object!
                            responseDisplay.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            // Now add the request to the request queue
            VolleySingleton.getInstance().getRequestQueue().add(req);
        }
    };

    /**
     * This object listens for the GET button click
     */
    View.OnClickListener handleGetClick = new View.OnClickListener(){
        public void onClick(View v){
            // The GET parameters
            String paramOne = "56.000000";
            String paramTwo = "14.000000";
            String paramThree = "2000";

            // The API endpoint with parameters at the end
            String URL = "http://FoobarApi.com/auctions/inRange?latitude=" + paramOne + "&longitude=" + paramTwo + "&distance=" + paramThree;

            // Create a request object for GET
            // NOTE: this is a JsonArrayRequest since the response is an array (Specified by the API)
            // This has nothing to do with the GET request itself
            JsonArrayRequest req = new JsonArrayRequest (Request.Method.GET, URL, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // Remember that response is a JSON object!
                            responseDisplay.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            // Now add the request to the request queue
            VolleySingleton.getInstance().getRequestQueue().add(req);
        }
    };

    /**
     * This object listens for the DELETE button click
     */
    View.OnClickListener handleDeleteClick = new View.OnClickListener(){
        public void onClick(View v){
            // The GET parameters
            String paramOne = "000";

            // The API endpoint
            String URL = "http://FoobarApi.com/users/deletePrivate?userId=" + paramOne;

            // Create a request object for DELETE
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.DELETE, URL, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Remember that response is a JSON object!
                            responseDisplay.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            // Now add the request to the request queue
            VolleySingleton.getInstance().getRequestQueue().add(req);
        }
    };
}
