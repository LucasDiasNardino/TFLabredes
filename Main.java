public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java NetworkScanner <subnet> <timeout>");
            System.exit(1);
        }

        String subnet = args[0];
        int timeout = Integer.parseInt(args[1]);
        byte[] sourceMac = new byte[] { (byte) 0x00, (byte) 0x0C, (byte) 0x29, (byte) 0x3E, (byte) 0x5B, (byte) 0x1C }; // Exemplo
        byte[] sourceIP = new byte[] { (byte) 192, (byte) 168, 1, 10 }; // Exemplo

        NetworkScanner scanner = new NetworkScanner(sourceMac, sourceIP, timeout);
        scanner.scan(subnet);
        scanner.displayResults();
    }
}
