public class Host {
    private String ipAddress;
    private long responseTime;

    public Host(String ipAddress, long responseTime) {
        this.ipAddress = ipAddress;
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "IP: " + ipAddress + ", Tempo de resposta: " + responseTime + " ms";
    }
}
