package com.example.aula.service;

import com.example.aula.model.FuncionarioModel;
import com.example.aula.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarTodos() {
        return repository.findAll();
    }

    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) { //verificar no BD se ja tem esse email cadastrado
            throw new RuntimeException(("Funcionário ja cadastrado "));
        }
        return repository.save(funcionario); //se nao encontrar ele salva no BD
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionario não encontrado");
        }
        //mantem o id para nao criar outro funcionario
        //altera todos os outros dados
        funcionario.setId(id); //para salvar no id q vc selecionou, e evitar q salve um novo funcionario
        return repository.save(funcionario);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) { //para ir no banco de dados e ve se encontra esse id
            throw new IllegalArgumentException("Funcionario não encontrado"); //faz se n encontrar o id
        }
        repository.deleteById(id); //faz se encontrar o id
    }
}