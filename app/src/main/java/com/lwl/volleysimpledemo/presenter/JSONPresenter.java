package com.lwl.volleysimpledemo.presenter;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lwl.volleysimpledemo.view.JSONActivity;

import org.json.JSONObject;

/**
 * Created by jonn on 2016/1/13.
 */
public class JSONPresenter extends BasePresenter<JSONActivity>{

    private static RequestQueue mQueue=null;
    public JSONPresenter(JSONActivity view) {
        super(view);
        if(mQueue==null)
        mQueue = Volley.newRequestQueue(getWeakView());
    }

    public void task()
    {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        getWeakView().editText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                getWeakView().editText(error.toString());
            }
        });
        mQueue.add(jsonObjectRequest);
    }


}
