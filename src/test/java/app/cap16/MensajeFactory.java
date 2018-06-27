package app.cap16;

import java.io.FileInputStream;
import java.util.Properties;

public class MensajeFactory {
	public static Mensaje getMensaje() {
		Mensaje mensaje = null;
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("./src/test/resources/mensaje.properties"));
			String tipo = properties.getProperty("tipo");
			
			if (tipo.equalsIgnoreCase("html")) {
				mensaje = new MensajeHTML();
			} else {
				mensaje = new MensajePlano();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensaje;
	}

}
