package com.ecommerce.shopping.controller;

import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        Product p = productService.getProductById(productId);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public HttpStatus addProduct(@RequestBody Product product){
        if(productService.addOrModifyProduct(product))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;

    }
    @PutMapping( consumes = "application/json")
    public HttpStatus modifyProduct(@RequestBody Product product){
        if(productService.addOrModifyProduct(product))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;

    }
    @DeleteMapping(value = "/{productId}")
    public HttpStatus deleteProductById(@PathVariable int productId){
        if(productService.deleteProductById(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }
    @GetMapping(value="/productName/{name}")
    public ResponseEntity<Product>getProductByName(@PathVariable String name){
        Product product = productService.getProductByName(name);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    @ExceptionHandler(RuntimeException.class)
    public HttpStatus productNotFoundHandler(){
        return HttpStatus.NOT_FOUND;
    }
}
