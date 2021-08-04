package com.example.common;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/4 9:51
 */
public class JsonResult<T> {
    private Integer code;
    private String msg;
    private long count;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
