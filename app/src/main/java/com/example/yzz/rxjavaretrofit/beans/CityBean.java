package com.example.yzz.rxjavaretrofit.beans;

import com.example.yzz.rxjavaretrofit.util.GSONUtil;

import java.util.List;

/**
 * Created by yzz on 2017/6/23 0020.
 */
public class CityBean extends BaseBean {
    private List<City> dataList;

    public List<City> getDataList() {
        return dataList;
    }

    public void setDataList(List<City> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return GSONUtil.toJson(this);
    }
}
