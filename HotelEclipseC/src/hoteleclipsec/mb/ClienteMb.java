package hoteleclipsec.mb;

import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.entity.Cliente;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean
public class ClienteMb {
	
	private Cliente cliente;
	private ClienteDao dao;
	private EntityManager entityManager;
	private List<Cliente> listaClientes;
	private Long ID;
	private String nome;
	private String CPF;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String email;
	private String telefone;


	@PostConstruct
	public void init(){
		setCliente(new Cliente());
		dao = new ClienteDao(entityManager);
		entityManager = Util.getEntityManager();
	}
	
	public List<Cliente> getListaClientes() {
		if (listaClientes == null) {
			Query query = entityManager.createQuery(
					"SELECT c FROM Cliente c", Cliente.class);
			listaClientes = query.getResultList();
		}
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String salvar() {
		entityManager.merge(cliente);
		return "listagemClientes";
	}

	public String editar(Long ID){
		cliente = entityManager.find(Cliente.class, ID);
		return "formcadclientes";
	}
	
	public String excluir(Long ID){
	    Cliente cliente = entityManager.getReference(Cliente.class, ID);
		entityManager.remove(cliente);
		listaClientes = null;
		return "listagemClientes";
	}
}

