package impl.miw.presentation;

import java.util.ArrayList;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miw.business.BookManagerService;
import com.miw.model.Book;


public class BookManagerServiceHelper {
	
	private static ApplicationContext context = null;
	
	private ApplicationContext getContext()
	{
		if ( context == null )
		{
			context = 
		             new ClassPathXmlApplicationContext("beans.xml");
		}
		return context;
	}

	public Vector<Book> getBooks() throws Exception
	{		
		
		//We load the service
		BookManagerService bms = (BookManagerService) getContext().getBean("bookManagerService");
		return bms.getBooks();
	}

	public ArrayList<Book> getSpecialOffer() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");
		//We load the service
		BookManagerService bms = (BookManagerService) getContext().getBean("bookManagerService");
		return bms.getSpecialOffer();
	}
}
