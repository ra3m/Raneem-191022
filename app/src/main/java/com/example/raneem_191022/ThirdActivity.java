package com.example.raneem_191022;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdActivity extends AppCompatActivity {
    private TextView temp, city, humid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        temp = findViewById(R.id.temperature);
        city = findViewById(R.id.editTextCity);
        findweather();
    }

    public void findweather() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London&appid=e6e7c0c661e040f342b4570c425a6545";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    temp.setText(String.valueOf(main_object.getDouble("temp")));
                    city.setText(response.getString("city"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue req = Volley.newRequestQueue(this);
        req.add(jor);
    }
}