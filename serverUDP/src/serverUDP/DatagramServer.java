package serverUDP;

import java.net.*;

public class DatagramServer {
	private final static int PACKETSIZE = 100;

	public static void main(String args[]) {
		try {

			int port = Integer.parseInt(args[0]);

			DatagramSocket socket = new DatagramSocket(port);

			System.out.println("Server pronto...");

			for (;;) {

				DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

				socket.receive(packet);

				System.out.println(packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()));

				socket.send(packet);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}