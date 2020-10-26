package com.zwt.data_liberation.pojo.second;


import com.zwt.data_liberation.util.FormatUtils;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/5/5 13:49
 * 科目组里的科目信息
 */
public class Subject {
    private String ITM_NO = FormatUtils.formatStr("", 10);//char[10]，科目号
    private String ITM_SEQ = FormatUtils.formatStr("00000", 5);;//Decimal,5，科目序号
    private byte[] REMARK = FormatUtils.formatBytes("".getBytes(),60);//blob 60，备注

    public String getITM_NO() {
        return ITM_NO;
    }

    public void setITM_NO(String ITM_NO) {
        this.ITM_NO = FormatUtils.formatStr(ITM_NO, 10);
    }

    public String getITM_SEQ() {
        return ITM_SEQ;
    }

    public void setITM_SEQ(String ITM_SEQ) {
        this.ITM_SEQ = FormatUtils.formatStr(ITM_SEQ, 5);
    }

    public byte[] getREMARK() {
        return REMARK;
    }

    public void setREMARK(byte[] REMARK) {
        this.REMARK = FormatUtils.formatBytes(REMARK, 60);
    }

    public byte[] objectToByte(int size){
        byte[] bytes = new byte[size];
        //转换成byte[]
        System.arraycopy(getITM_NO().getBytes(), 0, bytes, 0, getITM_NO().getBytes().length);
        int index = getITM_NO().getBytes().length;
        System.arraycopy(getITM_SEQ().getBytes(), 0, bytes, index, getITM_SEQ().getBytes().length);
        index += getITM_SEQ().getBytes().length;
        System.arraycopy(getREMARK(), 0, bytes, index, getREMARK().length);
        return bytes;
    }
}
