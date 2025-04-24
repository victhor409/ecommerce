package com.ecommerce.dto;

import com.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTO {

    private String id;
    private String descricao;
    private Double price;
    private String categoria;
    private Integer estoque;
    private String imageURl;

    public ProdutoDTO(Produto entidade){
        this.id = entidade.getId();
        this.price = entidade.getPrice();
        this.categoria = entidade.getCategoria();
        this.estoque = entidade.getEstoque();
        this.descricao = entidade.getDescricao();
        this.imageURl = entidade.getImageURl();
    }
}
