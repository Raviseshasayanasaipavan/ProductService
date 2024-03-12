package dev.ravi.productCatalog.services;

import dev.ravi.productCatalog.dtos.GenericProductDto;

public interface ProductService {

    GenericProductDto getProductById(Long id);
    GenericProductDto addNewProduct(GenericProductDto genericProductDto);
    GenericProductDto deleteProductById(Long id);
}
