package dev.ravi.productCatalog.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;

}
