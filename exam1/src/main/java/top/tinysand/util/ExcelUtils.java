package top.tinysand.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import top.tinysand.model.vo.StudentVo;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtils {
    //获取excel表对象
    public static Workbook openWorkbook(InputStream inputStream, String postfix) {
        Workbook workbook = null;
        try {
            if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix))
                workbook = new HSSFWorkbook(inputStream);
            else if (OFFICE_EXCEL_2007_POSTFIX.equals(postfix))
                workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
                return null;
        }
        return workbook;
    }

    //通过excel表获取学生数据
    public static List<StudentVo> getStudentsByExcel(Workbook workbook) {
        List<StudentVo> studentVos = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        int maxCellNumber = 0;
        int maxRowNumber = sheet.getLastRowNum();
        StudentVo studentVo = null;
        for (int currentRowIndex = 1; currentRowIndex <= maxRowNumber; currentRowIndex ++ )
        {
            Row row = sheet.getRow(currentRowIndex);
            maxCellNumber = row.getLastCellNum();
            studentVo = new StudentVo();
            for (int currentCellNumber = 0; currentCellNumber < maxCellNumber; currentCellNumber ++)
            {
                Cell cell = row.getCell(currentCellNumber);
                switch (currentCellNumber) {
                    case 0:
                        cell.setCellType(CellType.STRING);
                        studentVo.setUserId(new String(cell.getStringCellValue()
                                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                    break;

                    case 1:
                        cell.setCellType(CellType.STRING);
                        studentVo.setUserName(cell.getStringCellValue());
                    break;

                    case 2:
                        cell.setCellType(CellType.STRING);
                        String gender = cell.getStringCellValue();

                    if (GENDER_MALE_STRING.equals(gender))
                        studentVo.setGender(GENDER_MALE_INTEGER);
                    else if (GENDER_FEMALE_STRING.equals(gender))
                        studentVo.setGender(GENDER_FEMALE_INTEGER);
                    break;

                    case 3:
                        cell.setCellType(CellType.STRING);
                        studentVo.setTel(cell.getStringCellValue());
                    break;

                    case 4:
                        cell.setCellType(CellType.STRING);
                        studentVo.setEmail(cell.getStringCellValue());
                    break;

                    case 5:
                        cell.setCellType(CellType.STRING);
                        studentVo.setAddress(cell.getStringCellValue());
                    break;

                    case 6:
                        cell.setCellType(CellType.STRING);
                        studentVo.setBirthday(cell.getDateCellValue());
                    break;

                    case 7:
                        cell.setCellType(CellType.STRING);
                        studentVo.setPassword
                            (ExcelUtils.md5Encode(cell.getStringCellValue()));
                    break;

                    default: break;
                }
            }

            studentVo.setPassword("2343434");
            try {
                studentVo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-11"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            studentVo.setGender(1);
            System.out.println("添加一个学生");
            studentVos.add(studentVo);
        }

        return studentVos;
    }

    public static String md5Encode(String data) {
        String result = null;
        try {
            result = Arrays.toString(MessageDigest.getInstance("MD5").digest(data.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static final String GENDER_MALE_STRING = "男";
    private static final Integer GENDER_MALE_INTEGER = 0;

    private static final String GENDER_FEMALE_STRING = "女";
    private static final Integer GENDER_FEMALE_INTEGER = 1;


    public static final String OFFICE_EXCEL_2007_POSTFIX = ".xlsx";
    public static final String OFFICE_EXCEL_2003_POSTFIX = ".xls";
}
