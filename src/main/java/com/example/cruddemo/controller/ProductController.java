package com.example.cruddemo.controller;

import com.example.cruddemo.entity.ProductEntity;
import com.example.cruddemo.model.ProductModel;
import com.example.cruddemo.service.QueryService;
import com.example.cruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    QueryService queryService;

    @Autowired
    ProductService productService;

    @GetMapping("/Search")
    public String Search(ModelMap model) {
        String check = "";
        ProductModel products = new ProductModel();
        model.addAttribute("productToFind", products);
        model.addAttribute("products", queryService.showAllProduct(check));
        return "product/productSearch";
    }

    @GetMapping("/Search/SearchById")
    public String FindById(ModelMap model, @ModelAttribute("productToFind") ProductModel products) {
        List<ProductModel> productModels = queryService.showProductById(products.getId());
        model.addAttribute("products", productModels);
        return "product/productSearch";
    }

    /* USE ProductService */
    @GetMapping("/")
    public String Main(ModelMap model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product/product";
    }

    @GetMapping("/OrderByPrice")
    public String OrderByPrice(ModelMap model) {
        model.addAttribute("products", productService.getAllProductSortByPrice());
        return "product/product";
    }

    @GetMapping("/OrderByQty")
    public String OrderByQty(ModelMap model) {
        model.addAttribute("products", productService.getAllProductSortByQty());
        return "product/product";
    }

    @GetMapping("/OrderByPriceDESC")
    public String OrderByPriceDESC(ModelMap model) {
        model.addAttribute("products", productService.getAllProductSortByPriceDesc());
        return "product/product";
    }

    @GetMapping("/OrderByQtyDESC")
    public String OrderByQtyDESC(ModelMap model) {
        model.addAttribute("products", productService.getAllProductSortByQtyDesc());
        return "product/product";
    }

    @GetMapping("/Insert")
    public String Insert(ModelMap model) {
        ProductEntity products = new ProductEntity();
        model.addAttribute("productInsert", products);
        return "product/productCreate";
    }

    @PostMapping("/Insert/Add")
    public String Add(ModelMap model, @ModelAttribute("productInsert") ProductEntity products) {
        productService.insertProduct(products);
        model.addAttribute("products", productService.getAllProduct());
        return "product/product";
    }

    @GetMapping("/Delete")
    public String Delete(ModelMap model) {
        ProductEntity products = new ProductEntity();
        model.addAttribute("productDelete", products);
        return "product/productDelete";
    }

    @PostMapping("/Delete/Remove")
    public String Remove(ModelMap model, @ModelAttribute("productDelete") ProductEntity products) {
        productService.deleteProductByNo(products.getProductno());
        model.addAttribute("products", productService.getAllProduct());
        return "product/product";
    }
}
