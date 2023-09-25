package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Cart;
import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.repository.CartRepository;
import com.ecommerce.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public boolean addItemIntoCart(int productId){
        Optional<Product> product = productRepository.findById(productId);
        List<Cart> p = cartRepository.findAll();
        for(Cart c: p){
            if(c.getId() == product.get().getProductId()){
                int q = c.getQuantity();
                c.setQuantity(q+1);
                cartRepository.save(c);
                return true;
            }
        }
        Cart cart  =  new Cart(product.get().getProductId(), 1, product.get().getName());
        cartRepository.save(cart);
        return true;
    }
    @Transactional
    public boolean removeItemFromCart(Product product){
        List<Cart> p = cartRepository.findAll();
        for(Cart c: p){
            if(c.getId() == product.getProductId()){
                int q = c.getQuantity();
                c.setQuantity(q-1);
                cartRepository.save(c);
            }
        }
        return true;
    }
    @Transactional(readOnly = true)
    public List<Cart> getAllProductsInCart() {
        return cartRepository.findAll();
    }
}
