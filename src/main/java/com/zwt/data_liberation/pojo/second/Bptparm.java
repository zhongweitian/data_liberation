package com.zwt.data_liberation.pojo.second;

import com.zwt.data_liberation.util.FormatUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/1/20 15:35
 * 参数表，参数表
 */
public class Bptparm {
    private String TYPE = "";
    private String CODE = "";
    private BigDecimal EFF_DATE = new BigDecimal("20000101");
    private BigDecimal EXP_DATE = new BigDecimal("99991231");
    private String DESC = "";
    private String CDESC = "";
    private byte[] VAL;
    private BigDecimal UPD_DATE = new BigDecimal("0");
    private BigDecimal UPD_BR = new BigDecimal("0");
    private String UPD_TLR = "Wilton";
    private Timestamp TS;

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = FormatUtils.formatStr(CODE, 40);
    }

    public BigDecimal getEFF_DATE() {
        return EFF_DATE;
    }

    public void setEFF_DATE(BigDecimal EFF_DATE) {
        this.EFF_DATE = EFF_DATE;
    }

    public BigDecimal getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(BigDecimal EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
    }

    public String getDESC() {
        return DESC;
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public String getCDESC() {
        return CDESC;
    }

    public void setCDESC(String CDESC) {
        this.CDESC = CDESC;
    }

    public byte[] getVAL() {
        return VAL;
    }

    public void setVAL(byte[] VAL) {
        this.VAL = VAL;
    }

    public BigDecimal getUPD_DATE() {
        return UPD_DATE;
    }

    public void setUPD_DATE(BigDecimal UPD_DATE) {
        this.UPD_DATE = UPD_DATE;
    }

    public BigDecimal getUPD_BR() {
        return UPD_BR;
    }

    public void setUPD_BR(BigDecimal UPD_BR) {
        this.UPD_BR = UPD_BR;
    }

    public String getUPD_TLR() {
        return UPD_TLR;
    }

    public void setUPD_TLR(String UPD_TLR) {
        this.UPD_TLR = UPD_TLR;
    }

    public Timestamp getTS() {
        return TS;
    }

    public void setTS(Timestamp TS) {
        this.TS = TS;
    }
}
