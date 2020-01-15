package com.example.cruddemo.service;

import com.example.cruddemo.entity.ProductEntity;
import com.example.cruddemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getAllProductSortByPrice() {
        return productRepository.findAll(sortByPriceAsc());
    }

    public Sort sortByPriceAsc() {
        return Sort.by(Sort.Direction.ASC, "productprice");
    }

    public List<ProductEntity> getAllProductSortByPriceDesc() {
        return productRepository.findAll(sortByPriceDesc());
    }

    public Sort sortByPriceDesc() {
        return Sort.by(Sort.Direction.DESC, "productprice");
    }

    public List<ProductEntity> getAllProductSortByQty() {
        return productRepository.findAll(sortByQtyAsc());
    }

    public Sort sortByQtyAsc() {
        return Sort.by(Sort.Direction.ASC, "productqty");
    }

    public List<ProductEntity> getAllProductSortByQtyDesc() {
        return productRepository.findAll(sortByQtyDesc());
    }

    public Sort sortByQtyDesc() {
        return Sort.by(Sort.Direction.DESC, "productqty");
    }

    public void insertProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void deleteProductByNo(Integer no) {
        productRepository.deleteById(no);
    }
}
