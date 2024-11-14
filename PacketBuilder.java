import java.nio.ByteBuffer;

public class PacketBuilder {
    private EthernetHeader ethernetHeader;
    private IpHeader ipHeader;
    private ICMPHeader icmpHeader;

    public PacketBuilder(byte[] sourceMac, byte[] destinationMac, byte[] sourceIP, byte[] destinationIP) {
        this.ethernetHeader = new EthernetHeader(destinationMac, sourceMac, (short) 0x0800); // EtherType para IP
        this.ipHeader = new IpHeader(sourceIP, destinationIP);
        this.icmpHeader = new ICMPHeader();
    }

    public byte[] buildPacket() {
        ByteBuffer buffer = ByteBuffer.allocate(ethernetHeader.toByteArray().length + ipHeader.toByteArray().length + icmpHeader.toByteArray().length);
        buffer.put(ethernetHeader.toByteArray());
        buffer.put(ipHeader.toByteArray());
        buffer.put(icmpHeader.toByteArray());
        return buffer.array();
    }
}
