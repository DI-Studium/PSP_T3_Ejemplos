package es.studium.EnvioRecepcion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Cliente
{
	public static void main(String[] args)
	{
		// Bytes del mensaje a enviar
		byte[] mensaje = "Saludos desde el cliente...".getBytes();
		// Dirección IP del destino
		InetAddress direccionDestino;
		try
		{
			direccionDestino = InetAddress.getByName("localhost");
			// Puerto destino
			int puertoDestino = 5555;
			// Creación del paquete a enviar
			DatagramPacket packet = new DatagramPacket(mensaje,
					mensaje.length, direccionDestino, puertoDestino);
			// Creación de un zócalo temporal con el que realizar el envío
			DatagramSocket socket = new DatagramSocket();
			// Envío del mensaje
			socket.send(packet);
			// Cerrar el socket
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}