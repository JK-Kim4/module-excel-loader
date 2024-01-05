package com.mechangbi.excelloader;

import com.mechangbi.excelloader.module.core.SimpleExcelFile;
import com.mechangbi.excelloader.module.domain.CarExcelInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleExcelFileTest {


    @Test
    public void SEFT_header_render_test(){
        CarExcelInfo car1 = new CarExcelInfo("현대", "소나타", 100, 4.9);
        CarExcelInfo car2 = new CarExcelInfo("르노", "SM3", 200, 4.9);
        CarExcelInfo car3 = new CarExcelInfo("기아", "KIA1", 300, 4.9);
        CarExcelInfo car4 = new CarExcelInfo("쌍용", "SSANG", 400, 4.9);

        List<CarExcelInfo> carExcelInfoList = new ArrayList<>();
        carExcelInfoList.add(car1);
        carExcelInfoList.add(car2);
        carExcelInfoList.add(car3);
        carExcelInfoList.add(car4);

        SimpleExcelFile simpleExcelFile = new SimpleExcelFile(carExcelInfoList, CarExcelInfo.class);
        System.out.println(simpleExcelFile.getSheet());
    }
}
