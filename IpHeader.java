import java.nio.ByteBuffer;

public class IpHeader {
    private byte versionIhl; // Versão e IHL combinados
    private byte typeOfService;
    private short totalLength;
    private short identification;
    private short flagsFragmentOffset;
    private byte ttl;
    private byte protocol;
    private short headerChecksum;
    private byte[] sourceIP;
    private byte[] destinationIP;

    public IpHeader(byte[] sourceIP, byte[] destinationIP) {
        this.versionIhl = 0x45; // IPv4 e header length de 20 bytes
        this.ttl = 64;
        this.protocol = 1; // ICMP
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.totalLength = 20 + 8; // Header IP + ICMP
    }

    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.put(versionIhl);
        buffer.put(typeOfService);
        buffer.putShort(totalLength);
        buffer.putShort(identification);
        buffer.putShort(flagsFragmentOffset);
        buffer.put(ttl);
        buffer.put(protocol);
        buffer.putShort(headerChecksum);
        buffer.put(sourceIP);
        buffer.put(destinationIP);
        return buffer.array();
    }
}
