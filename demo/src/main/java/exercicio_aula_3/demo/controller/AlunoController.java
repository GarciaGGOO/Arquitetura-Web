package exercicio_aula_3.demo.controller;

import exercicio_aula_3.demo.modelo.Aluno;
import exercicio_aula_3.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{index}")
    public Aluno getAlunoByIndex(@PathVariable int index) {
        return alunoService.getAlunoByIndex(index);
    }

    @PostMapping("/add")
    public void createAluno(@RequestBody Aluno aluno) {
        alunoService.createAluno(aluno);
    }

    @PutMapping("/{index}")
    public void updateAluno(@PathVariable int index, @RequestBody Aluno aluno) {
        alunoService.updateAluno(index, aluno);
    }

    @DeleteMapping("/{index}")
    public void deleteAluno(@PathVariable int index) {
        alunoService.deleteAluno(index);
    }
}
