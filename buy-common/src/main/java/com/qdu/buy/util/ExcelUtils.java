package com.qdu.buy.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Descripition: Copyright: Copyright(c)2017
 * Company: 八维通科技有限公司
 * @Author: xiepf
 * @Date: 2017/12/21 17:20
 * @Version: 1.0
 */
@Slf4j
public class ExcelUtils {

    public static String processFileName(HttpServletRequest request, String fileName) {
        try {
            String codeFileName = "";
            String agent = request.getHeader("User-Agent");
            if (agent != null) {
                agent = agent.toUpperCase();
            }
            if (null == agent) {
                codeFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            } else if (-1 != agent.indexOf("MSIE") || -1 != agent.indexOf("TRIDENT") || -1 != agent.indexOf("EDGE")) {
                codeFileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                codeFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            return codeFileName;
        } catch (Exception e) {
            log.error("文件名编码异常",e);
            return fileName;
        }
    }

    /**
     * 加载文件模板
     *
     * @param filePath
     * @return
     */
    public static HSSFWorkbook loadFileTemplate(String filePath) throws IOException {
        // 文件模板路径
        InputStream in = null;
        try {
            in = new FileInputStream(new File(filePath));
            HSSFWorkbook workbook = new HSSFWorkbook(in);
            return workbook;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("IO关闭异常：", e);
                }
            }
        }
    }

    /**
     * 获取单元格内容
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        switch (cell.getCellTypeEnum()) {
            case NUMERIC: // 数字
                //如果为时间格式的内容
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell. getNumericCellValue()));
                    break;
                } else {
                    cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
                }
                break;
            case STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case BLANK: // 空值
                cellValue = "";
                break;
            case ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     *
     * @Title: createExcelFile
     * @Description: 在填充sheet数据的时候,会需要一个空的Excel文件,用于设置Sheet信息的时候用到
     * @return 一个不带有头信息,数据信息的空的excel文件
     * @return: HSSFWorkbook
     */
    public static HSSFWorkbook createExcelFile() {
        HSSFWorkbook wb = new HSSFWorkbook();
        return wb;
    }


    /**
     *
     * @Title: createExcelFile
     * @Description: 创建一个空的带有头信息的excel
     * @param fileName
     * @param heads
     * @return
     * @return: HSSFWorkbook
     */
    public static HSSFWorkbook createExcelFile(String fileName,
                                               List<String> heads) {
        HSSFWorkbook wb = new HSSFWorkbook();
        if (StringUtils.isEmpty(fileName) || null == heads) {
            return null;
        } else {
            HSSFSheet sheet = wb.createSheet(fileName);
            HSSFRow row = sheet.createRow(0);
            // 封装头信息
            for (int index = 0; index < heads.size(); index++) {
                row.createCell(index).setCellValue(heads.get(index));
            }
        }
        return wb;
    }

    /**
     * @Title: createExcelFile
     * @Description: 创建excel,带有头信息和数据
     * @param fileName
     *            excel表格文件名称
     * @param heads
     *            excel表格的头信息
     * @param dataList
     *            excel表格要填充的数据
     * @return
     * @throws IOException
     * @return: HSSFWorkbook
     */
    public static HSSFWorkbook createExcelFile(String fileName,
                                               List<String> heads, List<List<String>> dataList) {
        HSSFWorkbook wb = new HSSFWorkbook();
        if (StringUtils.isEmpty(fileName) || null == heads || null == dataList) {
            return null;
        } else {
            HSSFSheet sheet = wb.createSheet(fileName);
            HSSFRow row = sheet.createRow(0);
            // 封装头信息
            for (int index = 0; index < heads.size(); index++) {
                row.createCell(index).setCellValue(heads.get(index));
            }
            // 填充数据信息
            for (int i = 0; i < dataList.size(); i++) {
                HSSFRow row_data = sheet.createRow(i + 1);
                for (int j = 0; j < dataList.get(i).size(); j++) {
                    row_data.createCell(j).setCellValue(dataList.get(i).get(j));
                }
            }
        }
        return wb;
    }


}
