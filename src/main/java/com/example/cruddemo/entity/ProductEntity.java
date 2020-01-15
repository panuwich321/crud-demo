package com.example.cruddemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private Integer productno;
    private String productid;
    private String productname;
    private Double productprice;
    private Integer productqty;

    public ProductEntity() {

    }

    public Integer getProductno() {
        return productno;
    }

    public void setProductno(Integer productno) {
        this.productno = productno;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Integer getProductqty() {
        return productqty;
    }

    public void setProductqty(Integer productqty) {
        this.productqty = productqty;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productno=" + productno +
                ", productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", productqty=" + productqty +
                '}';
    }
}
