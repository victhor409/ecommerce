package com.ecommerce.controller;

import com.ecommerce.aws.service.AwsS3Service;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.service.ProdutoServicoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProdutoController {

    @Autowired
    private ProdutoServicoImpl servico;

    @Autowired
    private AwsS3Service awsS3Service;

    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoDTO dto){
        ProdutoDTO newDto = servico.save(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PostMapping(path="/uploadAWS"  ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadAWS(@RequestParam("file")MultipartFile file) throws IOException {
        String fileAWS = awsS3Service.uploadFile(file);
        return ResponseEntity.ok().body(fileAWS);
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
