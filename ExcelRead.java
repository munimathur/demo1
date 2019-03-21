package HoliExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelRead 
{
	static XSSFWorkbook Workbook;
	static XSSFSheet Datasheet;
	static File src= new File(".//Sample.xlsx");
	
	
	public static Object[][] read(String sheetname) throws Exception
	{	
		FileInputStream FIS=new FileInputStream(src);
		Workbook =new XSSFWorkbook(FIS);
		Datasheet =Workbook.getSheet(sheetname);				
		int Rowc= Datasheet.getLastRowNum();
		int Col= Datasheet.getRow(0).getLastCellNum();
		Rowc=Rowc+1;
		Object[][] Data= new Object[Rowc][Col];		
		for(int i=1; i<Rowc; i++)
		{
			for(int j=0; j<Col; j++)
			{	
				Data[i][j]=Datasheet.getRow(i).getCell(j).getStringCellValue();
			}			
		}
		return Data;		
	}
	
	/*public static String Cellread( int sheetnum, int Rownum, int Colnum) throws Exception
	{
		FileInputStream FIS=new FileInputStream(src);
		Workbook =new XSSFWorkbook(FIS);
		Datasheet =Workbook.getSheet("test");			
		XSSFRow Rowc= Datasheet.getRow(Rownum);
		XSSFCell Col= Rowc.getCell(Colnum);
		String Data= Col.getStringCellValue();	
		return Data;  	
	}*/
	
	@Test(dataProvider="ReadData" )
	public void Registration_TestCase(String []arg) throws Exception
    {		
		
		for(int i=0; i<6; i++)
		{
			/*WebElement wb1=
					wb1.sendKeys(arg[i]);*/
			System.out.println(arg[i]);
		}
    	
    }
	
	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=read("test");
	   	return (testObjArray);   	
	}
	
	/*public static void main (String args[]) throws Exception 
	{
		//ExcelRead readData=new ExcelRead();
		String name=Cellread(0,1,2);
		System.out.println(name);
	    
				
	}*/
	
}
