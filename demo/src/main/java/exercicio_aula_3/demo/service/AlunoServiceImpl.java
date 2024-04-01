package exercicio_aula_3.demo.service;

import exercicio_aula_3.demo.modelo.Aluno;
import exercicio_aula_3.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoByIndex(int index) {
        List<Aluno> alunos = getAllAlunos();
        if (index >= 0 && index < alunos.size()) {
            return alunos.get(index);
        }
        return null;
    }

    @Override
    public void createAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public void updateAluno(int index, Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public void deleteAluno(int index) {
        List<Aluno> alunos = getAllAlunos();
        if (index >= 0 && index < alunos.size()) {
            alunoRepository.delete(alunos.get(index).getId());
        }
    }
}
