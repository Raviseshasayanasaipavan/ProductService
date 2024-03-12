package dev.ravi.productCatalog.services;


import dev.ravi.productCatalog.dtos.FakeStoreProductDto;
import dev.ravi.productCatalog.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private String fakeStoreGetProductUrl = "https://fakestoreapi.com/products/{id}";
    private String addNewProductUrl = "https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto dtoToGenericHeleper(ResponseEntity<FakeStoreProductDto> response){

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setCategory(response.getBody().getCategory());
        genericProductDto.setId(response.getBody().getId());
        genericProductDto.setImage(response.getBody().getImage());
        genericProductDto.setDescription(response.getBody().getDescription());
        genericProductDto.setTitle(response.getBody().getTitle());

        return genericProductDto;

    }
    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>  response = restTemplate.getForEntity(fakeStoreGetProductUrl,FakeStoreProductDto.class,id);
        return dtoToGenericHeleper(response);
    }


    @Override
    public GenericProductDto addNewProduct(GenericProductDto addNewProduct) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>  response = restTemplate.postForEntity(addNewProductUrl,addNewProduct,FakeStoreProductDto.class);
        return dtoToGenericHeleper(response);
    }
    @Override
    public GenericProductDto deleteProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(fakeStoreGetProductUrl, HttpMethod.DELETE,
                requestCallback, responseExtractor, id);
        assert response != null;
        return dtoToGenericHeleper(response);
    }

}
