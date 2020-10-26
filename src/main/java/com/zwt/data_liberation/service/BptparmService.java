package com.zwt.data_liberation.service;

import com.zwt.data_liberation.pojo.second.Bptparm;
import com.zwt.data_liberation.pojo.second.ParameterQuery;

import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 14:08
 * 参数表服务接口，这个只做最基础的CRUD，其他放在具体的Service来做
 */
public interface BptparmService {

    /**
     * 将实体类转换成Byte[]
     * @param row 行数据
     * @return Byte[]
     */
    //byte[] entityToByte(List<Object> row);

    /**
     * 将excel转换成实体类集合
     * @param filePath 文件名
     * @param type 转换类型
     * @return 转换后的实体类集合
     */
     //List<Bptparm> excelToEntities (String filePath, int type);

    /**
     * 根据参数类型和参数码查找对应的参数
     * @param parameterQuery 查询条件
     * @return 参数实体类
     */
    Bptparm findByTypeAndCode(ParameterQuery parameterQuery);

    /**
     * 插入单条数据
     * @param bptparm 参数
     * @return 插入条数
     */
    int insertSingle(Bptparm bptparm);

    /**
     * 批量插入参数数据
     * @param bptparms 参数集合
     * @return 插入条数
     */
    int insertBulk(List<Bptparm> bptparms);

    /**
     * 更新单条数据
     * @param bptparm 参数
     * @return 更新条数
     */
    int updateSingle(Bptparm bptparm);

    /**
     * 批量更新参数数据
     * @param bptparms 参数集合
     * @return 更新条数
     */
    int updateBulk(List<Bptparm> bptparms);

}
