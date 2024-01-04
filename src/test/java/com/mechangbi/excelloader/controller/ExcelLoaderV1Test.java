package com.mechangbi.excelloader.controller;

import com.mechangbi.excelloader.module.core.ExcelLoaderV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ExcelLoaderV1Test {

    @Autowired
    ExcelLoaderV1 excelLoaderV1;

    @Test
    public void Excel_download_test() throws IOException {
        excelLoaderV1.downloadCarInfo();

    }
}
