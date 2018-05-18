package controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Alunos;

public class AlunosJdbcDAO {
	private Connection conn;
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos (nome, endereco, bairro) values ('"+c.getNome()+"', '"+c.getEndereco()+"', '"+c.getBairro()+"')";
	    System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void excluir(int id) {
		String sql = "delete from alunos where id='"+id+"';";
		System.out.println(sql);
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}