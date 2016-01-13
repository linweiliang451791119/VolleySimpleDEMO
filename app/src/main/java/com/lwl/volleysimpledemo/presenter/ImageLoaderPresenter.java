package com.lwl.volleysimpledemo.presenter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.lwl.volleysimpledemo.R;

import com.lwl.volleysimpledemo.net.LruImageCache;
import com.lwl.volleysimpledemo.view.ImageLoaderActivity;

/**
 * Volley和Retrofit都是对okhttp的封装。所以可以直接用Rxjava和okhttp整合。
 */
public class ImageLoaderPresenter extends BasePresenter<ImageLoaderActivity>{

    private static RequestQueue mQueue=null;
    public ImageLoaderPresenter(ImageLoaderActivity view) {
        super(view);
        if(mQueue==null)
        {
            mQueue = Volley.newRequestQueue(getWeakView());
        }
    }

    public void task()
    {
        ImageLoader imageLoader = new ImageLoader(mQueue,new LruImageCache());
        /***
         * getImageListener()方法接收三个参数，第一个参数指定用于显示图片的ImageView控件，
         * 第二个参数指定加载图片的过程中显示的图片，第三个参数指定加载图片失败的情况下显示的图片
         */
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(getWeakView().getImageView(),
                R.drawable.im, R.drawable.im);

       // imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg",
                listener, 200, 200);



    }


}
