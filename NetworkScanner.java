import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkScanner {
    private List<Host> activeHosts;
    private byte[] sourceMac;
    private byte[] sourceIP;
    private int timeout;

    public NetworkScanner(byte[] sourceMac, byte[] sourceIP, int timeout) {
        this.activeHosts = new ArrayList<>();
        this.sourceMac = sourceMac;
        this.sourceIP = sourceIP;
        this.timeout = timeout;
    }

    public void scan(String destinationSubnet) {
        List<String> ips = NetworkUtils.calculateIPRange(destinationSubnet);
        for (String destinationIP : ips) {
            try {
                byte[] destinationMac = NetworkUtils.getMacAddress(destinationIP); // Suponha um método para resolver o MAC
                PacketBuilder packetBuilder = new PacketBuilder(sourceMac, destinationMac, sourceIP, InetAddress.getByName(destinationIP).getAddress());
                byte[] packet = packetBuilder.buildPacket();
                RawSocketUtils.sendPacket(packet, destinationIP);

                // Log de envio do pacote ICMP
                System.out.println("Enviado ICMP request para " + destinationIP);
                
                // Código adicional para medir o tempo de resposta e verificar resposta ICMP
                
            } catch (Exception e) {
                System.out.println("Erro ao escanear IP " + destinationIP + ": " + e.getMessage());
            }
        }
    }

    public void displayResults() {
        for (Host host : activeHosts) {
            System.out.println("Host ativo: " + host);
        }
        System.out.println("Máquinas ativas: " + activeHosts.size());
    }
}
