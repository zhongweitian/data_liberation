package com.zwt.data_liberation.service.impl;

import com.zwt.data_liberation.constants.SubjectGroupSubscript;
import com.zwt.data_liberation.dao.second.BptparmDao;
import com.zwt.data_liberation.pojo.second.Bptparm;
import com.zwt.data_liberation.pojo.second.ParameterQuery;
import com.zwt.data_liberation.pojo.second.Subject;
import com.zwt.data_liberation.pojo.second.SubjectGroup;
import com.zwt.data_liberation.service.BptparmService;
import com.zwt.data_liberation.service.SubjectGroupService;
import com.zwt.data_liberation.util.DataUtils;
import com.zwt.data_liberation.util.DateUtils;
import com.zwt.data_liberation.util.ExcelUtils;
import com.zwt.data_liberation.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 13:56
 * 科目组服务类
 *
 */
@Service
public class SubjectGroupServiceImpl implements SubjectGroupService{

    @Autowired
    private BptparmService bptparmService;

    /**
     * 将excel的行数据转换成实体类
     * @param row 行数据
     * @return 实体类
     */
    @Override
    public byte[] entityToByte(List<Object> row) {
        SubjectGroup subjectGroup = new SubjectGroup();
        subjectGroup.setCOA_FLG(DataUtils.getStringValue(
                row, SubjectGroupSubscript.COA_FLG.getSubscript()));
        subjectGroup.setLNAME(DataUtils.getByteArrayValue(
                row, SubjectGroupSubscript.LNAME.getSubscript()));  //科目组长名
        subjectGroup.setEFF_DATE(DataUtils.getBigDecimalValue(
                row, SubjectGroupSubscript.EFF_DATE.getSubscript()));  //生效日
        subjectGroup.setEXP_DATE(DataUtils.getBigDecimalValue(
                row, SubjectGroupSubscript.EXP_DATE.getSubscript()));  //失效日
        subjectGroup.setCNTY1(DataUtils.getStringValue(
                row, SubjectGroupSubscript.CNTY1.getSubscript()));     //产品种类
        //处理科目数组，共60个
        List<Subject> subjects = new ArrayList<>();
        int size = row.size();
        for (int i = 0; i < 60; i++){
            Subject subject = new Subject();
            //科目，序号，备注下标
            int subjectNoSubscript =  SubjectGroupSubscript.ITM_NO_INIT.getSubscript() + i * 3;
            int seqNoSubscript = SubjectGroupSubscript.ITM_SEQ_INIT.getSubscript() + i * 3;
            int remarkSubscript = SubjectGroupSubscript.REMARK_INIT.getSubscript() + i * 3;
            //科目，序号，备注值
            String subjectNo = DataUtils.getStringValue(row, subjectNoSubscript);
            String seqNo = DataUtils.getStringValue(row, seqNoSubscript);
            String remark = DataUtils.getStringValue(row, remarkSubscript);
            if(size > subjectNoSubscript && !subjectNo.equalsIgnoreCase(" ")){
                //处理科目号
                subject.setITM_NO(FormatUtils.formatStr(subjectNo, 10));
            }
            if(size > seqNoSubscript && !seqNo.equalsIgnoreCase(" ")){
                //处理序号的值，使其00000 -> 00001
                subject.setITM_SEQ(FormatUtils.formatDecimal(subject.getITM_SEQ(), seqNo));
            }
            if (size > remarkSubscript && !remark.equalsIgnoreCase(" ")) {
                //处理备注
                subject.setREMARK(FormatUtils.formatBytes(
                        DataUtils.getByteArrayValue(row, remarkSubscript),60));
            }
            subjects.add(subject);
        }
        subjectGroup.setREL_ITMS(subjects);
        return subjectGroup.objectToByte(4745);
    }

    /**
     * 将excel文档转成实体类集合
     * @param filePath 文件名
     * @return 实体类
     */
    @Override
    public List<Bptparm> excelToEntities(String filePath) {
        java.util.List<Bptparm> bptparms = new ArrayList<>();
        try {
            //读取Excel
            List<java.util.List<Object>> lists = ExcelUtils.readExcel(new File(filePath));
            if (lists == null){
                System.out.println("不存在该文件");
                return null;
            }
            for (List<Object> list : lists) {
                //处理每行数据
                Bptparm bptparm = new Bptparm();
                bptparm.setTYPE(DataUtils.getStringValue(list,
                        SubjectGroupSubscript.TYPE.getSubscript()));
                bptparm.setCODE(DataUtils.getStringValue(list,
                        SubjectGroupSubscript.CODE.getSubscript()));
                bptparm.setEFF_DATE(DataUtils.getBigDecimalValue(list,
                        SubjectGroupSubscript.EFF_DATE.getSubscript()));
                bptparm.setEXP_DATE(DataUtils.getBigDecimalValue(list,
                        SubjectGroupSubscript.EXP_DATE.getSubscript()));
                bptparm.setTS(DateUtils.getTimestamp());
                byte[] bytes = entityToByte(list);
                bptparm.setVAL(bytes);
                bptparms.add(bptparm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bptparms;
    }

    /**
     * 数据对比
     * @param olbSubjectGroup 数据库里的科目组信息
     * @param newSubjectGroup excel生成的科目信息
     * @return 比对结果
     */
    @Override
    public boolean dataComparison(byte[] olbSubjectGroup, byte[] newSubjectGroup) {
        int length = olbSubjectGroup.length;
        if (newSubjectGroup.length != length){
            return false;
        }
        // TODO: 2020/10/26 可以进一步修改校验规则，以实现判断哪个不一致
        for (int i=0; i < length; i++){
            if (olbSubjectGroup[i] != newSubjectGroup[i]){
                System.out.println(new String(olbSubjectGroup, 0, olbSubjectGroup.length));
                System.out.println(new String(newSubjectGroup, 0, newSubjectGroup.length));
                return false;
            }
        }
        return true;
    }

    /**
     * 数据对比
     * @param newBptparms excel生成的实体类
     */
    @Override
    public void multipleDataComparison(List<Bptparm> newBptparms) {
        // TODO: 2020/10/25 后续进一步完善，可以测试一下是放在MAP快，还是数据库里快
        System.out.printf("开始数据对比，共比较%d条数据\r\n",newBptparms.size());
        int seq = 1;
        try {
            FileWriter out = new FileWriter("C:/Users/wilton/Desktop/check_result.txt",true);
            FileWriter oldData = new FileWriter("C:/Users/wilton/Desktop/old_data.txt",true);
            FileWriter newData = new FileWriter("C:/Users/wilton/Desktop/new_data.txt",true);
            for(Bptparm newBptparm : newBptparms){
                //获取数据库数据
                System.out.println(newBptparm.getCODE());
                Bptparm oldBptparm = bptparmService.findByTypeAndCode(new ParameterQuery(newBptparm));
                if(oldBptparm != null){
                    //新旧数据对比
                    if(!dataComparison(oldBptparm.getVAL(), newBptparm.getVAL())) {
                        out.write(seq +"----科目组:"+ newBptparm.getCODE().trim() + "数据不一致----\r\n");
                        out.write(new String(oldBptparm.getVAL(), 0, oldBptparm.getVAL().length) + "\r\n");
                        out.write(new String(newBptparm.getVAL(), 0, newBptparm.getVAL().length) + "\r\n");
                        oldData.write(new String(oldBptparm.getVAL(), 0, oldBptparm.getVAL().length) + "\r\n");
                        newData.write(new String(newBptparm.getVAL(), 0, oldBptparm.getVAL().length) + "\r\n");
                        System.out.printf("%d.科目组%s与数据库不匹配\r\n", seq++,newBptparm.getCODE().trim());
                    }
                }else{
                    System.out.printf("科目组%s不存在\r\n",newBptparm.getCODE());
                }
            }
            out.flush();
            out.close();
            oldData.flush();
            oldData.close();
            newData.flush();
            newData.close();
            System.out.println("数据比较结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
