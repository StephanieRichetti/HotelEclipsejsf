package hoteleclipsec.mb;

import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.dao.VendaIngressoDao;
import hoteleclipsec.entity.Hospedagem;
import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;



@ManagedBean
public class HospedagemMb {
	
	private Hospedagem hospedagem;
	private HospedagemDao dao;
	private List<Hospedagem> listaHospedagem;
	

	@PostConstruct
	public void init(){
		hospedagem = new Hospedagem();
		dao = new HospedagemDao();	
	}
	
	public List<Hospedagem> getListaHospedagem() {
		if (listaHospedagem == null) {
			listaHospedagem = dao.listar();
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
		dao.salvar(hospedagem);
		return "listagemHospedagem";
	}
	public String editar(Long id){
	 hospedagem = dao.buscarPorId(id);
		return "formcadhospedagem";
	}
	
	public String excluir(Long id){
		hospedagem  = dao.buscarPorId(id);
		hospedagem = dao.excluir(id);
		listaHospedagem = null;
		return "listagemHospedagem";
	}
}