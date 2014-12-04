package hoteleclipsec.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.entity.Hospedagem;
import hoteleclipsec.util.Util;



@ManagedBean
public class HospedagemMb {
	
	private Hospedagem hospedagem;
	private HospedagemDao dao;
	private EntityManager entityManager;
	private List<Hospedagem> listaHospedagem;
	

	@PostConstruct
	public void init(){
		setHospedagem(new Hospedagem());
		dao = new HospedagemDao(entityManager);
		entityManager = Util.getEntityManager();
	}
	
	public List<Hospedagem> getListaHospedagem() {
		if (listaHospedagem == null) {
			Query query = entityManager.createQuery(
					"SELECT h FROM Hospedagem h", Hospedagem.class);
			listaHospedagem = query.getResultList();
		}
		return listaHospedagem;
	}

	public void setListaHospedagem(List<Hospedagem> listaHospedagem) {
		this.listaHospedagem = listaHospedagem;
	}
	
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	


	public String salvar() {
		entityManager.merge(getHospedagem());
		return "listagemHospedagem";
	}

	public String editar(Long ID){
		Hospedagem hospedagem = entityManager.find(Hospedagem.class, ID);
		return "formcadhospedagem";
	}
	
	public String excluir(Long ID){
		Hospedagem hospedagem = entityManager.getReference(Hospedagem.class, ID);
		entityManager.remove(hospedagem);
		listaHospedagem = null;
		return "listagemHospedagem";
	}
}
