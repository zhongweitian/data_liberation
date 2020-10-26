package com.zwt.data_liberation.controller;

import com.zwt.data_liberation.pojo.master.User;
import com.zwt.data_liberation.pojo.second.Bptparm;
import com.zwt.data_liberation.service.BptparmService;
import com.zwt.data_liberation.service.SubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:24
 */
@Controller
@RequestMapping(value = "/api/subject_group/")
public class SubjectGroupController {

    @Autowired
    private BptparmService bptparmService;
    @Autowired
    private SubjectGroupService subjectGroupService;

    @RequestMapping(value = "/comparison")
    @ResponseBody
    public boolean multipleDataComparison() {
        subjectGroupService.multipleDataComparison("C:/Users/wilton/Desktop/subjectGroup.xlsx");
        return true;
    }


    @RequestMapping(value = "/insert/single")
    @Transactional
    public String insertSingle() {
        return "";
    }

    @RequestMapping(value = "/insert/bulk")
    @Transactional
    public String insertBulk() {
        return "";
    }

    @RequestMapping(value = "/update/single")
    @Transactional
    public String updateSingle() {
        return "";
    }

    @RequestMapping(value = "/update/bulk")
    @Transactional
    public String updateBulk() {
        return "";
    }
}

