package com.ecommerce.controller;

import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.service.ProdutoServicoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProdutoController {

    @Autowired
    private ProdutoServicoImpl servico;

    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoDTO dto){
        ProdutoDTO newDto = servico.save(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<ProdutoDTO> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody ProdutoDTO dto){
        ProdutoDTO newDto = servico.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        servico.delete(id);
        return ResponseEntity.noContent().build();
    }
}
