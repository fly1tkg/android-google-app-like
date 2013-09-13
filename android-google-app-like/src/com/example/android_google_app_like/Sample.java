package com.example.android_google_app_like;

public class Sample {
    public String name;
    public Class clazz;
    
    public Sample(Class clazz) {
        name = clazz.getSimpleName();
        this.clazz = clazz;
    }
}
