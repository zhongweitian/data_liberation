package com.zwt.data_liberation.pojo.second;

/**
 * @author WT ZHONG
 * @version 1.0
 * 用于参数查询
 * 2020/10/26
 */
public class ParameterQuery {
    private String type; //参数类型
    private String code; //参数码

    public ParameterQuery(Bptparm bptparm) {
        this.type = bptparm.getTYPE();
        this.code = bptparm.getCODE();
    }

    public ParameterQuery(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
