package com.lwl.volleysimpledemo.presenter;

import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lwl.volleysimpledemo.view.StringActivity;

/**
 * Created by jonn on 2016/1/13.
 */
public class StringPresenter extends BasePresenter<StringActivity> {

    private static  RequestQueue mQueue=null;
    public StringPresenter(StringActivity view) {
        super(view);
        if(mQueue==null)
        mQueue= Volley.newRequestQueue(getWeakView());
    }

    public  void task()
    {


        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        getWeakView().editText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                getWeakView().editText(error.toString());
            }
        });
        mQueue.add(stringRequest);
    }

}
