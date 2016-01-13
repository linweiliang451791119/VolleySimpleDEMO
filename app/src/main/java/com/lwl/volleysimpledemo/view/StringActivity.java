package com.lwl.volleysimpledemo.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.presenter.IPresenter;
import com.lwl.volleysimpledemo.presenter.StringPresenter;


public class StringActivity extends ActionBarActivity implements IView<StringPresenter>{


    Button btnString;
    TextView textView;
    StringPresenter iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        initView();
        initListener();
   //     getPresenter().task();

    }




    @Override
    public StringPresenter getPresenter() {
        return iPresenter;
    }

    @Override
    public void setPresenter(StringPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void initView() {
        btnString = (Button) findViewById(R.id.btn_string);
        textView = (TextView) findViewById(R.id.textView);
        setPresenter(new StringPresenter(StringActivity.this));
    }

    @Override
    public void initListener() {

        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().task();
            }
        });
    }

    public  void editText(String txt)
    {

        textView.setText(txt);
    }




}
