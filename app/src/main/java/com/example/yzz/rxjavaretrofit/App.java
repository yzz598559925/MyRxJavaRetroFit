package com.example.yzz.rxjavaretrofit;

import android.app.Application;
import android.util.Log;

import com.example.yzz.rxjavaretrofit.httprequest.ApiRequest;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yzz on 2017/6/23 0023.
 */
public class App extends Application {

    public static App app;

    public static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    //创建一个Retrofit
    private Retrofit CreateRetrofit() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //利用拦截器添加请求头
                        Request request = chain.request().newBuilder()
                                .addHeader("version", "1.0.0")
                                .addHeader("phone", "ANDROID")
                                .addHeader("name", "yuzhengzhi")
//                                .addHeader("UUID", UUID.randomUUID() + "")
                                .build();
                        return chain.proceed(request);
                    }
                });

        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("yzz", "message===" + message);
            }
        });
        interceptor.setLevel(level);
        clientBuilder.interceptors().add(interceptor);
        return new Retrofit.Builder().baseUrl("http://gray-hsfapp.scloudpay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build();
    }

    //创建一个ApiRequest
    public ApiRequest CreateApiRequest() {
        return CreateRetrofit().create(ApiRequest.class);
    }
}
