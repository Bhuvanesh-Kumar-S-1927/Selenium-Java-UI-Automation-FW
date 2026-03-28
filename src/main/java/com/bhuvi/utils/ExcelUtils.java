package com.bhuvi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bhuvi.constants.FrameworkConstants;
import com.bhuvi.exceptions.FrameworkExceptions;
import com.bhuvi.exceptions.InvalidExcelFilePathException;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetname) {

        List<Map<String, String>> list = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath());
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetname);

            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= lastRowNum; i++) {

                Map<String, String> map = new HashMap<>();
                Row currentRow = sheet.getRow(i);

                for (int j = 0; j < lastColNum; j++) {

                    Cell headerCell = sheet.getRow(0).getCell(j);
                    Cell valueCell = currentRow.getCell(j);

                    String key = formatter.formatCellValue(headerCell);
                    String value = formatter.formatCellValue(valueCell);

                    map.put(key, value);
                }

                list.add(map);
            }

        } catch (IOException e) {
            throw new FrameworkExceptions("Can't able to read the excel file");
        }
        

        return list;
    }
}
