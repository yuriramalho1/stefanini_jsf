package dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class EntityManagerProduces {

	private static final String PERSISTENCE_UNIT = "stefanini_PU";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

	@Produces @RequestScoped
	public EntityManager createEntityManager(){
		EntityManager em = factory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		return em;
	}
 
	private EntityManagerProduces(){ }
}