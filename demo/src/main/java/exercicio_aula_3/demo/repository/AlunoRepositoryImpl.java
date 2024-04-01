package exercicio_aula_3.demo.repository;

import exercicio_aula_3.demo.modelo.Aluno;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();

    @Override
    public List<Aluno> findAll() {
        return alunos;
    }

    @Override
    public Aluno findById(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void save(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void delete(int id) {
        alunos.removeIf(aluno -> aluno.getId() == id);
    }
}
