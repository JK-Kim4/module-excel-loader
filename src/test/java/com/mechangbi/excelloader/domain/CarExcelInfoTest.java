package com.mechangbi.excelloader.domain;

import com.mechangbi.excelloader.module.domain.CarExcelInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
public class CarExcelInfoTest {


    @Test
    public void excel_column_annotation_test(){
        CarExcelInfo car1 = new CarExcelInfo("현대", "소나타", 100, 4.9);
        CarExcelInfo car2 = new CarExcelInfo("르노", "SM3", 200, 4.9);
        CarExcelInfo car3 = new CarExcelInfo("기아", "KIA1", 300, 4.9);
        CarExcelInfo car4 = new CarExcelInfo("쌍용", "SSANG", 400, 4.9);

        Class<?> clazz = car1.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields){
            System.out.println(field.getName());
            System.out.println(field.getAnnotations());
        }
    }
}
