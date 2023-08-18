package model;

public class JavaBeans {
	private String matricula;
	private String nome;
	private String endereco;
	private String documento;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String matricula, String nome, String endereco, String documento) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.documento = documento;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
}
