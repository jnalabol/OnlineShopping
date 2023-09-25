package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(int productId){
        Optional<Product> op = productRepository.findById(productId);
        if(op.isPresent())
            return op.get();
        throw new RuntimeException("product doesn't exist");

    }
    @Transactional(readOnly = true)
    public Product getProductByName(String name)
    {
        Optional<Product> op = productRepository.findByName(name);
        if (op.isPresent())
            return op.get();
        throw new RuntimeException();
    }
    @Transactional
    public  boolean addOrModifyProduct(Product product){
        Product p =  productRepository.save(product);
        return p!= null;
    }
    @Transactional
    public boolean deleteProductById(int productId){
        long count = productRepository.count();
        productRepository.deleteById(productId);
        return count>productRepository.count();
    }
}
