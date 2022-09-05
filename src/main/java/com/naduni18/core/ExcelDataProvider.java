package com.naduni18.core;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataProvider {

public static Map<String, String> valuemap= new HashMap<String, String>();
public static Map<String,String> locatormap= new HashMap<String, String>();
String currentDirectory = System.getProperty("user.dir");
    public Map<String, String> getSheetLocatorData(String sheetname) throws Exception {
        FileInputStream file = new FileInputStream(currentDirectory+"\\src\\test\\TestData\\MainDataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String SheetName = workbook.getSheetName(i);

            if (sheetname.equals(SheetName)) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                int lastRow = sheet.getLastRowNum();
                for (int j = 0; j <= lastRow; j++) {

                    XSSFRow row = sheet.getRow(j);

                    XSSFCell LocatorCell = row.getCell(1);
                    XSSFCell NameCell = row.getCell(0);

                    String locator = LocatorCell.getStringCellValue().trim();
                    String name = NameCell.getStringCellValue().trim();

                    // Putting key & value in dataMap
                    locatormap.put(name,locator);


                }
            }
        }

        return locatormap;
    }

    public Map<String, String> getSheetValueData(String sheetname) throws Exception {
        FileInputStream file = new FileInputStream(currentDirectory+"\\src\\test\\TestData\\MainDataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String SheetName = workbook.getSheetName(i);

            if (sheetname.equals(SheetName)) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                int lastRow = sheet.getLastRowNum();
                for (int j = 0; j <= lastRow; j++) {

                    XSSFRow row = sheet.getRow(j);

                    XSSFCell ValueCell = row.getCell(2);
                    XSSFCell NameCell = row.getCell(0);

                    String value = "";
                    if (ValueCell!=null) {
                        CellType typeval = ValueCell.getCellType();
                        if(typeval==CellType.STRING){
                            value = ValueCell.getStringCellValue().trim();
                        }else if(typeval==CellType.NUMERIC){
                            value = Double.toString(ValueCell.getNumericCellValue()).trim();
                        }

                    }
                    String name = NameCell.getStringCellValue().trim();

                    // Putting key & value in dataMap
                    valuemap.put(name, value);
                }
            }
        }
        return valuemap;
    }

    public static String getLocatorMapData(String key) {

        Map<String, String> m = locatormap;
        return m.get(key);

    }
    public static String geValueMapData(String key) {

        Map<String, String> m = valuemap;
        return m.get(key);

    }
}
