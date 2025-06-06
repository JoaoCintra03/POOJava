package joao.cintra.dao;

import joao.cintra.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao extends Dao implements DaoInterface {

    @Override
    public Boolean insert(Object entity) {
        try {
            var aluno = (Aluno) entity;
            var insertSql = "insert into aluno(nome, cpf, endereco) values(?,?,?)";
            var ps = getConnection().prepareStatement(insertSql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getEndereco());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public Boolean uptade(Object entity) {
        return null;
    }

    @Override
    public Boolean delete(Long pk) {
        return null;
    }

    @Override
    public List<Object> select(Long pk) {
        return List.of();
    }

    @Override
    public List<Object> selectALL() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            var selectSql = "select * from aluno";
            var  rs = getConnection().prepareStatement(selectSql).executeQuery();
            while (rs.next());
            alunos.add(new Aluno(
                    rs.getLong("id"),
                    rs.getLong("Nome"),
                    rs.getLong("Cpf"),
                    rs.getLong("Endereço")
            ));
        }catch (Exception e){

        }

            return new ArrayList<>(alunos);
    }
}
