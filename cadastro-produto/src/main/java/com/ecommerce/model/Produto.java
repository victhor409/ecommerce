package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String descricao;
    private Double price;
    private String categoria;
    private Integer estoque;
    private String imageURl;


}
