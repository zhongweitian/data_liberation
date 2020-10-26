package com.zwt.data_liberation.constants;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 21:25
 * 科目组导入的下标
 */
public enum SubjectGroupSubscript {
    TYPE(0),
    CODE(3),
    COA_FLG(4),
    //SNAME(5),
    LNAME(5),
    EFF_DATE(6),
    EXP_DATE(7),
    //OPT_FLG(),
    CNTY1(1),
    //CNTY2(),
    //CNTY3(),
    //CKFLG(),
    //REAL_GL(),
    //MEMO_GL(),
    //UPD_TLR(),
    //UPD_DATE(),
    //UPD_TIME(),
    //SUP_TEL1(),
    //SUP_TEL2(),
    ITM_NO_INIT(8),
    ITM_SEQ_INIT(10),
    REMARK_INIT(9);

    private int subscript;

    SubjectGroupSubscript(int subscript) {
        this.subscript = subscript;
    }

    public int getSubscript() {
        return subscript;
    }

    public void setSubscript(int subscript) {
        this.subscript = subscript;
    }}
