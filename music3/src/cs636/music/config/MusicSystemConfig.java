package cs636.music.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cs636.music.dao.AdminDAO;
import cs636.music.dao.DbDAO;
import cs636.music.dao.DownloadDAO;
import cs636.music.dao.InvoiceDAO;
import cs636.music.dao.ProductDAO;
import cs636.music.dao.UserDAO;
import cs636.music.service.AdminService;
import cs636.music.service.AdminServiceAPI;
import cs636.music.service.UserService;
import cs636.music.service.UserServiceAPI;



public class MusicSystemConfig {
	public static final String SOUND_BASE_URL = "http://www.cs.umb.edu/cs636/music1-setup/sound/";
	private static AdminServiceAPI adminService;
	private static UserServiceAPI userService;
	private static DownloadDAO downloadDao;
	private static InvoiceDAO invoiceDao;
	private static ProductDAO productDao;
	private static UserDAO userDao;
	private static AdminDAO adminDao;
	
	private static EntityManagerFactory emf;

	
	static {
		try {
			System.out.println("Starting JPA initialization");
			configureServices();
		} catch (Exception e) {
			
			System.out.println("Exception in static initializer");
			System.out.println(exceptionReport(e));
			e.printStackTrace();
		}
	}

	public static void configureServices()
		throws Exception {	
		try {
			emf = configureJPA(); 
			System.out.println("Calling dbDAO constructor");
			DbDAO dbDAO = new DbDAO(emf);
			
			productDao = new ProductDAO(dbDAO);
			userDao = new UserDAO(dbDAO);
			downloadDao = new DownloadDAO(dbDAO);		
			invoiceDao = new InvoiceDAO(dbDAO);
			adminDao= new AdminDAO(dbDAO);
			
			adminService = new AdminService(dbDAO,downloadDao, invoiceDao, adminDao);
			userService = new UserService(productDao,userDao,downloadDao,invoiceDao, dbDAO);
		} catch (Exception e) {
			System.out.println("Problem with contacting DB");
			System.out.println("Exception: " + exceptionReport(e));
			throw new RuntimeException("Exception in configureServices",e); 
		}
	}
	
	
	public static EntityManagerFactory configureJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("music3el");
		return emf;
	}
	
	
	public static String exceptionReport(Exception e) {
		String message = e.toString(); 
		if (e.getCause() != null) {
			message += "\n  cause: " + e.getCause().toString();
			if (e.getCause().getCause() != null)
				message += "\n    cause's cause: "
						+ e.getCause().getCause().toString();
		}
		return message;
	}
	
	 
	public static void shutdownServices() {
		if (emf != null && !emf.isOpen())
			emf.close();
	}
	
	public static AdminServiceAPI getAdminService() {
		return adminService;
	}

	public static UserServiceAPI getUserService() {
		return userService;
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 