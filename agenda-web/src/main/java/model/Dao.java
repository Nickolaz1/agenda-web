package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Dao.
 */
public class Dao {
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/bdAgenda";
	
	/** The user. */
	private String user = "root";
	
	/** The pass. */
	private String pass = "HACKnsp@52";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {	
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, user, pass);
			return conexao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Novo contato.
	 *
	 * @param contato the contato
	 */
	public void adicionarContato(JavaBeans contato) {
		String create = "insert into tbContatos(nome, fone, email)"
				+ "values(?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(create);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			stmt.setString(3, contato.getEmail());
			stmt.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos(){
        ArrayList<JavaBeans> contatos = new ArrayList<>();
        String read = "select * from tbContatos order by nome";
        try{
              Connection con = conectar();
              PreparedStatement stmt = con.prepareStatement(read);
              ResultSet rs = stmt.executeQuery();
              while(rs.next()){
                     String id = rs.getString(1);
                     String nome = rs.getString(2);
                     String fone = rs.getString(3);
                     String email = rs.getString(4);
                     contatos.add (new JavaBeans (id, nome, fone, email));
              }
              con.close();
              return contatos;
        }
        catch(Exception e){
              e.printStackTrace();
              return null;
        }
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read = "select * from tbContatos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "update tbContatos set nome = ?, fone = ?, email = ? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from tbContatos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}