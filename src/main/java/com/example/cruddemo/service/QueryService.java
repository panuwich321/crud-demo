package com.example.cruddemo.service;

import com.example.cruddemo.model.ProductModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueryService {
    @PersistenceContext
    private EntityManager em;

    public List<ProductModel> showAllProduct(String check) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT productno, productid, productname, productprice, productqty FROM PRODUCT ");

        switch (check) {
            case "price":
                sql.append("ORDER BY productprice ");
                break;
            case "qty":
                sql.append("ORDER BY productqty ");
                break;
            case "priceDESC":
                sql.append("ORDER BY productprice DESC ");
                break;
            case "qtyDESC":
                sql.append("ORDER BY productqty DESC ");
                break;
            default:
                break;
        }

        List<ProductModel> productModels = new ArrayList<>();
        Query query = em.createNativeQuery(sql.toString());
        List<Object[]> objectData = query.getResultList();
        if (objectData != null) {
            for (Object[] obj : objectData) {
                ProductModel productModel = new ProductModel();
                productModel.setNo(obj[0] != null ? (int) obj[0] : 0);
                productModel.setId(obj[1] != null ? obj[1].toString() : "-");
                productModel.setName(obj[2] != null ? obj[2].toString() : "-");
                productModel.setPrice(obj[3] != null ? (double) obj[3] : 0);
                productModel.setQty(obj[4] != null ? (int) obj[4] : 0);

                productModels.add(productModel);
            }
        }
        return productModels;
    }

    public List<ProductModel> showProductById(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT productno, productid, productname, productprice, productqty FROM PRODUCT WHERE productid = '");
        sql.append(id);
        sql.append("'");

        List<ProductModel> productModels = new ArrayList<>();
        Query query = em.createNativeQuery(sql.toString());
        List<Object[]> objectData = query.getResultList();
        if (objectData != null) {
            for (Object[] obj : objectData) {
                ProductModel productModel = new ProductModel();
                productModel.setNo(obj[0] != null ? (int) obj[0] : 0);
                productModel.setId(obj[1] != null ? obj[1].toString() : "-");
                productModel.setName(obj[2] != null ? obj[2].toString() : "-");
                productModel.setPrice(obj[3] != null ? (double) obj[3] : 0);
                productModel.setQty(obj[4] != null ? (int) obj[4] : 0);

                productModels.add(productModel);
            }
        }
        return productModels;
    }
}
