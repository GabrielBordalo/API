package br.com.aulaincode.controller;

import br.com.aulaincode.model.Aluno;
import br.com.aulaincode.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        var alunos = alunoService.cadastrar(aluno);
        return ResponseEntity.ok().body(alunos);
    }

    @PutMapping("/{id}")
    public Aluno verificarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.atualizar(id, aluno );
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id, Aluno aluno){
         alunoService.delete(id);
    }

}
