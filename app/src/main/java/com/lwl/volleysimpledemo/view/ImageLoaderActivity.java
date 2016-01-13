package com.lwl.volleysimpledemo.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.presenter.ImageLoaderPresenter;

public class ImageLoaderActivity extends ActionBarActivity implements  IView<ImageLoaderPresenter> {

    ImageLoaderPresenter imageLoaderPresenter;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        initView();
        initListener();
    }


    @Override
    public ImageLoaderPresenter getPresenter() {
        return imageLoaderPresenter;
    }

    @Override
    public void setPresenter(ImageLoaderPresenter iPresenter) {

        this.imageLoaderPresenter = iPresenter;
    }

    @Override
    public void initView() {
        imageView = (ImageView)findViewById(R.id.image);
        setPresenter(new ImageLoaderPresenter(ImageLoaderActivity.this));

    }

    @Override
    public void initListener() {


    }

    public void loadImage(View view)
    {
       getPresenter().task();
    }


    public  ImageView getImageView()
    {
        return this.imageView;

    }


}
