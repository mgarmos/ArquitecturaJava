package app.cap16;

public class MensajeHTML implements Mensaje {


	@Override
	public void hola() {
		System.out.println("<html>hola</html>");
	}
}
