package com.mechangbi.excelloader.controller;

import com.mechangbi.excelloader.module.core.ExcelRenderV1;
import com.mechangbi.excelloader.module.core.ExcelRenderWithStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ExcelRenderV1Test {

    @Autowired
    ExcelRenderV1 excelRenderV1;

    @Autowired
    ExcelRenderWithStyle excelRenderWithStyle;

    @Test
    public void Excel_download_default_test() throws IOException {
        excelRenderV1.downloadCarInfo();
    }

    @Test
    public void Excel_download_with_style_test() throws IOException{
        excelRenderWithStyle.downloadCarInfoWithStyle();
    }
}
