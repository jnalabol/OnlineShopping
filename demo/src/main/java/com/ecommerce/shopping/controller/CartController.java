package com.ecommerce.shopping.controller;

import com.ecommerce.shopping.entity.Cart;
import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping(value = "/{productId}" ,consumes = "application/json")
    public HttpStatus addCart(@PathVariable int productId){
        if(cartService.addItemIntoCart(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;

    }
    @PostMapping(value = "/product", consumes = "application/json")
    public HttpStatus removeCart(@RequestBody Product product){
        if(cartService.removeItemFromCart(product))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;

    }
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Cart>> showCart(){
        return new ResponseEntity<List<Cart>>(cartService.getAllProductsInCart(), HttpStatus.OK);
    }
}
