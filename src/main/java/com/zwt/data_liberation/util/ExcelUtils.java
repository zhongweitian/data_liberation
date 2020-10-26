package com.zwt.data_liberation.util;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/1/17 16:37
 * POI工具类，用于操作Excel
 */
public class ExcelUtils {
    /**
     * 防止实例化
     */
    private ExcelUtils() {
    }

    /**
     * 开始逐行读取excel数据
     * @param sheet Excel表
     * @return 所有数据的集合
     */
    private static List<List<Object>> startReadExcel(XSSFSheet sheet){
        List<List<Object>> list = new LinkedList<>();
        XSSFRow row = null;
        XSSFCell cell = null;
        //逐行读取Excel表
        for (int i = (sheet.getFirstRowNum() + 1); i <= (sheet.getPhysicalNumberOfRows() - 1); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            //每行数据存储在一个list中
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                Object value = null;
                cell = row.getCell(j);
                if (cell == null || row.getPhysicalNumberOfCells()==0) {
                    continue;
                }
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        //String类型返回String数据
                        value = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        //日期数据返回LONG类型的时间戳
                        if ("yyyy\"年\"m\"月\"d\"日\";@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = DateUtils.getMillis(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())) / 1000;
                        } else {
                            //数值类型返回double类型的数字
                            DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
                            value = String.valueOf(decimalFormat.format(cell.getNumericCellValue()));
                        }
                        break;
                    case BOOLEAN:
                        //布尔类型
                        value = cell.getBooleanCellValue();
                        break;
                    case BLANK:
                        //空单元格
                        break;
                    default:
                        value = cell.toString();
                }
                if (value != null && !value.equals("")) {
                    //单元格不为空，则加入列表
                    linked.add(value);
                }
            }
            if (linked.size()!= 0) {
                //把每一行数据添加到总的List中
                list.add(linked);
            }
        }
        return list;
    }

    /**
     * 要求excel版本在2007以上
     *
     * @param file 文件信息
     * @return
     * @throws Exception
     */
    public static List<List<Object>> readExcel(File file) throws Exception {
        if(!file.exists()){
            return null;
        }
        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
        // 读取第一张表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        return startReadExcel(sheet);
    }

    /**
     * 要求excel版本在2007以下
     *
     * @param fileInputStream 文件信息
     * @return
     * @throws Exception
     */
    public static List<List<Object>> readExcel(FileInputStream fileInputStream) throws Exception {
        XSSFWorkbook xwb = new XSSFWorkbook(fileInputStream);
        //读取第一张表格内容
        XSSFSheet sheet = xwb.getSheetAt(1);
        return startReadExcel(sheet);
    }

    /**
     * 导出excel
     * @param excelPath 导出的excel路径（需要带.xlsx)
     * @param headList  excel的标题备注名称
     * @param fieldList excel的标题字段（与数据中map中键值对应）
     * @param dataList  excel数据
     * @throws Exception
     */
    public static void createExcel(String excelPath, String[] headList,
                                   String[] fieldList, List<Map<String, Object>> dataList)
            throws Exception {
        // 创建新的Excel 工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值
        XSSFSheet sheet = workbook.createSheet();
        // 在索引0的位置创建行（最顶端的行）
        XSSFRow row = sheet.createRow(0);
        // 设置excel头（第一行）的头名称
        for (int i = 0; i < headList.length; i++) {

            // 在索引0的位置创建单元格（左上端）
            XSSFCell cell = row.createCell(i);
            // 定义单元格为字符串类型
            cell.setCellType(CellType.STRING);
            // 在单元格中输入一些内容
            cell.setCellValue(headList[i]);
        }
        //添加数据
        for (int n = 0; n < dataList.size(); n++) {
            // 在索引1的位置创建行（最顶端的行）
            XSSFRow row_value = sheet.createRow(n + 1);
            Map<String, Object> dataMap = dataList.get(n);
            for (int i = 0; i < fieldList.length; i++) {

                // 在索引0的位置创建单元格（左上端）
                XSSFCell cell = row_value.createCell(i);
                // 定义单元格为字符串类型
                cell.setCellType(CellType.STRING);
                // 在单元格中输入一些内容
                if (dataMap.get(fieldList[i]) != null){
                    cell.setCellValue((dataMap.get(fieldList[i])).toString());
                }
            }
        }
        // 新建一输出文件流
        FileOutputStream fos = new FileOutputStream(excelPath);
        // 把相应的Excel 工作簿存盘
        workbook.write(fos);
        fos.flush();
        // 操作结束，关闭文件
        fos.close();
    }
}