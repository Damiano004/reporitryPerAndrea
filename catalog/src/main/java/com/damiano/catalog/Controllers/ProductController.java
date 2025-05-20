package com.damiano.catalog.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damiano.catalog.Models.Product;
import com.damiano.catalog.Models.ProductDTO;
import com.damiano.catalog.Services.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService pService){
        productService = pService;
    }

    @GetMapping("")
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @GetMapping("/category")
    public List<Product> getByCategory(@PathVariable String category){
        return productService.getByCategory(category);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDTO product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDTO changeStockNumber(@PathVariable String id,@RequestBody String stock){
        return productService.changeStockNumber(id, Integer.parseInt(stock));
    }
}