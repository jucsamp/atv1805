package controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Alunos;

public class AlunosExec {
	public static void main(String args[]) {
		Alunos alunos = new Alunos();
		try {
			alunos.setNome("Jeferson Roberto de Lima");
			alunos.setEndereco("Av Águia de Haia, 2600");
			alunos.setBairro("Jd São Nicolau");
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDAO = new AlunosJdbcDAO(connection);
			
			alunosJdbcDAO.salvar(alunos);
			//alunosJdbcDAO.listar();
			//alunosJdbcDAO.alterar(alunos);
			//alunosJdbcDAO.excluir(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
