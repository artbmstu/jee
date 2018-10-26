package ru.artbmstu.jee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.artbmstu.jee.entity.ProductEntity;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private String id;
    private String name;
    private String description;

    public ProductDTO(ProductEntity product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
    }
}