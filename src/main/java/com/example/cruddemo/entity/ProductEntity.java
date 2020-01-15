package com.example.cruddemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    private Integer productno;
    private String productid;
    private String productname;
    private Double productprice;
    private Integer productqty;
}
