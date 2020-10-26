package com.zwt.data_liberation.pojo.second;

import com.zwt.data_liberation.util.FormatUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 13:33
 * 科目组数据
 */
public class SubjectGroup {
    private String COA_FLG; //char[2]
    private String SNAME = FormatUtils.formatStr("", 35);//char[35]
    private byte[] LNAME;//blob,120
    private BigDecimal EFF_DATE = new BigDecimal("20000101"); //Decimal,8
    private BigDecimal EXP_DATE = new BigDecimal("99991231"); //Decimal,8
    private String OPT_FLG = "Y"; //char[1]
    private String CNTY1; //char[4]
    private String CNTY2 = FormatUtils.formatStr("", 4); //char[4]
    private String CNTY3 = FormatUtils.formatStr("", 4); //char[4]
    private String CKFLG = "N";//char[1]
    private String REAL_GL = "1751110007";//char[10]
    private String MEMO_GL = "1121130000";//char[10]
    private List<Subject> REL_ITMS;
    private String UPD_TLR = FormatUtils.formatStr("", 8);//char[8]
    // TODO: 2020/10/25 后续要修改 UPD_TIME
    private BigDecimal UPD_DATE = new BigDecimal("20000101"); //decimal,8
    private BigDecimal UPD_TIME = new BigDecimal("120000"); ;//decimal,6
    private String SUP_TEL1 = FormatUtils.formatStr("", 8);//char[8]
    private String SUP_TEL2 = FormatUtils.formatStr("", 8);;//char[8]


    public String getCOA_FLG() {
        return COA_FLG;
    }

    public void setCOA_FLG(String COA_FLG) {
        this.COA_FLG = FormatUtils.formatStr(COA_FLG, 2);
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = FormatUtils.formatStr(SNAME, 35);
    }

    public byte[] getLNAME() {
        return LNAME;
    }

    public void setLNAME(byte[] LNAME) {
        this.LNAME = FormatUtils.formatBytes(LNAME, 120);
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

    public String getOPT_FLG() {
        return OPT_FLG;
    }

    public void setOPT_FLG(String OPT_FLG) {
        this.OPT_FLG = FormatUtils.formatStr(OPT_FLG, 1);
    }

    public String getCNTY1() {
        return CNTY1;
    }

    public void setCNTY1(String CNTY1) {
        this.CNTY1 = FormatUtils.formatStr(CNTY1, 4);
    }

    public String getCNTY2() {
        return CNTY2;
    }

    public void setCNTY2(String CNTY2) {
        this.CNTY2 = FormatUtils.formatStr(CNTY2, 4);
    }

    public String getCNTY3() {
        return CNTY3;
    }

    public void setCNTY3(String CNTY3) {
        this.CNTY3 = FormatUtils.formatStr(CNTY3, 4);
    }

    public String getCKFLG() {
        return CKFLG;
    }

    public void setCKFLG(String CKFLG) {
        this.CKFLG = FormatUtils.formatStr(CKFLG, 1);
    }

    public String getREAL_GL() {
        return REAL_GL;
    }

    public void setREAL_GL(String REAL_GL) {
        this.REAL_GL = FormatUtils.formatStr(REAL_GL, 10);
    }

    public String getMEMO_GL() {
        return MEMO_GL;
    }

    public void setMEMO_GL(String MEMO_GL) {
        this.MEMO_GL = FormatUtils.formatStr(MEMO_GL, 10);
    }

    public List<Subject> getREL_ITMS() {
        return REL_ITMS;
    }

    public void setREL_ITMS(List<Subject> REL_ITMS) {
        this.REL_ITMS = REL_ITMS;
    }

    public String getUPD_TLR() {
        return UPD_TLR;
    }

    public void setUPD_TLR(String UPD_TLR) {
        this.UPD_TLR = FormatUtils.formatStr(UPD_TLR, 8);
    }

    public BigDecimal getUPD_DATE() {
        return UPD_DATE;
    }

    public void setUPD_DATE(BigDecimal UPD_DATE) {
        this.UPD_DATE = UPD_DATE;
    }

    public BigDecimal getUPD_TIME() {
        return UPD_TIME;
    }

    public void setUPD_TIME(BigDecimal UPD_TIME) {
        this.UPD_TIME = UPD_TIME;
    }

    public String getSUP_TEL1() {
        return SUP_TEL1;
    }

    public void setSUP_TEL1(String SUP_TEL1) {
        this.SUP_TEL1 = FormatUtils.formatStr(SUP_TEL1, 8);
    }

    public String getSUP_TEL2() {
        return SUP_TEL2;
    }

    public void setSUP_TEL2(String SUP_TEL2) {
        this.SUP_TEL2 = FormatUtils.formatStr(SUP_TEL2, 8);
    }


    public byte[] objectToByte(int size){
        byte[] bytes = new byte[size];
        //转换成byte[]
        System.arraycopy(getCOA_FLG().getBytes(), 0, bytes, 0, getCOA_FLG().getBytes().length);
        int index = getCOA_FLG().getBytes().length;
        System.arraycopy(getSNAME().getBytes(), 0, bytes, index, getSNAME().getBytes().length);
        index += getSNAME().getBytes().length;
        System.arraycopy(getLNAME(), 0, bytes, index, getLNAME().length);
        index += getLNAME().length;
        System.arraycopy(getEFF_DATE().toString().getBytes(), 0, bytes, index, getEFF_DATE().toString().getBytes().length);
        index += getEFF_DATE().toString().getBytes().length;
        System.arraycopy(getEXP_DATE().toString().getBytes(), 0, bytes, index, getEXP_DATE().toString().getBytes().length);
        index += getEXP_DATE().toString().getBytes().length;
        System.arraycopy(getOPT_FLG().getBytes(), 0, bytes, index, getOPT_FLG().getBytes().length);
        index += getOPT_FLG().getBytes().length;
        System.arraycopy(getCNTY1().getBytes(), 0, bytes, index, getCNTY1().getBytes().length);
        index += getCNTY1().getBytes().length;
        System.arraycopy(getCNTY2().getBytes(), 0, bytes, index, getCNTY2().getBytes().length);
        index += getCNTY2().getBytes().length;
        System.arraycopy(getCNTY3().getBytes(), 0, bytes, index, getCNTY3().getBytes().length);
        index += getCNTY3().getBytes().length;
        System.arraycopy(getCKFLG().getBytes(), 0, bytes, index, getCKFLG().getBytes().length);
        index += getCKFLG().getBytes().length;
        System.arraycopy(getREAL_GL().getBytes(), 0, bytes, index, getREAL_GL().getBytes().length);
        index += getREAL_GL().getBytes().length;
        System.arraycopy(getMEMO_GL().getBytes(), 0, bytes, index, getMEMO_GL().getBytes().length);
        index += getMEMO_GL().getBytes().length;
        for (int i = 0; i < REL_ITMS.size(); i++){
            byte[] relBytes = getREL_ITMS().get(i).objectToByte(75);
            System.arraycopy(relBytes, 0, bytes, index, relBytes.length);
            index += relBytes.length;
        }
        System.arraycopy(getUPD_TLR().getBytes(), 0, bytes, index, getUPD_TLR().getBytes().length);
        index += getUPD_TLR().getBytes().length;
        System.arraycopy(getUPD_DATE().toString().getBytes(), 0, bytes, index, getUPD_DATE().toString().getBytes().length);
        index += getUPD_DATE().toString().getBytes().length;
        System.arraycopy(getUPD_TIME().toString().getBytes(), 0, bytes, index, getUPD_TIME().toString().getBytes().length);
        index += getUPD_TIME().toString().getBytes().length;
        System.arraycopy(getSUP_TEL1().getBytes(), 0, bytes, index, getSUP_TEL1().getBytes().length);
        index += getSUP_TEL1().getBytes().length;
        System.arraycopy(getSUP_TEL2().getBytes(), 0, bytes, index, getSUP_TEL2().getBytes().length);
        return bytes;
    }
}
