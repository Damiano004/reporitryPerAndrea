package com.damiano.catalog.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.damiano.catalog.Models.ProductDTO;
import com.damiano.catalog.Models.Product;
import com.damiano.catalog.Repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository pRepo){
        productRepository = pRepo;
    }

    public List<ProductDTO> getProducts(){
        return productRepository.findAll()
            .stream().map(p ->
                new ProductDTO(
                    p.getCode(),
                    p.getName(),
                    p.getDescription(),
                    p.getStock(),
                    p.getPrice(),
                    p.getCategory()
                )).toList();
            
    }

    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    public List<Product> getByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product createProduct(ProductDTO product){
        Product p = new Product();
        p.setName(product.getName());
        p.setCategory(product.getCategory());
        p.setDescription(product.getDescription());
        p.setStock(product.getStock());
        p.setPrice(product.getPrice()); 
        return productRepository.save(p);
    }

    public ProductDTO changeStockNumber(String id, int stock){
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return null;
        }
        product.setStock(stock);
        
        ProductDTO pDto = new ProductDTO();
        pDto.setCategory(product.getCategory());
        pDto.setCode(product.getCode());
        pDto.setDescription(product.getDescription());
        pDto.setName(product.getCategory());
        pDto.setPrice(product.getPrice());
        pDto.setStock(product.getStock());

        return pDto;
    }
}
