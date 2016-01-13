package com.lwl.volleysimpledemo.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.presenter.JSONPresenter;

public class JSONActivity extends ActionBarActivity implements IView<JSONPresenter> {

    TextView textView;
    Button btnJSON;
    JSONPresenter jsonPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        initView();
        initListener();

    }


    @Override
    public JSONPresenter getPresenter() {
        return jsonPresenter;
    }

    @Override
    public void setPresenter(JSONPresenter iPresenter) {
        this.jsonPresenter = iPresenter;
    }

    @Override
    public void initView() {
      btnJSON = (Button)findViewById(R.id.btn_JSON);

        textView= (TextView) findViewById(R.id.textView);
        setPresenter(new JSONPresenter(JSONActivity.this));
    }

    @Override
    public void initListener() {


        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().task();
            }
        });
    }

    public void editText(String txt)
    {

        this.textView.setText(txt);
    }
}
