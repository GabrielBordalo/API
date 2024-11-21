package br.com.aulaincode.controller;

import br.com.aulaincode.model.Aluno;
import br.com.aulaincode.service.AlunoService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    public final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listaralunos")
    public List<Aluno> listAlunos() {
        return alunoService.listar();
    }

    @PostMapping("/cadastraraluno")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrar(aluno);
    }

    //@PutMapping("/{id}")
    //@Transactional
    //public Aluno verificarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
     //   return alunoService.atualizar(id, aluno );
    //}

}
