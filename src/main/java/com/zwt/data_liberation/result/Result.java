package com.zwt.data_liberation.result;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/21 20:46
 */

public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
