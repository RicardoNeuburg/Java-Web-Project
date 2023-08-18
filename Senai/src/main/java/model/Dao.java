package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/senai?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "12345625";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirUsuario(JavaBeans usuario) {
		String criar = "INSERT INTO usuarios (nome, endereco, documento) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst  = con.prepareStatement(criar);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEndereco());
			pst.setString(3, usuario.getDocumento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<JavaBeans> listarUsuarios(){
		ArrayList<JavaBeans> usuarios = new ArrayList<>();
		String read = "SELECT * FROM usuarios order by matricula";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String matricula = rs.getString(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String documento = rs.getString(4);
				usuarios.add(new JavaBeans(matricula, nome, endereco, documento));
			}
			con.close();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarUsuario(JavaBeans usuario) {
		String read2 = "SELECT * FROM usuarios WHERE matricula =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, usuario.getMatricula());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				usuario.setMatricula(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEndereco(rs.getString(3));
				usuario.setDocumento(rs.getString(4));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void alterarUsuario(JavaBeans usuario) {
		String create = "UPDATE usuarios SET nome=?, endereco=?, documento=? WHERE matricula=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEndereco());
			pst.setString(3, usuario.getDocumento());
			pst.setString(4, usuario.getMatricula());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void excluirUsuario(JavaBeans usuario) {
		String excluir = "DELETE FROM usuarios WHERE matricula=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(excluir);
			pst.setString(1, usuario.getMatricula());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
