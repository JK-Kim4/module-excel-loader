package com.mechangbi.excelloader.module.core;

import com.mechangbi.excelloader.module.core.annotation.ExcelColumn;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.lang.reflect.Field;
import java.util.List;

public class SimpleExcelFile<E, T> {

    private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;
    private static final int ROW_START_INDEX = 0;
    private static final int COLUMN_START_INDEX = 0;

    private SXSSFWorkbook wb;
    private Sheet sheet;

    private Field[] fields;


    public SimpleExcelFile(List<T> data, Class<T> type){
        validateMaxRow(data);
        this.wb = new SXSSFWorkbook();
        setFields(type);

        //임시 호출
        renderExcel(data);
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

        for (Field field : this.fields){
            ExcelColumn ec = field.getAnnotation(ExcelColumn.class);
            if(ec != null){
                System.out.println(ec.headerName());
                Cell cell = row.createCell(columnIndex++);
                cell.setCellValue(ec.headerName());
            }
        }
    }

    private void setFields(Class<T> clazz){
        this.fields = clazz.getDeclaredFields();
    }

    public void write(){
    }

    public Sheet getSheet(){
        return this.sheet;
    }
}
