package com.example.yzz.rxjavaretrofit.util;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by yzz on 2017/6/23.
 * Gson工具类
 */
public class GSONUtil {

    private static final String TAG = GSONUtil.class.getSimpleName();

    public static Gson gson = new Gson();

    public static <T> T parseJson(Class<T> cls, String json) {
        try {
            return gson.fromJson(json, cls);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    public static <T> T parseJson(Type type, String json) {
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    public static String toJson(Object src) {
        try {
            return gson.toJson(src);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }
}
