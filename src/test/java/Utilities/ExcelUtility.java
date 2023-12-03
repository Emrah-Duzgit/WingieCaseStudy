package Utilities;

import Pages.DialogContent;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {


    public static ArrayList< ArrayList< String > > getListData(String path, String sheetName, int columnCount){
        ArrayList< ArrayList< String > > table=new ArrayList<>();

        Workbook workbook=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet page=workbook.getSheet(sheetName);

        for (int i = 0; i < page.getPhysicalNumberOfRows(); i++) {

            ArrayList<String> rowData=new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                rowData.add( page.getRow(i).getCell(j).toString());
            }

            table.add(rowData);
        }

        return table;
    }

    public static void writeExcel(String path, Scenario scenario, String browserName, String time) {

        File f=new File(path);

        if (!f.exists()){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Page1");
            Row newRow = sheet.createRow(0);

            DialogContent dc = new DialogContent();

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            FileInputStream inputStream= null;
            Workbook workbook=null;
            try {
                inputStream = new FileInputStream(path);
                workbook= WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet=workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(rowCount);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                inputStream.close();
                FileOutputStream outputStream=new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
