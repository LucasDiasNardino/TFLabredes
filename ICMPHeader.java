import java.util.Random;
import java.nio.ByteBuffer;

public class ICMPHeader {
    private byte type;
    private byte code;
    private short checksum;
    private short identifier;
    private short sequenceNumber;

    public ICMPHeader() {
        this.type = 8; // ICMP Echo Request
        this.code = 0;
        this.identifier = (short) new Random().nextInt(65535);
        this.sequenceNumber = 1;
    }

    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(type);
        buffer.put(code);
        buffer.putShort(checksum);
        buffer.putShort(identifier);
        buffer.putShort(sequenceNumber);
        checksum = calculateChecksum(buffer.array());
        buffer.putShort(2, checksum); // Atualiza o checksum no buffer
        return buffer.array();
    }

    private short calculateChecksum(byte[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i += 2) {
            int value = ((data[i] & 0xFF) << 8) + (data[i + 1] & 0xFF);
            sum += value;
            if ((sum & 0xFFFF0000) != 0) { // Overflow
                sum = (sum & 0xFFFF) + 1;
            }
        }
        return (short) ~sum;
    }
}
