package com.yang.common;

import lombok.Data;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/10/14 上午8:13
 **/
@Data
public class R {

    private Integer code;
    private String message;
    private Object data;

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }

    public static R ok(String message, Object data) {
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        r.setData(data);
        r.setMessage("成功");
        return r;
    }

    public static R error() {
        R r = new R();
        return r;
    }

    public static R error(Integer code, String message) {
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

}
