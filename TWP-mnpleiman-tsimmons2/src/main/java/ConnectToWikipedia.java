import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ConnectToWikipedia{
        static InputStream connect(String title) throws UnknownHostException, IOException  {
                title = URLEncoder.encode(title, StandardCharsets.UTF_8.toString());
                URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                        +title+"&redirects=1&rvprop=timestamp|user&rvlimit=25");
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "Revision tracker/0.1 (mnpleiman@bsu.edu)");
                return connection.getInputStream();

        }
    }
