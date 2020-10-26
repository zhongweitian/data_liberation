package com.zwt.data_liberation.service;

import com.zwt.data_liberation.pojo.second.Bptparm;

import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 13:25
 * 科目组服务接口
 */
public interface SubjectGroupService {
    int CREATE_TYP = 1;
    int UPDATE_TYP = 2;

    /**
     * 将实体类转换成Byte[]
     * @param row 行数据
     * @return Byte[]
     */
    byte[] entityToByte(List<Object> row);

    /**
     * 将excel转换成实体类集合
     * @param filePath 文件名
     * @return 转换后的实体类集合
     */
    List<Bptparm> excelToEntities (String filePath);

    /**
     * 数据比对
     * @param oldSubjectGroup 表里的科目组信息
     * @param newSubjectGroup excel生成的科目信息
     * @return 返回比较结果，true一致，false不一致
     */
    boolean dataComparison(byte[] oldSubjectGroup, byte[] newSubjectGroup);

    /**
     * 多数据对比
     * @param filePath 要对比的excel文件地址
     */
    void multipleDataComparison(String filePath);

    /**
     * 新增或增加，后续可能会增加删除
     * @param filePath 文件名
     * @param type 功能类型，1-新增，2-修改
     * @param single 是否单条，true是，false批量
     * @return
     */
    int createOrUpdate(String filePath, int type, boolean single);
}
