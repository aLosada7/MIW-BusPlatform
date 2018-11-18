package impl.miw.presentation.commands;

import impl.miw.presentation.BookManagerServiceHelper;
import impl.miw.presentation.di.HttpSessionAware;
import impl.miw.presentation.di.ServletContextAware;
import impl.miw.presentation.di.ServletRequestAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBooksCommand implements Command, HttpSessionAware,
		ServletRequestAware, ServletContextAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext application;
	private String nada;
	
	public String getNada() {
		return nada;
	}

	public void setNada(String nada) {
		System.out.println("Recibido "+nada);
		this.nada = nada;
	}

	public ShowBooksCommand() {

	}

	public ShowBooksCommand(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see impl.miw.presentation.commands.Command#execute()
	 */
	public void execute() {
		System.out.println("Executing ShowBooksCommand");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			request.setAttribute("books", helper.getBooks());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setServletContext(ServletContext context) {
		System.out.println("Setting context in " + this.getClass());
		this.application = context;
	}

	public void setServletRequest(HttpServletRequest request) {
		System.out.println("Setting request in " + this.getClass());
		this.request = request;
	}

	public void setHttpSession(HttpSession session) {
		System.out.println("Setting session in " + this.getClass());
		this.session = session;
	}
}
