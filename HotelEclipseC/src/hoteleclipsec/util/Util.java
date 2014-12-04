package hoteleclipsec.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class Util {
	
	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	private static EntityManagerFactory entityManagerFactory;

	public static void iniciarPersistenceUnit() {
		if (entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("hoteleclipsec_pu");
		}
	}
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void fecharPersistenceUnit() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();		
		}
	}
	
	public static EntityManager getEntityManager(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest resquest = (HttpServletRequest) context.getExternalContext().getRequest();
		EntityManager entityManager = (EntityManager) resquest.getAttribute(ENTITY_MANAGER);
		return entityManager;
	}

	public static void setEntityManager(ServletRequest request,
			EntityManager entityManager) {
		request.setAttribute(ENTITY_MANAGER, entityManager);
	}
	
	
		public static void initFactory() {
			if(entityManagerFactory != null) return;
			entityManagerFactory = Persistence
			.createEntityManagerFactory("hoteleclipsesc_pu");


			}

			public static void closeFactory() {
			entityManagerFactory.close();
	}
}

