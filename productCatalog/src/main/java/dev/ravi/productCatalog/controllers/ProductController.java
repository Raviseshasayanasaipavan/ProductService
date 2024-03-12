package dev.ravi.productCatalog.controllers;


import dev.ravi.productCatalog.dtos.GenericProductDto;
import dev.ravi.productCatalog.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id)
    {
        return productService.getProductById(id);
    }

    @PostMapping("")
    public GenericProductDto addNewProduct(@RequestBody GenericProductDto addNewProduct){
        return productService.addNewProduct(addNewProduct);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }


}
