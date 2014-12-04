package hoteleclipsec.mb;

import hoteleclipsec.dao.ReservaDao;

import hoteleclipsec.entity.Reserva;

import hoteleclipsec.util.Util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean
public class ReservaMb {

	
	private Reserva reserva;
	private ReservaDao dao;
	private List<Reserva> listaReserva;
	

	@PostConstruct
	public void init(){
		reserva = new Reserva();
		dao = new ReservaDao();
	}
	
	public List<Reserva> getListaReserva() {
		if (listaReserva == null) {
			listaReserva = dao.listar();
		}
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String salvar() {
		dao.salvar(reserva);
		return "listagemReserva";
	}

	public String editar(Long id){
		reserva = dao.buscarPorId(id);
		return "formcadreserva";
	}
	
	public String excluir(Long ID){
		reserva = dao.buscarPorId(ID);
		reserva = dao.excluir(ID);
		listaReserva = null;
		return "listagemReserva";
	}
	
}
