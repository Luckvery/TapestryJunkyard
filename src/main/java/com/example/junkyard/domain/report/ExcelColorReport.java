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

        //Style color of cell
        final HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        short colNum = 0;
        int rowNum = 0;
        HSSFCell cell;
        HSSFRow row;

        for (IndexedColors color : IndexedColors.values()) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(colNum++);
            cellStyle.setFillForegroundColor(color.getIndex());
            cell.setCellStyle(cellStyle);
        }

        return workbook;
    }
}
