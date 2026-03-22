package com.bn.exercicio7.Services;

import com.bn.exercicio7.Models.FornecedorModel;
import com.bn.exercicio7.Repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }

    public FornecedorModel buscarFornecedorPorId(Long id){
       return fornecedorRepository.findById(id).get();
    }

    public FornecedorModel atualizarFornecedor(Long id, FornecedorModel fornecedorModel){
        FornecedorModel novoFornecedor = fornecedorRepository.findById(id).get();
        novoFornecedor.setNomeFantasia(fornecedorModel.getNomeFantasia());
        novoFornecedor.setCnpj(fornecedorModel.getCnpj());
        novoFornecedor.setContato(fornecedorModel.getContato());
        return fornecedorRepository.save(novoFornecedor);
    }
}
