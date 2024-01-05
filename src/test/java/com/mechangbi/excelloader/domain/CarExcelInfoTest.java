package com.mechangbi.excelloader.domain;

import com.mechangbi.excelloader.module.core.annotation.ExcelColumn;
import com.mechangbi.excelloader.module.domain.CarExcelInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CarExcelInfoTest {

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
    public void excel_column_annotation_test() throws NoSuchFieldException{
        Class<?> clazz = this.carExcelInfoList.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            ExcelColumn ec = field.getAnnotation(ExcelColumn.class);
            if(ec != null){
                System.out.println(ec.headerName());
            }
        }
    }

    @Test
    public void excel_column_value_test(){
        CarExcelInfo car1 = carExcelInfoList.get(0);
        Class<?> clazz = car1.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(CarExcelInfo carExcelInfo : carExcelInfoList){
            for (Field field : fields){
                Object value = null;
                field.setAccessible(true);
                try {
                    value = field.get(carExcelInfo);
                    System.out.println(value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
