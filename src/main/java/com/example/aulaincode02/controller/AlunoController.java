package com.example.aulaincode02.controller;

import com.example.aulaincode02.model.Aluno;
import com.example.aulaincode02.service.AlunoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/alunos")

public class AlunoController {

    public final AlunoService alunoService;
    public  AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Aluno>> getAlunos (@RequestBody Aluno aluno) {
        List<Aluno> alunos = alunoService.getAlunos();
        if (alunos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alunos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        var alunos = alunoService.cadastrar(aluno);
        return ResponseEntity.ok().body(alunos);
    }

}
