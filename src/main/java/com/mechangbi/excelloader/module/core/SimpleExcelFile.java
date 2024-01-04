package com.mechangbi.excelloader.module.core;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.List;

public class SimpleExcelFile<E, T> {

    private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;
    private static final int ROW_START_INDEX = 0;
    private static final int COLUMN_START_INDEX = 0;

    private SXSSFWorkbook wb;
    private Sheet sheet;


    public SimpleExcelFile(List<T> data, Class<T> type){
        validateMaxRow(data);
        this.wb = new SXSSFWorkbook();


    }

    //최대 행 수 검증
    private void validateMaxRow(List<T> data){
        int maxRows = supplyExcelVersion.getMaxRows();
        if (data.size() > maxRows){
            throw new IllegalArgumentException(
                    String.format("does not support over %s rows", maxRows));
        }
    }

    //엑셀 랜더링
    private void renderExcel(List<T> data){
        sheet = wb.createSheet();
        renderHeaders(sheet, ROW_START_INDEX, COLUMN_START_INDEX);

    }

    private void renderHeaders(Sheet sheet, int rowStartIndex, int columnStartIndex) {
        Row row = sheet.createRow(rowStartIndex);
        int columnIndex = columnStartIndex;

    }

}
