package hoteleclipsec.dao;


import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


	public class VendaIngressoDao {
		
		private EntityManager entityManager;

		public VendaIngressoDao() {
			entityManager = Util.getEntityManager();
		}

		public List<VendaIngresso> listar() {
			Query query = entityManager.createQuery("From VendaIngresso", VendaIngresso.class);
			return query.getResultList();
		}

		public VendaIngresso salvar(VendaIngresso vendaIngresso) {
			try {
				if (vendaIngresso.getId() == null) {
					entityManager.persist(vendaIngresso);
				} else {
					entityManager.merge(vendaIngresso);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return vendaIngresso;
		}

		public VendaIngresso buscarPorId(Long id) {
			return entityManager.find(VendaIngresso.class, id);
		}

		public VendaIngresso excluir(Long id) {
			VendaIngresso vendaIngresso = entityManager.getReference(VendaIngresso.class, id);
			entityManager.remove(vendaIngresso);
			return vendaIngresso;
		}

	}
