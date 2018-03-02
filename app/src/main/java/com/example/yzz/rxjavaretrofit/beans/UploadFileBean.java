package com.example.yzz.rxjavaretrofit.beans;


import com.example.yzz.rxjavaretrofit.util.GSONUtil;

/**
 * Created by ctx on 2017/4/26.
 * <p>
 * 上传图片用
 * </p>
 */
public class UploadFileBean extends BaseBean {
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return GSONUtil.toJson(this);
    }
}
