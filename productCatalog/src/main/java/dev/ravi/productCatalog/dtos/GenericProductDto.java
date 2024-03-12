package dev.ravi.productCatalog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
}
