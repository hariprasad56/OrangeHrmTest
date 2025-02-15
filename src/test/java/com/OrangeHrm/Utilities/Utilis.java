package com.OrangeHrm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilis {
	public static File fl;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cel;
	public static int getRows(String path, String sheet) throws IOException
	{
		fl=new File(path);
		fi=new FileInputStream(fl);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		if(sh==null) return 0;
		int nofRows=sh.getLastRowNum();
		wb.close();
		fi.close();
		return nofRows;
	}
	public static int getColumns(String path, String sheet, int rno) throws IOException
	{
		fl=new File(path);
		fi=new FileInputStream(fl);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		if(sh==null)return 0;
		rw=sh.getRow(rno);
		if(rw==null)return 0;
		int nofCols=rw.getLastCellNum();
		wb.close();
		fi.close();
		return nofCols;
		
	}
	public static String getValue(String path,String she,int row, int cno) throws IOException
	{
		fl=new File(path);
		fi=new FileInputStream(fl);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(she);
		if(sh==null)return "";
		rw=sh.getRow(row);
		if(rw==null)return "";
		cel=rw.getCell(cno);
		if(cel==null)return "";
		wb.close();
		fi.close();
		switch(cel.getCellType()) {
		case STRING: 
			return cel.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cel.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cel.getBooleanCellValue());
		default:
			return "";
		
		}
			
	}
	public static void setValue(String path, String sheet, int row,int cno, String cValue) throws IOException
	{
		fl=new File(path);
		fi=new FileInputStream(fl);
	     wb=new XSSFWorkbook(fi);
	     sh=wb.getSheet(sheet);
	     if(sh==null)
	     rw=sh.getRow(row);
	     if(rw==null)
	     cel=rw.getCell(cno);
	     if(cel==null)
	     cel.setCellValue(cValue);
	     FileOutputStream fo=new FileOutputStream(fl);
	     wb.write(fo);
	     wb.close();
	     fi.close();
	     fo.close();
		
	}

}
