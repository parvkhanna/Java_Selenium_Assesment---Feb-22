package com.crm.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataProviderUtility 
{ 
	
		public FileInputStream fis;
		public FileOutputStream fos;
		public XSSFWorkbook workbook;
		public XSSFSheet sheet;
		public XSSFRow row;
		public XSSFCell cell;
		public CellStyle style;
		String path = null;
		
		 public DataProviderUtility(String path) 
		{
			this.path= path;
		}
		public int getRowCount(String sheetName) throws IOException 
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			int rowcount=sheet.getLastRowNum();
			workbook.close();
			fis.close();
			return rowcount;		
		}
		

		public int getCellCount(String sheetName,int rownum) throws IOException
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();
			workbook.close();
			fis.close();
			return cellcount;
		}
		
		
		public String getCellData(String sheetName,int rownum,int colnum) throws IOException
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			}
			catch(Exception e)
			{
				data="";
			}
			workbook.close();
			fis.close();
			return data;
		}
}


