package com.lwl.volleysimpledemo.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.presenter.ImagePresenter;

/**
 * volley本身就是异步处理，不会出现阻塞主线程的情况。
 */
public class ImageActivity extends ActionBarActivity implements IView<ImagePresenter>{

    ImagePresenter imagePresenter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initView();
        initListener();
       // getPresenter().task();
    }

    @Override
    public ImagePresenter getPresenter() {
        return imagePresenter;
    }

    @Override
    public void setPresenter(ImagePresenter iPresenter) {
        this.imagePresenter = iPresenter;
    }

    @Override
    public void initView() {


        imageView =(ImageView)findViewById(R.id.image);
        setPresenter(new ImagePresenter(ImageActivity.this));
    }

    @Override
    public void initListener() {


    }

    public  void imageClick(View view)
    {


        getPresenter().task();
    }

    public ImageView getImageView()
    {

       return imageView;
    }

}
