package com.OrangeHrm.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadDataFromXcellSheet {
	@DataProvider(name="userpass")
	public Object [][] readData() throws IOException
	{
		String path="./src/test/java/com/OrangeHrm/TestData/user_data.xlsx";
		int nRows=Utilis.getRows(path, "Sheet1")+1;
		int nCol=Utilis.getColumns(path, "Sheet1", 0);
		String dt[][]=new String[nRows][nCol];
		for(int i=0; i<nRows;i++)
		{
			for(int j=0; j<nCol;j++)
			{
			dt[i][j]=Utilis.getValue(path,"Sheet1", i, j);
			}
		}
		return dt;
		
	}

}
