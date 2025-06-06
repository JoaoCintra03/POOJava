package joao.cintra.service;

import joao.cintra.dao.AlunoDao;
import joao.cintra.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    public boolean salvar(Aluno aluno) {
        var dao = new AlunoDao();
        return dao.insert(aluno);
    }

    public List<Aluno> listarTodos() {
        var dao = new AlunoDao();
        List<Aluno> alunos = new ArrayList<>();
                  dao.selectALL().forEach(object -> alunos.add((Aluno) object));

        return alunos;
    }
}
