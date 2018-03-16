package com.morrison.services;

import com.morrison.dao.IProductDaoImpl;
import com.morrison.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductDaoImpl iProductDaoImpl;

    public void setiProductDaoImpl(IProductDaoImpl iProductDao) {
        this.iProductDaoImpl = iProductDao;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        this.iProductDaoImpl.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.iProductDaoImpl.updateProduct(product);
    }

    @Override
    @Transactional
    public void removeProduct(int productId) {
        this.iProductDaoImpl.removeProduct(productId);

    }

    @Override
    @Transactional
    public Product getProductById(int productId) {
        return this.iProductDaoImpl.getProductById(productId);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return this.iProductDaoImpl.getAllProducts();
    }
}
