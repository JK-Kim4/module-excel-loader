package com.mechangbi.excelloader.module.domain;

public class BookDto {

    public BookDto(){}
    public BookDto(String title, String publisher, int price, String author, int stock) {
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.author = author;
        this.stock = stock;
    }

    private String title;
    private String publisher;
    private int price;
    private String author;
    private int stock;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}