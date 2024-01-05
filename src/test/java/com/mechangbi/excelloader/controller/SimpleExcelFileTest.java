package com.mechangbi.excelloader.controller;

import com.mechangbi.excelloader.module.core.SimpleExcelFile;
import com.mechangbi.excelloader.module.domain.CarExcelInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SimpleExcelFileTest {

    private List<CarExcelInfo> carExcelInfoList = new ArrayList<>();

    @BeforeEach
    public void init(){
        CarExcelInfo car1 = new CarExcelInfo("현대", "소나타", 100, 4.9);
        CarExcelInfo car2 = new CarExcelInfo("르노", "SM3", 200, 4.9);
        CarExcelInfo car3 = new CarExcelInfo("기아", "KIA1", 300, 4.9);
        CarExcelInfo car4 = new CarExcelInfo("쌍용", "SSANG", 400, 4.9);
        carExcelInfoList.add(car1);
        carExcelInfoList.add(car2);
        carExcelInfoList.add(car3);
        carExcelInfoList.add(car4);
    }

    @Test
    public void simple_excel_download_test() throws IOException {
        SimpleExcelFile simpleExcelFile = new SimpleExcelFile<>(carExcelInfoList, CarExcelInfo.class);
        simpleExcelFile.writeFile();
    }
}
