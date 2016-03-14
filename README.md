# Music-Online

System: topcat.cs.umb.edu
Port: Hari  - 51300
      

Email: hariharan.sridhar001@umb.edu;
       
        
Report:   cs636/pa3/music3/src: Top of the source tree

cs636.music.config package
MusicSystemConfig - This class configures the music system admin and user service objects and shuts them down.
TransactionSessionCustomizer -  This class facilitates to use serializable transactions.

cs636.music.presentation package
PresentationUtils - This class handles presentation and display of the contents  to the user.
SystemTest - This class tests the functionality of the music store system.

cs636.music.domain package
Cart - This class has getter and setter for Cart object and handles cart related functions. This is a memory-only object.
Download - This is a persistent class for the DOWNLOAD database table and consists of getters and setters for Download object attributes.
Invoice -This is a persistent class for the INVOICE database table and consists of getters and setters for Invoice object attributes.
Lineitem - This is a persistent class for the LINEITEM database table and consists of getters and setters for LineItem object attributes.
Product - This is a persistent class for the PRODUCT database table and consists of getters and setters For Product object attributes.

cs636.music.dao package
AdminDAO - This class is responsible for accessing admin related tables.
DBConstants - This class has DataBase schema related constants.
DbDAO ñ This class does DataBase connection and initialization.
DownloadDAO - This class is responsible for accessing Download table.
InvoiceDAO - This class is responsible for accessing Invoice table.
ProductDAO - This class is responsible for accessing Product and Track tables.
UserDAO - This class is responsible for accessing site_user table.


cs636.music.presentation.web
AdminBean- This bean consists of admin related Mutators, called from scriplets within the admin JSPs and these Mutators call the corresponding service layer methods.    
SysTestServlet - This servlet is used to run web app in a quick way without JSPs by taking test.dat file as an input and passes it as a parameter to SystemTest class.
UserBean- This bean consists of user related Mutators, called from scriplets within the user JSPs and these Mutators call the corresposnding service layer methods.

cs636.music.presentation.clientserver package
AdminApp - This class consists of Line-oriented client code for Music store administrator and forms the front end for the admin user.
Register - This class registers a user into Site User table.
UserApp - This class consists of Line-oriented client code for Music Site user and forms the front end for the user.


cs636.music.service package
AdminService - This class provides admin level services to admin app by accessing the appropriate DAOs.
AdminServiceAPI - This is an interface class that contains extraction of the service interface AdminService.java 
ServiceException - This exception is thrown from business logic layer to presentation layer.
UserService -   This class provides user level services to user app by accessing the appropriate DAOs.
UserServiceAPI - This is an interface class that contains extraction of the service interface UserService.java 


  





  

