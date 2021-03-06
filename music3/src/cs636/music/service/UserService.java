package cs636.music.service;

import java.util.Date;
import java.util.Set;

import cs636.music.dao.DbDAO;
import cs636.music.dao.DownloadDAO;
import cs636.music.dao.InvoiceDAO;
import cs636.music.dao.ProductDAO;
import cs636.music.dao.UserDAO;
import cs636.music.domain.Cart;
import cs636.music.domain.Download;
import cs636.music.domain.Invoice;
import cs636.music.domain.LineItem;
import cs636.music.domain.Product;
import cs636.music.domain.Track;
import cs636.music.domain.User;


public class UserService implements UserServiceAPI {

	private DownloadDAO downloadDb;
	private InvoiceDAO invoiceDb;
	private ProductDAO prodDb;
	private UserDAO userDb;
	private DbDAO db;


	public UserService(ProductDAO productDao, UserDAO userDao,
			DownloadDAO downloadDao, InvoiceDAO invoiceDao, DbDAO dbdao) {
		downloadDb = downloadDao;
		invoiceDb = invoiceDao;
		prodDb = productDao;
		userDb = userDao;
		this.db = dbdao;
	}


	public Set<Product> getProductList() throws ServiceException {
		try {
			db.startTransaction();
			Set<Product> prodList = prodDb.findAllProducts();

			for (Product product : prodList) {
				for (Track track : product.getTracks())
					track.getSampleFilename();
			}
			db.commitTransaction();
			return prodList;
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Can't find product list in db: ", e);
		}
	}


	public Cart getNewCart() {
		return new Cart();
	}


	public void addItemtoCart(Product prod, Cart cart, int quantity) {
		LineItem item = cart.findItem(prod);
		if (item != null) { 
			int qty = item.getQuantity();
			item.setQuantity(qty + quantity);
		} else { 
			item = new LineItem();
			item.setProduct(prod);
			item.setQuantity(quantity);
			cart.getItems().add(item);
		}
	}


	public void changeCart(Product prod, Cart cart, int quantity) {
		LineItem item = cart.findItem(prod);
		if (item != null) {
			if (quantity > 0) {
				item.setQuantity(quantity);
			} else { 
						
				cart.removeItem(prod);
			}
		}
	}

	public void removeCartItem(Product prod, Cart cart) {
		LineItem item = cart.findItem(prod);
		if (item != null) {
			cart.removeItem(prod);
		}
	}


	public User registerUser(String firstname, String lastname, String email)
			throws ServiceException {
		
		try {
			db.startTransaction();
			User user = userDb.findUserByEmail(email);
			if (user == null) { 
				user = new User();
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setEmailAddress(email);
				userDb.insertUser(user);
			}
			db.commitTransaction();
			return user;
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Error while registering user: ", e);
		}
	}


	public User getUserInfo(String email) throws ServiceException {

		try {
			db.startTransaction();
			User user = userDb.findUserByEmail(email);
			db.commitTransaction();
			return user;
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Error while getting user info: ", e);
		}
	}

	
	public Product getProduct(String prodCode) throws ServiceException {
		try {
			db.startTransaction();
			Product prd = prodDb.findProductByCode(prodCode);
			
			for (Track track : prd.getTracks())
				track.getSampleFilename();
			db.commitTransaction();
			return prd;
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Error while registering user: ", e);
		}
	}

	
	public void checkout(Cart cart, User user) throws ServiceException {

		try {
			db.startTransaction();
			Invoice invoice = new Invoice();
			invoice.setInvoiceDate(new Date());
			for (LineItem item : cart.getItems()) {
				item.setInvoice(invoice);
			}
			invoice.setLineItems(cart.getItems());
			invoice.setIsProcessed("n");
			invoice.setUser(user);
			invoice.setTotalAmount(invoice.calculateTotalAmount());

			
			invoiceDb.insertInvoice(invoice);
			db.commitTransaction();
			cart.clear();
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Can't check out: ", e);
		}
	}

	public void addDownload(User usr, Track track) throws ServiceException {
		try {
			db.startTransaction();
			Download download = new Download();
			download.setUser(usr);
			download.setTrack(track);
			download.setDownloadDate(new Date());
		
			downloadDb.insertDownload(download);
			db.commitTransaction();
		} catch (Exception e) {
			db.rollbackAfterException();
			throw new ServiceException("Can't add download: ", e);
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 