package com.zhlh.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {


    protected final transient Logger log = LoggerFactory.getLogger(super.getClass());

    protected Object buildErrJson(String msg) {
        return buildJson(-1, msg, null);
    }

    protected Object buildSuccJson() {
        return buildSuccJson(null);
    }

    protected Object buildSuccJson(Object data) {
        return buildJson(0, "成功", data);
    }

    protected Object buildJson(int code, String msg) {
        return buildJson(code, msg, null);
    }

    protected Object buildJson(int code, String msg, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);


        if (data == null) {
            result.put("data", new HashMap<String, Object>());
        } else {
            result.put("data", data);
        }
        return result;
    }
}