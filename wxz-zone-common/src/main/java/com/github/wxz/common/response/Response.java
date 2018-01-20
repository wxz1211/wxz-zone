package com.github.wxz.common.response;

/**
 * @author: wangxianzhi
 * @date: 2018/1/13
 * @time: 17:57
 * @email: xianzhi@eastmoney.com
 */
public class Response {
    public static final Response SUCCESS = new Response(0, "", "success");
    public static final Response FAIL = new Response(-1, "", "fail");
    /**
     * NOT LOGIN
     */
    public static final Response NOT_LOGIN = new Response(-2, "", "fail");
    private int code;
    private Object data;
    private String msg;


    public static  Response successResponse(Object data) {
        return new Response(0, data, "success");
    }
    public static  Response failResponse(Object data) {
        return new Response(-1, data, "fail");
    }

    public Response(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
