package com.morrison.dao;

import com.morrison.models.Product;

import java.util.List;

public interface IProductDaoImpl {

     void addProduct(Product product);
     void updateProduct(Product product);
     void removeProduct(int idProduct);
     Product getProductById(int idProduct);
     List<Product> getAllProducts();
}
