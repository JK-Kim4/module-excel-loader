package com.mechangbi.excelloader.module.core;

import com.mechangbi.excelloader.module.domain.CarInfo;
import com.mechangbi.excelloader.module.service.CarService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelRenderV1 {

    private final CarService carService;

    public ExcelRenderV1(CarService carService){
        this.carService = carService;
    }

    public void downloadCarInfo() throws IOException {

        String tempFile = "D:\\temp\\excel\\testExcel.xlsx";
        //파일로 생성
        File outputFile = new File(tempFile);

        Workbook workbook = new SXSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        List<CarInfo> carInfoList = carService.getCarInfoAll();

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("회사");

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("차종");

        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("가격");

        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("평점");

        for (CarInfo carInfo : carInfoList){
            Row bodyRow = sheet.createRow(rowIndex++);

            Cell bodyCell1 = bodyRow.createCell(0);
            bodyCell1.setCellValue(carInfo.getCompany());

            Cell bodyCell2 = bodyRow.createCell(1);
            bodyCell2.setCellValue(carInfo.getName());

            Cell bodyCell3 = bodyRow.createCell(2);
            bodyCell3.setCellValue(carInfo.getPrice());

            Cell bodyCell4 = bodyRow.createCell(3);
            bodyCell4.setCellValue(carInfo.getRating());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        workbook.write(fileOutputStream);
        workbook.close();

    }
}
