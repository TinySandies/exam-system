package top.tinysand.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.DecimalFormat;

public class ExcelParser {
    public static void main(String[] args) throws Exception {
        String excelPath = "F:\\IdeaProjects\\MavenProjects\\WebProjects\\exam-system\\exam1\\target\\exam-1\\upload\\test.xlsx";
        //创建excel文件对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(excelPath));
        //遍历Excel表
        for (int sheetIndex = 0; sheetIndex < xssfWorkbook.getNumberOfSheets(); sheetIndex++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
            if (xssfSheet != null) //遍历excel表中每一行
                for (int rowIndex = 1; rowIndex <= xssfSheet.getLastRowNum(); rowIndex++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowIndex);
                    if (xssfRow != null) {  //行不为空，获取列数据
                        XSSFCell userName = xssfRow.getCell(0);
                        XSSFCell password = xssfRow.getCell(1);
                        XSSFCell age      = xssfRow.getCell(2);
                        XSSFCell sex      = xssfRow.getCell(3);
                        XSSFCell email    = xssfRow.getCell(4);
                        XSSFCell remark   = xssfRow.getCell(5);

                        System.out.println("userName: " + getValue(userName));
                        System.out.println("password: " + getValue(password));
                        System.out.println("age: " + getValue(age));
                        System.out.println("sex: " + getValue(sex));
                        System.out.println("email: " + getValue(email));
                        System.out.println("remark: " + getValue(remark));
                    }
                }
        }
        xssfWorkbook.close();
    }

    private static String getValue(XSSFCell xssfCell) { // 列数据处理
        if (xssfCell == null) return "";
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) { //布尔型数据处理
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) { //数值型数据处理
            DecimalFormat decimalFormat = new DecimalFormat("0");
            return decimalFormat.format(xssfCell.getNumericCellValue());
        } else {
            return String.valueOf(xssfCell.getStringCellValue()); //字符串处理
        }
    }
}
