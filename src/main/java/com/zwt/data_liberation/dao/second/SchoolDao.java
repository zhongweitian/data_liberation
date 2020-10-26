package com.zwt.data_liberation.dao.second;

import com.zwt.data_liberation.pojo.master.User;
import com.zwt.data_liberation.pojo.second.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:19
 */
@Repository
public interface SchoolDao {
    School findByName(@Param(value = "schoolName") String name);
}
