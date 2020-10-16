import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Three {
    public static void request(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            int c=0;
            while ((s = inputStream.readLine()) != null&& c!=6) {
                if(c==6/2){
                    System.out.println("MEDIAN IS "+ s);
                }
                System.out.println(s);
                c++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pingRequest(String ipAddress)
            throws UnknownHostException, IOException
    {
        InetAddress addr = InetAddress.getByName(ipAddress);
        System.out.println("sending request to" + ipAddress);
        if (addr.isReachable(5000))

            System.out.println("Host is reachable");
        else
            System.out.println("not reachable");
    }

    public static void main(String[] args) throws UnknownHostException, IOException
    {
//        String ipAddress = "127.0.0.1";
//        pingRequest(ipAddress);
//
//        ipAddress = "133.192.31.42";
//        pingRequest(ipAddress);
//
//        ipAddress = "145.154.42.58";
//        pingRequest(ipAddress);

        String ip = "google.com";
        request("ping " + ip);

    }
}
