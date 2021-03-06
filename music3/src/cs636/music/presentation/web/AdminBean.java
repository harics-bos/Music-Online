package cs636.music.presentation.web;

import cs636.music.service.AdminServiceAPI;
import cs636.music.config.MusicSystemConfig;
import cs636.music.domain.Download;
import cs636.music.domain.Invoice;
import cs636.music.service.ServiceException;

import java.util.HashSet;
import java.util.Set;


public class AdminBean {

	private AdminServiceAPI adminService;
	private String username = null;
	private String password = null;
	private int invoiceId;
	private String message = null;
	private Invoice invoice = new Invoice();
	public AdminBean() {
		adminService = MusicSystemConfig.getAdminService();
	}
	
	public String initDB() {
		String info = null;
		try {
			adminService.initializeDb();			
			info = "OK";
		} catch (ServiceException e) {
			info = "failed: " + MusicSystemConfig.exceptionReport(e);		}
		return info;
	}
	
	
	
public void processInvoice() throws ServiceException
{
	try{
			adminService.processInvoice(invoiceId);
		}
	catch (ServiceException e) 
	{
		MusicSystemConfig.exceptionReport(e);		
	}
	
}



	public Set<Invoice> getListofInvoices() throws ServiceException
	{
		Set<Invoice> invoices = new HashSet<Invoice>();
		try{
			invoices = adminService.getListofInvoices();
		}
		catch (ServiceException e){
			MusicSystemConfig.exceptionReport(e);
		}
		return invoices;
	}
	

	public Set<Invoice> getListofUnprocessedInvoices() throws ServiceException{
		Set<Invoice> invoices = new HashSet<Invoice>();
		try{
			invoices = adminService.getListofUnprocessedInvoices();
		}
		catch (ServiceException e){
			MusicSystemConfig.exceptionReport(e);
		}
		return invoices;
	}
	

	public Set<Download> getListofDownloads() throws ServiceException{
		Set<Download> downloads = new HashSet<Download>();
		try{
			downloads = adminService.getListofDownloads();
		}
		catch (ServiceException e){
			MusicSystemConfig.exceptionReport(e);
		}
		return downloads;
	}
	

	public String checkLogin()throws ServiceException{
		boolean exists = false;
		try{
			exists = adminService.checkLogin(username, password);
			if(exists == true)
				this.setMessage("OK");
			else
				this.setMessage(null);
		}
		catch (ServiceException e){
			MusicSystemConfig.exceptionReport(e);
		}
		return message;
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
		public void setPassword(String password) {
		this.password = password;
	}
		public String getPassword() {
			return password;
		}
		public void setInvoiceId(int invoice_id) {
			this.invoiceId = invoice_id;
		}

		public int getInvoiceId() {
			return invoiceId;
		}
		
		public void setMessage(String Message) {
			this.message = Message;
		}

		public String getMessage() {
			return message;
		}

		public void setInvoice(Invoice invoice) {
			this.invoice = invoice;
		}

		public Invoice getInvoice() {
			Set<Invoice>invoices = new HashSet<Invoice>();
			try {
				invoices = adminService.getListofInvoices();
				for (Invoice i : invoices)
				{
					if(i.getInvoiceId() == this.invoiceId)
					 invoice = i;
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			return invoice;
		}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       