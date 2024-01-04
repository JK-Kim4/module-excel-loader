package com.mechangbi.excelloader.service;

import com.mechangbi.excelloader.module.domain.CarInfo;
import com.mechangbi.excelloader.module.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    public void Car_정보_조회(){
        List<CarInfo> carInfoList = carService.getCarInfoAll();
        carInfoList.stream().forEach(System.out::println);
    }
}
