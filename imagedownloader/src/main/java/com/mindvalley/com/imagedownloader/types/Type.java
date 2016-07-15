package com.mindvalley.com.imagedownloader.types;


import com.mindvalley.com.imagedownloader.listeners.HttpListener;
import com.mindvalley.com.imagedownloader.managers.CacheManagerInterface;

public abstract class Type<T> {
    public abstract Type setCacheManager(CacheManagerInterface<T> cacheManager);
    public abstract Type setCallback(HttpListener<T> callback);
    public abstract boolean cancel();
}
