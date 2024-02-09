package com.mechangbi.excelloader.module.domain;

import org.apache.poi.ss.usermodel.CellStyle;

public class NoExcelBackgroundColor implements ExcelBackgroundColor{

    @Override
    public void applyBackground(CellStyle cellStyle) {

    }
}
