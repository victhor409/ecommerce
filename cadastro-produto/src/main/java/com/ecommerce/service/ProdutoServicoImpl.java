package com.ecommerce.service;

import com.ecommerce.aws.service.AwsS3Service;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.model.Produto;
import com.ecommerce.model.ProdutoRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServicoImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private AwsS3Service awsS3Service;


    @Override
    public ProdutoDTO save(ProdutoDTO dto) {
        Produto produto = null;
        try{
            if(dto != null){
                 produto = Produto.builder()
                        .id(dto.getId())
                        .price(dto.getPrice())
                        .categoria(dto.getCategoria())
                        .estoque(dto.getEstoque())
                        .descricao(dto.getDescricao())
                         .imageURl(dto.getImageURl())
                        .build();
                 produtoRepository.save(produto);
            }
        }catch (Exception e){
            throw new RuntimeException("Produto nao pode ser salvo",e);
        }
        return new ProdutoDTO(produto);
    }

    @Override
    public List<ProdutoDTO> findAll() {
        List<Produto> list = produtoRepository.findAll();
        return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO update(String id, ProdutoDTO dto) {
       Produto produto = produtoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Produto Não encontrado"));

       produto.setCategoria(dto.getCategoria());
       produto.setDescricao(dto.getDescricao());
       produto.setPrice(dto.getPrice());
       produto.setEstoque(dto.getEstoque());
       produto.setImageURl(dto.getImageURl());

       produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    @Override
    public void delete(String id) {
        try{
            if(id != null){
                produtoRepository.deleteById(id);
            }
        }catch (Exception e){
            throw new RuntimeException("Não existe produto",e);
        }
    }
}
