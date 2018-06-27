package app.cap16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Principal {

	public static void mensajeFactoria() {
		Mensaje mensaje = MensajeFactory.getMensaje();
		mensaje.hola();
	}
	
	public static void mensajeSpring() {
		ApplicationContext factoria = new FileSystemXmlApplicationContext("./src/test/resources/contextoAplicacionHola.xml");
		Mensaje mensaje = (Mensaje)factoria.getBean("mensajePlano");
		mensaje.hola();
	}
	
	public static void main(String[] args) {
		mensajeSpring();
		//mensajeFactoria();
	}
}
