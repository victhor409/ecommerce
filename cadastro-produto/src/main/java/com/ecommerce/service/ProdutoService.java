package com.ecommerce.service;

import com.ecommerce.dto.ProdutoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoDTO save(ProdutoDTO dto);
    List<ProdutoDTO> findAll();
    ProdutoDTO update(String id, ProdutoDTO dto);
    void delete(String id);

}
