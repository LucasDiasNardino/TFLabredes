import java.nio.ByteBuffer;

public class EthernetHeader {
    private byte[] destinationMac;
    private byte[] sourceMac;
    private short etherType;

    public EthernetHeader(byte[] destinationMac, byte[] sourceMac, short etherType) {
        this.destinationMac = destinationMac;
        this.sourceMac = sourceMac;
        this.etherType = etherType;
    }

    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(14);
        buffer.put(destinationMac);
        buffer.put(sourceMac);
        buffer.putShort(etherType);
        return buffer.array();
    }
}
