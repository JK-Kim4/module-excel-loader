package com.mechangbi.excelloader.module.core;

import com.mechangbi.excelloader.module.core.annotation.ExcelColumn;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class SimpleExcelFile<E, T> {

    private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;
    private static final int ROW_START_INDEX = 0;
    private static final int COLUMN_START_INDEX = 0;

    private SXSSFWorkbook wb;
    private Sheet sheet;
    private Field[] fields;

    private String filePath = "D:\\temp\\excel\\testExcelDefault.xlsx";;


    public SimpleExcelFile(List<T> data, Class<T> type){
        validateMaxRow(data);
        this.wb = new SXSSFWorkbook();
        setFields(type);

        if(data.isEmpty()){
            throw new RuntimeException("excel data is empty");
        }

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

        int rowIndex = ROW_START_INDEX + 1 ;
        for (Object renderData : data){
            renderBody(sheet, renderData, rowIndex++, COLUMN_START_INDEX);
        }
    }

    private void renderHeaders(Sheet sheet, int rowStartIndex, int columnStartIndex) {
        Row row = sheet.createRow(rowStartIndex);
        int columnIndex = columnStartIndex;

        for (Field field : this.fields){
            ExcelColumn ec = field.getAnnotation(ExcelColumn.class);
            if(ec != null){
                Cell cell = row.createCell(columnIndex++);
                cell.setCellValue(ec.headerName());
            }
        }
    }

    private void renderBody(Sheet sheet, Object data, int rowIndex, int columnStartIndex){
        Row row = sheet.createRow(rowIndex);
        int columnIndex = columnStartIndex;
        for (Field field : fields){
            Cell cell = row.createCell(columnIndex++);
            field.setAccessible(true);
            try {
                renderCellValue(cell, field.get(data));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void renderCellValue(Cell cell, Object cellValue){
        if (cellValue instanceof Number){
            Number numberValue = (Number) cellValue;
            cell.setCellValue(numberValue.doubleValue());
            return;
        }
        cell.setCellValue(cellValue == null ? "" : cellValue.toString());
    }

    private void setFields(Class<T> clazz){
        this.fields = clazz.getDeclaredFields();
    }

    public void write(OutputStream stream) throws IOException {
        wb.write(stream);
        wb.close();
        wb.dispose();
        stream.close();
    }

    public void writeFile() throws IOException{
        File outputFile = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        wb.write(fileOutputStream);
        wb.close();
        wb.dispose();
        fileOutputStream.close();
    }

    public Sheet getSheet(){
        return this.sheet;
    }
}
