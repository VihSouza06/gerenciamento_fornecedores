package com.bn.exercicio7.Controllers;

import com.bn.exercicio7.Models.FornecedorModel;
import com.bn.exercicio7.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> fornecedores = fornecedorService.findAll();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> buscarFornecedorPorId(@PathVariable Long id){
        FornecedorModel fornecedor = fornecedorService.buscarFornecedorPorId(id);
        return ResponseEntity.ok(fornecedor);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
       FornecedorModel fornecedorCriado = fornecedorService.criarFornecedor(fornecedorModel);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
               .path("/{id}").buildAndExpand(fornecedorModel.getId()).toUri();
       return ResponseEntity.created(uri).body(fornecedorCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarFornecedor
            (@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel){
        FornecedorModel fornecedorAtualizado = fornecedorService.atualizarFornecedor(id, fornecedorModel);
        return ResponseEntity.ok(fornecedorAtualizado);
    }
}
