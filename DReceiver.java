//DReceiver.java  
import java.net.*;  

public class DReceiver{  
	public static void main(String[] args) throws Exception {  
		
		//Creación del socket
		DatagramSocket ds;

		//Apertura de socket
		ds = new DatagramSocket(3000);
		
		//Tamanio de mensaje
		byte[] buf = new byte[1024];

		//Paquetes recibidos en datagrama
		DatagramPacket datagram = new DatagramPacket(buf, 1024);

		while( true ){

			ds.receive(datagram); 
			String compare = new String(
				datagram.getData(), 0, datagram.getLength()
			);

			String msg = 
					compare +
					", from address: " +
					datagram.getAddress() +
					", port: " +
					datagram.getPort();

      		System.out.println( msg );
		}

		ds.close();  
	}  
}  
