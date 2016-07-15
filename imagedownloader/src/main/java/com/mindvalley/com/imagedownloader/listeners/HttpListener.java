package com.mindvalley.com.imagedownloader.listeners;


public interface HttpListener<T> {

    public void onRequest();
    public void onResponse(T data);
    public void onError();
    public void onCancel();

}
