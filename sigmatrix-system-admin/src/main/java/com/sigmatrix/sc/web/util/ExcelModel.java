package com.sigmatrix.sc.web.util;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelModel {
	
	private String xlsName;//文件名
	private String data[][];//数据
	private String sheetName;//页名
	private String titles[];
	
	public String getXlsName() {
		return xlsName;
	}
	public void setXlsName(String xlsName) {
		this.xlsName = xlsName;
	}
	public String[][] getData() {
		return data;
	}
	public void setData(String[][] data) {
		this.data = data;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	private WritableSheet writeLable(WritableSheet sheet,String[][] data, int num) throws RowsExceededException, WriteException{
		if (titles!=null && num == 0) {
			for (int i = 0; i < titles.length; i++) {
				sheet.addCell(new Label(i, 0, this.titles[i]));
			}
		}
		int numMax = 65535;
		if ((data.length - 65535*num) < 65535) {
			numMax = data.length - 65535*num;
		}
		if (data!=null) {
			for (int i = 0; i < numMax; i++) {
				for (int j = 0; j < data[i+65535*num].length; j++) {
//					if (titles!=null) {
//						sheet.addCell(new Label(j, 0, this.titles[j]));
//					}
					sheet.addCell(new Label(j,(titles==null?i:i+1),data[i+65535*num][j]));
				}
			}
		}
		return sheet;
	}
	
	public void createSerialExcel(OutputStream os) throws IOException, RowsExceededException, WriteException{
		WritableWorkbook workbook;
		workbook = Workbook.createWorkbook(os);
		int sheetSize = 65535;
		int length = data.length;
		int sheetNum = 1;
		if(length%sheetSize>0){
		    sheetNum=length/sheetSize+1;
		 }else{
		    sheetNum=length/sheetSize;
		 }
		for (int i = 0; i < sheetNum; i++) {
			WritableSheet sheet = workbook.createSheet(sheetName+i, i);
			writeLable(sheet, data,i);
		}
		workbook.write();
		workbook.close();
		os.close();
	}
}
