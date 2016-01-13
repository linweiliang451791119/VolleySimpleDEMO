package com.lwl.volleysimpledemo.presenter;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.lwl.volleysimpledemo.R;
import com.lwl.volleysimpledemo.view.ImageActivity;

/**
 * Created by jonn on 2016/1/13.
 * 注意volley本身已经是异步的
 */
public class ImagePresenter extends BasePresenter<ImageActivity> {

   private static RequestQueue mQueue=null;

    public ImagePresenter(ImageActivity view) {
        super(view);
        if(mQueue==null)
        {

            mQueue= Volley.newRequestQueue(getWeakView());
        }
    }

    /**
     * 第一个参数就是图片的URL地址，这个没什么需要解释的。
     * 第二个参数是图片请求成功的回调，这里我们把返回的Bitmap参数设置到ImageView中。
     * 第三第四个参数分别用于指定允许图片最大的宽度和高度，如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，指定成0的话就表示不管图片有多大，都不会进行压缩。
     * 第五个参数用于指定图片的颜色属性，Bitmap.Config下的几个常量都可以在这里使用，其中ARGB_8888可以展示最好的颜色属性，每个图片像素占据4个字节的大小，
     * 而RGB_565则表示每个图片像素占据2个字节大小。第六个参数是图片请求失败的回调，这里我们当请求失败时在ImageView中显示一张默认图片
     */
    public  void task()
    {


        ImageRequest imageRequest = new ImageRequest(
                "http://i2.img.969g.com/pub/imgx2016/01/05/284_141211_5a624.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        getWeakView().getImageView().setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getWeakView().getImageView().setImageResource(R.drawable.im);
            }
        });
        mQueue.add(imageRequest);

    }



}
