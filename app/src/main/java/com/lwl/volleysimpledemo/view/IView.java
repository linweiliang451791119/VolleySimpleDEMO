package com.lwl.volleysimpledemo.view;

import com.lwl.volleysimpledemo.presenter.IPresenter;

/**
 * Created by jonn on 2016/1/13.
 */
public interface IView<T> {

    public T getPresenter();
    public void setPresenter(T iPresenter);
    public  void initView();
    public  void initListener();
}
