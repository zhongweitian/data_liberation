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
        // TODO: 2020/10/26 把bptparmService相关的处理全都抽取到SubjectGroupService中，并加入校验 
        //将excel转成对应的实体类
        List<Bptparm> bptparms = subjectGroupService.excelToEntities("C:/Users/wilton/Desktop/subjectGroup.xlsx");
        //数据对比
        if(bptparms != null){
            subjectGroupService.multipleDataComparison(bptparms);
        }
        return true;
    }


    @RequestMapping(value = "/insert/single")
    @Transactional
    public String insertSingle() {
        System.out.println("开始插入");
        List<Bptparm> bptparms = subjectGroupService.excelToEntities("C:/Users/wilton/Desktop/subjectGroup1.xlsx");
        if (bptparms == null)
            return "";
        bptparmService.insertSingle(bptparms.get(0));
        //数据对比
        System.out.println("插入结束");
        return "";
    }

    @RequestMapping(value = "/insert/bulk")
    @Transactional
    public String insertBulk() {
        List<Bptparm> bptparms = subjectGroupService.excelToEntities("C:/Users/wilton/Desktop/subjectGroup1.xlsx");
        if (bptparms == null)
            return "";
        bptparmService.insertBulk(bptparms);
        return "";
    }

    @RequestMapping(value = "/update/single")
    @Transactional
    public String updateSingle() {
        System.out.println("开始更新");
        List<Bptparm> bptparms = subjectGroupService.excelToEntities("C:/Users/wilton/Desktop/subjectGroup1.xlsx");
        if (bptparms == null)
            return "";
        bptparmService.updateSingle(bptparms.get(0));
        System.out.println("更新结束");
        return "";
    }

    @RequestMapping(value = "/update/bulk")
    @Transactional
    public String updateBulk() {
        List<Bptparm> bptparms = subjectGroupService.excelToEntities("C:/Users/wilton/Desktop/subjectGroup1.xlsx");
        if (bptparms == null)
            return "";
        bptparmService.updateBulk(bptparms);
        return "";
    }
}

