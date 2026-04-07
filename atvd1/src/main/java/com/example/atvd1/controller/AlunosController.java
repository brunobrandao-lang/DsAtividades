package com.example.atvd1.controller;

import com.example.atvd1.model.AlunosModel;
import com.example.atvd1.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private AlunosRepository repository;

    @PostMapping //Criar alunos
    public ResponseEntity<AlunosModel> salvar(@RequestBody AlunosModel aluno) {
        repository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @GetMapping //Listar alunos
    public List<AlunosModel> listarTodos(){
        return repository.findAll();
    }
}
