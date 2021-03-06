package cs636.music.dao;

import static cs636.music.dao.DBConstants.DOWNLOAD_TABLE;
import static cs636.music.dao.DBConstants.INVOICE_TABLE;
import static cs636.music.dao.DBConstants.LINEITEM_TABLE;
import static cs636.music.dao.DBConstants.SYS_TABLE;
import static cs636.music.dao.DBConstants.USER_TABLE;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class DbDAO {
	   
	private EntityManagerFactory emf;
	private EntityManager em;

	public EntityManager getEM() {
		return em;
	}

	public DbDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void startTransaction() {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	}

	public void commitTransaction() {
		em.getTransaction().commit();
	
		em.close(); 
		em = null;  
	}

	public void rollbackTransaction() {
		try {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	

	public void rollbackAfterException() {
		try {
			rollbackTransaction();
		} catch (Exception e) {
			
		}
	}
	

	public void initializeDb() throws SQLException {
		clearTable(DOWNLOAD_TABLE);
		clearTable(LINEITEM_TABLE);
		clearTable(INVOICE_TABLE);
		clearTable(USER_TABLE);	
		initSysTable();
	}


	private void clearTable(String tableName) {
		Query q = em.createNativeQuery("delete from " + tableName);
		int n = q.executeUpdate(); // SQL of update shows in FINE logging
		System.out.println("deleted " + n + " rows from " + tableName);
	}
	

	private void initSysTable() {
		System.out.println("inserting new id start values into " + SYS_TABLE);
		Query q = em.createNativeQuery("update " + SYS_TABLE + " set gen_val=0");
		q.executeUpdate();
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      