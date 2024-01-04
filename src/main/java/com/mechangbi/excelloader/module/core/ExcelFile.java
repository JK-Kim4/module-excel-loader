package com.mechangbi.excelloader.module.core;

import com.mechangbi.excelloader.module.core.annotation.ExcelColumn;

public interface ExcelFile<E, T> {

    <E extends Enum<E> & ExcelColumnInfo> void setMetaInfo(Class<E> excelInfoClazz);
}
