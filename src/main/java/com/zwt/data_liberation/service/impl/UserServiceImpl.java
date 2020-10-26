package com.zwt.data_liberation.service.impl;

import com.zwt.data_liberation.dao.master.UserDao;
import com.zwt.data_liberation.dao.second.SchoolDao;
import com.zwt.data_liberation.pojo.master.User;
import com.zwt.data_liberation.pojo.second.School;
import com.zwt.data_liberation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public User getUser(Long id) {
        User userVo = userDao.findById(id);
        School schoolVo = schoolDao.findByName("清华");
        System.out.println(userVo.getUserName());
        System.out.println(schoolVo.getSchoolName());
        return  userDao.findById(id);
    }
}
