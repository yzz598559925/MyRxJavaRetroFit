package com.example.yzz.rxjavaretrofit.httprequest;

import com.example.yzz.rxjavaretrofit.beans.CityBean;
import com.example.yzz.rxjavaretrofit.beans.UploadFileBean;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by yzz on 2017/6/23
 */
public interface ApiRequest {
    @FormUrlEncoded
    @POST("sys/getPrivinceList")
//    Call<CityBean> getPrivinceList(@Query("provinceCode") String provinceCode);//@Query是用来添加请求参数的(Retrofit请求的写法)
//    Observable<CityBean> getPrivinceList(@Query("provinceCode") String provinceCode);//@Query是用来添加请求参数的，是和地址拼接一起的
    Observable<CityBean> getPrivinceList(@Field("provinceCode") String provinceCode);//表单提交参数

    @Multipart
    @POST("sys/uploadFile")
    Observable<UploadFileBean> upFile(@Part("name") RequestBody body, @Part MultipartBody.Part file2);

    @POST
    @Streaming
    Observable<UploadFileBean> upFile(@Url String url, @Query("sysType") String s, @Query("versionNo") String v);
}
