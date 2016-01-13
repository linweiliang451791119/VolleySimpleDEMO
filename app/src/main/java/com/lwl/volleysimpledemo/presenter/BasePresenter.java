package com.lwl.volleysimpledemo.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by jonn on 2016/1/13.
 */
public abstract class BasePresenter<T> implements IPresenter{
    WeakReference<T> pView;

    public   BasePresenter(T view)
    {

        setWeakView(view);
    }

    public WeakReference<T> getpView() {
        return pView;
    }

    public void setpView(WeakReference<T> pView) {
        this.pView = pView;
    }

    public void setWeakView(T view){

        setpView(new WeakReference<T>(view));


    }
    public T getWeakView(){

        return getpView().get();
    }


}
