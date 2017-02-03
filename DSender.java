import java.net.*;  

public class DSender {

	public static void main(String[] args) throws Exception {
		
		/* Creación de Socket de tipo Datagram */
		DatagramSocket ds;
		/* Apertura de socket */
		ds = new DatagramSocket();

		/* 
			Se genera una Net Address que permite la manipulación
			tanto de direcciones IP como nombres de dominio
		*/
	    InetAddress ip = InetAddress.getByName("192.168.0.2");  
	     
	    /* Se genera una prueba de envío de paquetes tipo Datagram */
	    for (int i = 0; i <= 1000; i++) {
			
			String str = Integer.toString(i);

			/* 
				1. Se obtiene el paquete con el tamaño del Objeto 
				2. Se establece la ip
				3. Se indica un puerto
			*/
			DatagramPacket dp = new DatagramPacket(
				str.getBytes(),
				str.length(),
				ip,
				3000
			);

			/* Se envía el paquete */
	    	ds.send(dp);

	    }

	    ds.close();  

	}

}