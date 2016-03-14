package cs636.music.config;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.Session;


public class TransactionSessionCustomizer implements SessionCustomizer {
    public TransactionSessionCustomizer() {}
    
    public void customize(Session session) {
        DatabaseLogin login = (DatabaseLogin)session.getDatasourceLogin();
        System.out.println("Customizing Database Session...");
        System.out.println("Database URL is " + login.getDatabaseURL());
        System.out.println("Now setting future transactions to serializable isolation");
        login.setTransactionIsolation(DatabaseLogin.TRANSACTION_SERIALIZABLE);
        if (login.getTransactionIsolation() != DatabaseLogin.TRANSACTION_SERIALIZABLE)
        	System.out.println("--but not actually set to serializable");
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     