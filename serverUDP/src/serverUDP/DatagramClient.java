package serverUDP;

import java.net.*;

public class DatagramClient {
	private final static int PACKETSIZE = 100;

	public static void main(String args[]) {

		DatagramSocket socket = null;

		try {

			InetAddress host = InetAddress.getByName(args[0]);
			int port = Integer.parseInt(args[1]);

			socket = new DatagramSocket();

			byte[] data = "Hello Server".getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, host, port);

			socket.send(packet);

			socket.setSoTimeout(2000);

			packet.setData(new byte[PACKETSIZE]);

			socket.receive(packet);

			System.out.println(new String(packet.getData()));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (socket != null)
				socket.close();
		}
	}
}