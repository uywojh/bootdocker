package com.rf.springboot.response;

/**
 * @Author: wuwei
 * @Date:2018/9/8 11:16
 */


import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 1475348231900998033L;

    private String code;

    private Boolean success;

    private String message;

    private T result;

    public JsonResult() {
    }

    public JsonResult(boolean isSuccess, String code, String message) {
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static JsonResult success() {
        return new JsonResult(true, "200", "操作成功!");
    }

    public static JsonResult success(Object data) {
        JsonResult result = new JsonResult(true, "200", "操作成功!");
        result.setResult(data);
        return result;
    }

    public static JsonResult error(String message) {
        JsonResult result = new JsonResult(false, "500", message);
        return result;
    }

    public static JsonResult rpcError() {
        JsonResult result = new JsonResult(false, "500", "rpc error!");
        return result;
    }

    public static JsonResult rpcError(String message) {
        JsonResult result = new JsonResult(false, "500", message);
        return result;
    }

    public static JsonResult error(String message, String code) {
        JsonResult result = new JsonResult(false, code, message);
        result.setCode(code);
        return result;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        return "JsonResult{code=" + this.code + ", success=" + this.success + ", message='" + this.message + '\'' + ", result=" + this.result + '}';
    }
}
