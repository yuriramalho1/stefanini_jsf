package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	public static EntityManagerFactory factory = null;

	static {
		init();
	}
	private static void init() {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("stefanini_PUU");
			}
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		try
		{
			return factory.createEntityManager(); 
		}
		catch (Exception e)
		{
			throw new ExceptionInInitializerError(e);
		}
		
	}

	public static Object getPrimaryKey(Object entity) { 
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
