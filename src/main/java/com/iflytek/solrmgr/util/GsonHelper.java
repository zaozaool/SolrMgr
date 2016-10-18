package com.iflytek.solrmgr.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by qxb-810 on 2016/5/5.
 */
public class GsonHelper {
    /**
     * 返回一个即使key为空值key也不会被遗漏的Gson对象
     * @return
     */
    public static Gson gson(){
        return new GsonBuilder().serializeNulls().create();
    }
}
