package exercicio_aula_3.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import exercicio_aula_3.demo.Aluno;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ex3")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {

        alunos.add(new Aluno("João", "Silva", 20, 'M', "Engenharia"));
        alunos.add(new Aluno("Mariana", "Santos", 22, 'F', "Ciência da Computação"));
        alunos.add(new Aluno("Portari", "Souza", 19, 'M', "Medicina"));
        alunos.add(new Aluno("Matheusa", "Ferreira", 21, 'F', "Administração"));
        alunos.add(new Aluno("Icaro", "Oliveira", 23, 'M', "Direito"));
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @GetMapping("/alunos/{index}")
    public Aluno getAlunoByIndex(@PathVariable int index) {
        if (index >= 0 && index < alunos.size()) {
            return alunos.get(index);
        } else {
            return null;
        }
    }

    @PostMapping("/add")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno);
        return aluno;
    }

    @PutMapping("/alunos/{index}")
    public Aluno updateAluno(@PathVariable int index, @RequestBody Aluno aluno) {
        if (index >= 0 && index < alunos.size()) {
            alunos.set(index, aluno);
            System.out.println("Atualização: " + aluno);
            return aluno;
        } else {
            System.out.println("Aluno não encontrado");
            return null;
        }
    }

    @DeleteMapping("/alunos/{index}")
    public void deleteAluno(@PathVariable int index) {
        if (index >= 0 && index < alunos.size()) {
            alunos.remove(index);
        }
    }
}
