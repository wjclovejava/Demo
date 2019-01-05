package com.example.wjc.ssecurity1215.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;

/**
 * Created by xueyongfeng on 2017/8/23.
 */

@Component
public class JsonUtil {
    private Gson gson;
    private Gson gbgson;

    @PostConstruct
    private void init() {
        gson = new Gson();
        initGbGson();
    }

    private void initGbGson() {
        GsonBuilder gb = new GsonBuilder();
        gb.disableHtmlEscaping();
        gbgson = gb.create();
    }

    public String toString(Object o) {
        if (o == null) {
            return null;
        }
        return gson.toJson(o);
    }

    public String toStringByBuilder(Object o) {
        if (o == null) {
            return null;
        }
        return gbgson.toJson(o);
    }

    public <T> T toObject(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public <T> T toObject(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }
}
