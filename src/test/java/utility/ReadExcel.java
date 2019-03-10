package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadExcel {

public static XSSFWorkbook workbook;
public static XSSFSheet worksheet;
public static DataFormatter formatter= new DataFormatter();
public static String file_location = ".\\src\\test\\resources\\DataSheet\\HRM.xlsx";
static String SheetName= "Login_Details";
public  String Res;

	

@DataProvider(name="userData")
public Object[][] userFormData() throws Exception
{
    Object[][] data = testData(file_location, "Login_Details");
    return data;
}

@DataProvider(name="applyLeave")
public Object[][] applyLeaveData() throws Exception
{
    Object[][] data = testData(file_location, "Apply_Leave");
    return data;
}

@DataProvider(name="expense")
public Object[][] expenseData() throws Exception
{
    Object[][] data = testData(file_location, "Expenses_Data");
    return data;
}

public static Object[][] testData(String file_location,String SheetName) throws IOException
{
FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
    workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
    worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
    XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
 
    int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
    int ColNum= Row.getLastCellNum(); // get last ColNum 
     
    Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
     
        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {  
            XSSFRow row= worksheet.getRow(i+1);
             
            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data 
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }

    return Data;
}
}
	

