package com.riachuelo.house.components;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.exceptions.ResourceNotFoundException;
import com.riachuelo.house.models.ItemError;
import com.riachuelo.house.utils.Util;

@Component
public class ExportExcel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportExcel.class);
	
	@Autowired
	private Inconsistency inconsistency;
	
	@Value("${app.house.file.output.path}")
    private String path;
	HSSFWorkbook workbook = null;
	HSSFSheet sheet = null;

	Cell cell;
	Row  row;
	
	int rownum;
	int cellnum;
	
	public void generate() {	
		
		LOGGER.info(Constants.STEP_CREATE_FILE);
		
		workbook = new HSSFWorkbook();
		sheet    = workbook.createSheet(Constants.SHEET);
		rownum   = 0;
		cellnum  = 0;
		
		this.config();
		this.loadHeader();
		this.loadItens();
		this.writeFile();
	}
	
	public void config() {
		sheet.setDefaultColumnWidth(15);
		sheet.setDefaultRowHeight((short)400);
	}
	
	public CellStyle generateHeaderStyle() {
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		return headerStyle;
	}
	
	public CellStyle generateTextStyle() {
		CellStyle textStyle = workbook.createCellStyle();
		textStyle.setAlignment(HorizontalAlignment.CENTER);
		textStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		return textStyle;
	}
	
	public void loadHeader() {	
		row = sheet.createRow(rownum++);
		
		cell = row.createCell(cellnum++);
		cell.setCellStyle(generateHeaderStyle());
		cell.setCellValue(Constants.LABEL_FILE);
		
		cell = row.createCell(cellnum++);
		cell.setCellStyle(generateHeaderStyle());
		cell.setCellValue(Constants.LABEL_REGISTRATION);
		
		cell = row.createCell(cellnum++);
		cell.setCellStyle(generateHeaderStyle());
		cell.setCellValue(Constants.LABEL_SALESMAN);
		
		cell = row.createCell(cellnum++);
		cell.setCellStyle(generateHeaderStyle());
		cell.setCellValue(Constants.LABEL_ERROR);		
	}
	
	public void loadItens() {
		for (ItemError error : inconsistency.getInconsistencies()) {
			row = sheet.createRow(rownum++);
			cellnum = 0;

			cell = row.createCell(cellnum++);
			cell.setCellStyle(generateTextStyle());
			cell.setCellValue(error.getFile());

			cell = row.createCell(cellnum++);
			cell.setCellStyle(generateTextStyle());
			cell.setCellValue(error.getRegistration());
			
			cell = row.createCell(cellnum++);
			cell.setCellStyle(generateTextStyle());
			cell.setCellValue(error.getSalesman());
			
			cell = row.createCell(cellnum++);
			cell.setCellStyle(generateTextStyle());
			cell.setCellValue(error.getDescription());
		
		}
	}
	
	public void writeFile() {
		try {
			FileOutputStream out = new FileOutputStream(new File(path.concat(Util.recoveryFileName())));
			workbook.write(out);
			out.close();
			workbook.close();
			LOGGER.info(Constants.STEP_SUCCESS_FILE);
		} catch (FileNotFoundException e) {
			throw new ResourceNotFoundException(Constants.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new ResourceNotFoundException(Constants.IO_ERROR);
		}
	}

}
