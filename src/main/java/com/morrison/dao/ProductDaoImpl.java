package com.morrison.dao;

import com.morrison.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDaoImpl implements IProductDaoImpl {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product product) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("The product with id [" + product.getId() + "] has been added!");

    }

    @Override
    public void updateProduct(Product product) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("The product with id [" + product.getId() + "] has been updated!");

    }

    @Override
    public void removeProduct(int productId) {

        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, new Integer(productId));

        if (product != null) {
            session.delete(product);
        }
        logger.info("The product with id [" + product.getId() + "] has been removed!");

    }

    @Override
    public Product getProductById(int productId) {

        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, new Integer(productId));
        logger.info("The product with id [" + product.getId() + "] has been granted!");

        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from products").list();

        for(Product product: products){
            logger.info("Product: " + products);
        }

        return products;
    }
}
