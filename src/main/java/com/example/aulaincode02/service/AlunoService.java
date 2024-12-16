package com.example.aulaincode02.service;

import com.example.aulaincode02.model.Aluno;
import com.example.aulaincode02.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service


public class AlunoService {

    private final AlunoRepository alunoRepository;
    public AlunoService (AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public  Aluno atualizar(Long id , Aluno aluno) {
        Aluno verificarAluno = alunoRepository.findById(id).orElseThrow((() -> new RuntimeException("Id inexistente")));
        verificarAluno.setNome(aluno.getNome());
        verificarAluno.setIdade(aluno.getIdade());
        verificarAluno.setSexo(aluno.getSexo());
        return alunoRepository.save(verificarAluno);
    }
}


//tem que corrigir o lombok