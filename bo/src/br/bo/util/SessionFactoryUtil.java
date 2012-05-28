package br.bo.util;

// import livraria.LivroController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {

	private static org.hibernate.SessionFactory sessionFactory;

	private SessionFactoryUtil() {
	}

	static {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static SessionFactory getInstance() {
		return sessionFactory;
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
		sessionFactory = null;
	}

	public static void main(String[] args) {
		Session s = SessionFactoryUtil.getInstance().openSession();

	}
}
