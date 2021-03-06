
package cs636.music.presentation.web;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import cs636.music.config.MusicSystemConfig;
import cs636.music.domain.*;
import cs636.music.service.UserServiceAPI;
import cs636.music.service.ServiceException;

public class UserBean {
	
	private UserServiceAPI userService;
	private User user = new User();
	private String productCode = null;
	private int quantity = 0;
	private Cart cart = null;
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	private Product product = new Product();
	private int trackNumber = 0;
	private Track track = new Track();
	private int productId = 0;
	public UserBean() {
		user = null;
		userService = MusicSystemConfig.getUserService();
		cart = userService.getNewCart();
	}
	
	
public Set<Product> getProductList() throws ServiceException
{
	Set<Product> products = new HashSet<Product>();
	try{
		products = userService.getProductList();
	}
    catch (ServiceException e) 
    {
    	MusicSystemConfig.exceptionReport(e);		
    }
    return products;
}


	public void addItemtoCart()
	{
		Product prod = new Product();
		try {
			prod = userService.getProduct(productCode);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		userService.addItemtoCart(prod, cart, quantity);
	    		
	}
	
	
	public void changeCart()throws ServiceException
	{
		Product prod = new Product();
		try {
			prod = userService.getProduct(productCode);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		userService.changeCart(prod, cart, quantity);
	    
	}
	

	public void removeCartItem() throws ServiceException
	{
		Product prod = new Product();
		try {
			prod = userService.getProduct(productCode);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		userService.removeCartItem(prod, cart);
		
	}
	

	public User registerUser()throws ServiceException 
	{
		try{
			user = userService.registerUser(firstName, lastName, email);
		}
	    catch (ServiceException e) 
	    {
	    	MusicSystemConfig.exceptionReport(e);		
	    }
	    return user;
		
	}


	public User getUserInfo(String email) throws ServiceException
	{
		try{
			user = userService.getUserInfo(email);
		}
	    catch (ServiceException e) 
	    {
	    	MusicSystemConfig.exceptionReport(e);		
	    }
	    return user;
		
	}
	

	public Product getProduct(String prodCode) throws ServiceException
	{
		Product prod = new Product();
		try{
			prod = userService.getProduct(prodCode);
		}
	    catch (ServiceException e) 
	    {
	    	MusicSystemConfig.exceptionReport(e);		
	    }
	    return prod;
	}
	

	public void checkout() throws ServiceException, SQLException
	{
		try{
			userService.checkout(cart, user);
		}
	    catch (ServiceException e) 
	    {
	    	MusicSystemConfig.exceptionReport(e);		
	    }
	}
	

	public void addDownload() throws ServiceException
	{
	    track = product.findTrackByNumber(trackNumber);
		try{
			 userService.addDownload(user, track);
		}
	    catch (ServiceException e) 
	    {
	    	MusicSystemConfig.exceptionReport(e);		
	    }
	}
	

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Cart getCart() {
		return cart;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	
	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		try {
			product = userService.getProduct(productCode);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return product;
	}

	
	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              