package com.mechangbi.excelloader.module.core;


import com.mechangbi.excelloader.module.domain.CarInfo;
import com.mechangbi.excelloader.module.service.CarService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.stereotype.Component;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelRenderWithStyle {

    private final CarService carService;

    public ExcelRenderWithStyle(CarService carService){
        this.carService = carService;
    }

    public void downloadCarInfoWithStyle() throws IOException {

        String tempFile = "D:\\temp\\excel\\testExcelWithStyle.xlsx";
        //파일로 생성
        File outputFile = new File(tempFile);

        Workbook workbook = new SXSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        List<CarInfo> carInfoList = carService.getCarInfoAll();

        // 데이터를 가져오고 Workbook, Sheet를 만듭니다
        CellStyle greyCellStyle = workbook.createCellStyle();
        applyCellStyle(greyCellStyle, new Color(231, 234, 236));

        CellStyle blueCellStyle = workbook.createCellStyle();
        applyCellStyle(blueCellStyle, new Color(223, 235, 246));

        CellStyle bodyCellStyle = workbook.createCellStyle();
        applyCellStyle(bodyCellStyle, new Color(255, 255, 255));


        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("회사");
        headerCell1.setCellStyle(greyCellStyle);

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("차종");
        headerCell2.setCellStyle(greyCellStyle);

        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("가격");
        headerCell3.setCellStyle(blueCellStyle);

        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("평점");
        headerCell4.setCellStyle(blueCellStyle);

        for (CarInfo carInfo : carInfoList){
            Row bodyRow = sheet.createRow(rowIndex++);

            Cell bodyCell1 = bodyRow.createCell(0);
            bodyCell1.setCellValue(carInfo.getCompany());
            bodyCell1.setCellStyle(bodyCellStyle);

            Cell bodyCell2 = bodyRow.createCell(1);
            bodyCell2.setCellValue(carInfo.getName());
            bodyCell2.setCellStyle(bodyCellStyle);

            Cell bodyCell3 = bodyRow.createCell(2);
            bodyCell3.setCellValue(carInfo.getPrice());
            bodyCell3.setCellStyle(bodyCellStyle);

            Cell bodyCell4 = bodyRow.createCell(3);
            bodyCell4.setCellValue(carInfo.getRating());
            bodyCell4.setCellStyle(bodyCellStyle);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        workbook.write(fileOutputStream);
        workbook.close();

    }

    private void applyCellStyle(CellStyle cellStyle, Color color) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) cellStyle;
        xssfCellStyle.setFillForegroundColor(new XSSFColor(color, new DefaultIndexedColorMap()));
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
    }
}
