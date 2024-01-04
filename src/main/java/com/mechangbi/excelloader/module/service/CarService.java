package com.mechangbi.excelloader.module.service;

import com.mechangbi.excelloader.module.domain.CarInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static List<CarInfo> carInfo = new ArrayList<>();

    public CarService(){
        CarInfo car1 = new CarInfo(1L, "현대", "소나타", 100, 4.9);
        CarInfo car2 = new CarInfo(2L, "르노삼성", "QM6", 200, 4.9);
        CarInfo car3 = new CarInfo(3L, "기아", "K7", 300, 4.9);

        carInfo.add(car1);
        carInfo.add(car2);
        carInfo.add(car3);

    }


    public List<CarInfo> getCarInfoAll(){
        return carInfo;
    }


}
