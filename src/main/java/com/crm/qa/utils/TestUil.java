package com.crm.qa.utils;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;
    public static String TESTDATA_SHEET_PATH= "C:\\Users\\Dell\\IdeaProjects\\FrameWorkFromScrachPOM\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";

    static XSSFWorkbook workbook;
    static DataFormatter dataFormatter=new DataFormatter();
    public void switchToFrame()
    {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName)
    {
        FileInputStream fis=null;
        try
        {
            fis=new FileInputStream(TESTDATA_SHEET_PATH);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
          workbook =new XSSFWorkbook(fis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        XSSFSheet sheet= workbook.getSheet(sheetName);
        int rowCount= sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object data[][]=new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++)
        {
            row=sheet.getRow(i+1);
            for(int j=0;j<colCount;j++)
            {
                XSSFCell cell=row.getCell(j);
                data[i][j]=dataFormatter.formatCellValue(cell);
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
