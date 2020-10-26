package com.zwt.data_liberation.dao.second;

import com.zwt.data_liberation.pojo.second.Bptparm;
import com.zwt.data_liberation.pojo.second.ParameterQuery;
import com.zwt.data_liberation.pojo.second.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:19
 */
@Repository
public interface BptparmDao {
    /**
     * 根据参数类型和参数码查找
     * @param parameterQuery 查询条件
     * @return 参数实体类
     */
    Bptparm findByTypeAndCode(ParameterQuery parameterQuery);

    /**
     * 单条插入
     * @param bptparm 要插入的数据
     * @return 插入行数
     */
    int insertSingle(@Param("bptparm") Bptparm bptparm);


    /**
     * 批量插入
     * @param bptparms 要插入的集合
     * @return 插入行数
     */
    int insertBulk(@Param("bptparms") List<Bptparm> bptparms);

    /**
     * 单条更新
     * @param bptparm 要更新的实体类
     * @return 更新条数
     */
    int updateSingle(@Param("bptparm") Bptparm bptparm);

    /**
     * 批量更新
     * @param bptparms 要更新的集合
     * @return 更新行数
     */
    int updateBulk(@Param("bptparms") List<Bptparm> bptparms);
}
