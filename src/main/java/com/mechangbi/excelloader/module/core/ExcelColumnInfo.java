package com.mechangbi.excelloader.module.core;

import org.apache.poi.ss.usermodel.CellType;

public interface ExcelColumnInfo {
    String getHeaderName();
    String getAttributeName();
    int getOrder();
    int getWidth();
    CellType getCellType();
}
