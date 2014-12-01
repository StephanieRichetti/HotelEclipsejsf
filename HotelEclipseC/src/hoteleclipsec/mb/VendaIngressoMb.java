package hoteleclipsec.mb;


import hoteleclipsec.dao.VendaIngressoDao;
import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean
public class VendaIngressoMb {
	
	private VendaIngresso vendaIngresso;
	private VendaIngressoDao dao;	
	private List<VendaIngresso> listaVendaIngresso;
	
	@PostConstruct
	public void init(){
		vendaIngresso = new VendaIngresso();
		dao = new VendaIngressoDao();
	}
	
	public List<VendaIngresso> getListaVendaIngresso() {
		if (listaVendaIngresso == null) {
			listaVendaIngresso = dao.listar();
		}
		return listaVendaIngresso;
	}

	public void setListaVendaIngresso(List<VendaIngresso> listaVendaIngresso) {
		this.listaVendaIngresso = listaVendaIngresso;
	}
	
	public VendaIngresso getVendaIngresso() {
		return vendaIngresso;
	}
	
	public void setVendaIngresso(VendaIngresso vendaIngresso) {
		this.vendaIngresso = vendaIngresso;
	}

	public String salvar() {
		dao.salvar(vendaIngresso);
		return "listagemVendaIngresso";
	}

	public String editar(Long id){
		vendaIngresso = dao.buscarPorId(id);
		return "formcadvendaIngresso";
	}
	
	public String excluir(Long ID){
		vendaIngresso = dao.buscarPorId(ID);
		vendaIngresso = dao.excluir(ID);
		listaVendaIngresso = null;
		return "listagemVendaIngresso";
	}
}
