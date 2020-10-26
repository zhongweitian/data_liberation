package com.zwt.data_liberation.service.impl;

import com.zwt.data_liberation.dao.second.BptparmDao;
import com.zwt.data_liberation.pojo.second.Bptparm;
import com.zwt.data_liberation.pojo.second.ParameterQuery;
import com.zwt.data_liberation.pojo.second.Subject;
import com.zwt.data_liberation.pojo.second.SubjectGroup;
import com.zwt.data_liberation.service.BptparmService;
import com.zwt.data_liberation.util.DateUtils;
import com.zwt.data_liberation.util.ExcelUtils;
import com.zwt.data_liberation.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 14:11
 * 实际对参数表进行CRUD的服务
 */
@Service
public class BptparmServiceImpl implements BptparmService {

    @Autowired
    private BptparmDao bptparmDao;

   //@Override
   //public byte[] entityToByte(List<Object> row) {
   //    SubjectGroup subjectGroup = new SubjectGroup();
   //    subjectGroup.setCOA_FLG((String) row.get(4));
   //    //glmData.setSNAME((String) list.get(6));
   //    subjectGroup.setLNAME(((String)row.get(5)).getBytes());
   //    subjectGroup.setEFF_DATE(new BigDecimal((String)row.get(6)));
   //    subjectGroup.setEXP_DATE(new BigDecimal((String)row.get(7)));
   //    //subjectGroup.setOPT_FLG((String)row.get(9));
   //    subjectGroup.setCNTY1((String)row.get(1));
   //    //subjectGroup.setCNTY2((String)row.get(11));
   //    //subjectGroup.setCNTY3((String)row.get(12));
   //    //subjectGroup.setCKFLG((String)row.get(13));
   //    //subjectGroup.setREAL_GL((String)row.get(14));
   //    //subjectGroup.setMEMO_GL((String)row.get(15));
   //    //subjectGroup.setUPD_TLR((String)row.get(16));
   //    //subjectGroup.setUPD_DATE(new BigDecimal((String)row.get(17)));
   //    //subjectGroup.setSUP_TEL1((String)row.get(18));
   //    //subjectGroup.setSUP_TEL2((String)row.get(19));
   //    //开始导入数组
   //    int[] initIndex = {8,10,9};
   //    List<Subject> subjects = new ArrayList<>();
   //    int size = row.size();
   //    for (int i = 0; i < 60; i++){
   //        Subject subject = new Subject();
   //        if(size > (initIndex[0] + i * 3) && !((String)row.get(initIndex[0] + i * 3)).equalsIgnoreCase(" ")){
   //            subject.setITM_NO(FormatUtils.formatStr((String)row.get(initIndex[0] + i * 3), 10));
   //        }
   //        if(size > (initIndex[1] + i * 3) && !((String)row.get(initIndex[1] + i * 3)).equalsIgnoreCase(" ")){
   //            //序号
   //            String s = (String)row.get(initIndex[1] + i * 3);
   //            int length = ((String)row.get(initIndex[1] + i * 3)).length();
   //            StringBuilder sb = new StringBuilder(subject.getITM_SEQ());
   //            sb.replace(5 - length,6, s);
   //            subject.setITM_SEQ(sb.toString());
   //        }
   //        if (size > (initIndex[2] + i * 3) && !((String)row.get(initIndex[2] + i * 3)).equalsIgnoreCase(" ")) {
   //            subject.setREMARK(FormatUtils.formatBytes(((String)row.get(initIndex[2] + i * 3)).getBytes(),60));
   //        }
   //        subjects.add(subject);
   //    }
   //    subjectGroup.setREL_ITMS(subjects);
   //    return subjectGroup.objectToByte(4745);
   //}

   //@Override
   //public List<Bptparm> excelToEntities(String filePath, int type) {
   //    java.util.List<Bptparm> bptparms = new ArrayList<>();
   //    try {
   //        //读取Excel
   //        java.util.List<java.util.List<Object>> lists = ExcelUtils.readExcel(new File(filePath));
   //        if (lists == null){
   //            System.out.println("不存在该文件");
   //            return null;
   //        }
   //        for (int i = 0; i < lists.size(); i++){
   //            //取出一行
   //            java.util.List<Object> list = lists.get(i);
   //            Bptparm bptparm = new Bptparm();
   //            bptparm.setTYPE((String)list.get(0));
   //            bptparm.setCODE((String)list.get(3));
   //            bptparm.setEFF_DATE(new BigDecimal((String)list.get(6)));
   //            bptparm.setEXP_DATE(new BigDecimal((String)list.get(7)));
   //            //bptparm.setDESC((String)list.get(6));
   //            //bptparm.setCDESC((String)list.get(6));
   //            //bptparm.setUPD_DATE(new BigDecimal((String)list.get(6)));
   //            //bptparm.setUPD_BR(new BigDecimal((String)list.get(7)));
   //            //bptparm.setUPD_TLR((String)list.get(8));
   //            bptparm.setTS(DateUtils.getTimestamp());
   //            byte[] bytes = (type == ACM_TYP) ? entityToByte(lists.get(i)) : entityToByte(lists.get(i));
   //            bptparm.setVAL(bytes);
   //            bptparms.add(bptparm);
   //        }
   //    } catch (Exception e) {
   //        e.printStackTrace();
   //    }
   //    return bptparms;
   //}

    @Override
    public Bptparm findByTypeAndCode(ParameterQuery parameterQuery) {
        return bptparmDao.findByTypeAndCode(parameterQuery);
    }

    @Override
    public int insertSingle(Bptparm bptparm) {
        return bptparmDao.insertSingle(bptparm);
    }

    @Override
    public int insertBulk(List<Bptparm> bptparms) {
        return bptparmDao.insertBulk(bptparms);
    }

    @Override
    public int updateSingle(Bptparm bptparm) {
        return bptparmDao.updateSingle(bptparm);
    }

    @Override
    public int updateBulk(List<Bptparm> bptparms) {
        return bptparmDao.updateBulk(bptparms);
    }
}
