package com.lwl.volleysimpledemo.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.StringRequest;
import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.presenter.ImageLoaderPresenter;

public class MainActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public  void gotoStringModule(View view)
    {
        startActivity(new Intent(MainActivity.this,StringActivity.class));

    }
    public  void gotoJSONModule(View view)
    {
       startActivity(new Intent(MainActivity.this,JSONActivity.class));

    }

    public  void gotoImageModule(View view)
    {
      startActivity(new Intent(MainActivity.this,ImageActivity.class));

    }

    public  void gotoImageLoaderModule(View view)
    {

        startActivity(new Intent(MainActivity.this,ImageLoaderActivity.class));
    }


}
