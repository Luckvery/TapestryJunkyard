package com.example.junkyard.domain.report;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 */
public class ExcelColorReport {

    public HSSFWorkbook getWorkbook() {
        //Make a new workbook
        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet("Excel Color Demo");

        //Style Cell
        //Header White Bold Style Style
        final HSSFFont MeiryoUI = workbook.createFont();
        MeiryoUI.setFontName("Meiryo UI");
        MeiryoUI.setFontHeightInPoints((short) 10);
        MeiryoUI.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        MeiryoUI.setColor(IndexedColors.WHITE.getIndex());

        //Header Center Style (Cells where we print a "x" )
        final HSSFCellStyle headerCenterStyle = workbook.createCellStyle();
        headerCenterStyle.setFont(MeiryoUI);
        headerCenterStyle.setWrapText(false);
        headerCenterStyle.setAlignment(CellStyle.ALIGN_CENTER);

        //Header Right Style
        final HSSFCellStyle columnTextStyle = workbook.createCellStyle();
        headerCenterStyle.setFont(MeiryoUI);
        headerCenterStyle.setWrapText(true);
        headerCenterStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.getIndex());
        headerCenterStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerCenterStyle.setAlignment(CellStyle.ALIGN_CENTER);

        short colNum = 0;
        int rowNum = 0;
        HSSFCell cell;
        HSSFRow row;

        for (IndexedColors color : IndexedColors.values()) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue(color.getIndex());
            headerCenterStyle.setFillForegroundColor(color.getIndex());
            cell.setCellStyle(headerCenterStyle);
        }

        return workbook;
    }
}
