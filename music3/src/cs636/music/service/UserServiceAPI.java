package cs636.music.service;

import java.util.Set;

import cs636.music.domain.Cart;
import cs636.music.domain.Product;
import cs636.music.domain.Track;
import cs636.music.domain.User;

public interface UserServiceAPI {
	

	public Set<Product> getProductList() throws ServiceException;
	

	public Cart getNewCart();
	

	public void addItemtoCart(Product prod, Cart cart, int quantity);
	

	public void changeCart(Product prod, Cart cart, int quantity);
	

	public void removeCartItem(Product prod, Cart cart);

	
	public User registerUser(String firstname, String lastname, String email)
			throws ServiceException;
	
	
	public User getUserInfo(String email) throws ServiceException;
	
	
	public Product getProduct(String prodCode) throws ServiceException;
	

	public void checkout(Cart cart, User user) throws ServiceException;
	
	
	public void addDownload(User usr, Track track) throws ServiceException;
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  