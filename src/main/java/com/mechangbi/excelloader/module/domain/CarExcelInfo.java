package com.mechangbi.excelloader.module.domain;

import com.mechangbi.excelloader.module.core.annotation.ExcelColumn;

public class CarExcelInfo extends ExcelInfo{

    public CarExcelInfo(){}

    public CarExcelInfo(String company, String name, int price, double rating) {
        this.company = company;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @ExcelColumn(headerName = "회사")
    private String company;

    @ExcelColumn(headerName = "이름")
    private String name;

    @ExcelColumn(headerName = "가격")
    private int price;

    @ExcelColumn(headerName = "평점")
    private double rating;

    /*Annotation 설정하지않은 Field 있을 경우 field.getAnnotation() throws NullPointException*/
    private String tempField;

    @Override
    public String getHeaderName(String fieldName) {
        return null;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
