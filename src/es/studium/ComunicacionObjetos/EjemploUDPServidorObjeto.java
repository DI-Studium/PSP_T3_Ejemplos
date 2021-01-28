package es.studium.ComunicacionObjetos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class EjemploUDPServidorObjeto
{
static int puerto = 9876;
public static void main(String[] args)
{
try
{
// Socket para recibir el dato
DatagramSocket socket = new DatagramSocket(puerto);
// Recibimos el datagrama del cliente
byte[] recibidos = new byte[1024];
DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
System.out.println("Servidor esperando petición....");
socket.receive(recibo);
ByteArrayInputStream be = new ByteArrayInputStream(recibidos);
ObjectInputStream entrada = new ObjectInputStream(be);
// Recibe un objeto
Persona dato = (Persona) entrada.readObject();
System.out.println("Datos recibidos del Cliente: " + dato.getNombre() + "-"
+ dato.getEdad());
socket.close();
}
catch (IOException e)
{
e.printStackTrace();
}
catch (ClassNotFoundException e)
{
e.printStackTrace();
}
}
}
