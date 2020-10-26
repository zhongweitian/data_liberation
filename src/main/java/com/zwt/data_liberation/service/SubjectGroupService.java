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
     * @param newBptparms excel生成的实体类
     */
    void multipleDataComparison(List<Bptparm> newBptparms);
}
