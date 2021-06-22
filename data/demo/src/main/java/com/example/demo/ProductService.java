package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository user;

    public List<Product> listAll() {
        return user.findAll();
    }

    public void save(Product product) {
        user.save(product);
    }

    public Product get(Integer id) {
        return user.findById(id).get();
    }

    public void delete(Integer id) {
        user.deleteById(id);
    }
}
