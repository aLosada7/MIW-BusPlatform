package impl.miw.presentation.controller;

import impl.miw.presentation.commands.Command;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ControllerConfigurationManager {

	private static ControllerConfigurationManager instance = null;
	private Properties data;

	public static synchronized ControllerConfigurationManager getInstance() {
		if (instance == null) {
			instance = new ControllerConfigurationManager();
		}
		return instance;
	}

	public ControllerConfigurationManager() {
		// Cargamos el properties
		data = new Properties();
		try {
			InputStream file = ControllerConfigurationManager.class.getClassLoader().getResourceAsStream(
					"controller.properties");
			System.out.println("Loading "+file);
			data.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Métodos de negocio
	public Command getCommand(String action) {
		try {

			Class<?> clazz = Class.forName(data.getProperty(action+".command"));
			return (Command)clazz.newInstance();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getForward(String action)
	{
		return data.getProperty(action+".success");
	}
}
