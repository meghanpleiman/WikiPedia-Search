import java.net.InetAddress;
import java.net.URL;

public class GetIPAddress {
    public static void main(String[] args) throws Exception{
        InetAddress inetAddress = InetAddress.getByName(new URL(("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=revisions%7Cuser&rvlimit=30&titles=barack%20obama&redirects=")).getHost());
        System.out.println("IP Address: " + inetAddress.getHostAddress());
        System.out.println("Host Name: " + inetAddress.getHostName());
    }
}
