package exercicio_aula_3.demo.service;

import exercicio_aula_3.demo.modelo.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno getAlunoByIndex(int index);
    void createAluno(Aluno aluno);
    void updateAluno(int index, Aluno aluno);
    void deleteAluno(int index);
}