package exercicio_aula_3.demo.repository;

import exercicio_aula_3.demo.modelo.Aluno;
import java.util.List;

public interface AlunoRepository {
    List<Aluno> findAll();
    Aluno findById(int id);
    void save(Aluno aluno);
    void delete(int id);
}
