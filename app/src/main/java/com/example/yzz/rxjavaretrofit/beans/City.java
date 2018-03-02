package com.example.yzz.rxjavaretrofit.beans;

import com.example.yzz.rxjavaretrofit.util.GSONUtil;

/**
 * Created by yzz on 2017/6/23 0020.
 */
public class City {

    private String itemName;
    private String creator;
    private String modifyTime;
    private String modelFlag;
    private String createTime;
    private String id;
    private String praentLemmaItem;
    private String lemmaItem;
    private int version;
    private String updater;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModelFlag() {
        return modelFlag;
    }

    public void setModelFlag(String modelFlag) {
        this.modelFlag = modelFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPraentLemmaItem() {
        return praentLemmaItem;
    }

    public void setPraentLemmaItem(String praentLemmaItem) {
        this.praentLemmaItem = praentLemmaItem;
    }

    public String getLemmaItem() {
        return lemmaItem;
    }

    public void setLemmaItem(String lemmaItem) {
        this.lemmaItem = lemmaItem;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    @Override
    public String toString() {
        return GSONUtil.toJson(this);
    }
}
