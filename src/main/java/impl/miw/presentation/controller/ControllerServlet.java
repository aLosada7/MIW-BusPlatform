package impl.miw.presentation.controller;

import impl.miw.presentation.commands.Command;
import impl.miw.presentation.di.HttpSessionAware;
import impl.miw.presentation.di.ServletContextAware;
import impl.miw.presentation.di.ServletRequestAware;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Command command;

		// Executamos el comando recibido
		String action = req.getParameter("action");
		if (action != null) {
			System.out.println("Executing Action "
					+ action
					+ " with "
					+ ControllerConfigurationManager.getInstance().getCommand(
							action));

			command = ControllerConfigurationManager.getInstance().getCommand(
					action);

			// dependency injection
			if (command instanceof ServletRequestAware) {
				((ServletRequestAware) command).setServletRequest(req);
			}
			if (command instanceof HttpSessionAware) {
				((HttpSessionAware) command).setHttpSession(req.getSession());
			}
			if (command instanceof ServletContextAware) {
				((ServletContextAware) command).setServletContext(req.getSession().getServletContext()
						);
			}

			// Pasamos los prámetros por inyección de dependencias por setter
			for (Object o : req.getParameterMap().keySet()) {
				String s = (String) o;
				try {
					Method m = command.getClass().getMethod(
							"set" + s.substring(0, 1).toUpperCase()
									+ s.substring(1), String.class);
					if (m != null) {
						System.out.println("Found. Propagating value");
						try {
							m.invoke(command, req.getParameter(s));
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Ejecutamos el comando y rediriginos
			command.execute();

			RequestDispatcher dispatcher = req
					.getRequestDispatcher(ControllerConfigurationManager
							.getInstance().getForward(action));
			dispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
