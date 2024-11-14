import java.net.*;
import java.nio.ByteBuffer;

public class RawSocketUtils {
    public static void sendPacket(byte[] packetData, String destinationIP) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress destination = InetAddress.getByName(destinationIP);
        DatagramPacket packet = new DatagramPacket(packetData, packetData.length, destination, 0);
        socket.send(packet);
        socket.close();
    }
}
