import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class URLConnectionReader {

    private Boolean connectionSuccessful;

    public String searchWiki(){
        String inputLine = null;
        if (connectionSuccessful){
            Scanner console = new Scanner(System.in);
            System.out.println("What would you like to search Wikipedia for?");
            String search = console.nextLine();
            String searchWithNoSpaces = search.replace(" ", "-");
            try {
                URL testing = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + searchWithNoSpaces + "&rvprop=timestamp|user&rvlimit=25&redirects");
                URLConnection yc = testing.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                inputLine = in.readLine();
            }
            catch(Exception e){
                System.out.println("That is not a page on Wikipedia.");
            }
        }
        else {
            System.out.println("You are unable to search Wikipedia at this time.");
        }
        System.out.println(inputLine);
        return inputLine;
    }
    public URLConnection connectToWikipedia() throws IOException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=barack%20obama&redirects=");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revisions/0.1 (mnpleiman@bsu.edu");
        try{
            connection.connect();
            connectionSuccessful = true;
        }
        catch (UnknownHostException e){
            System.out.println("You are unable to connect to Wikipedia at this time. Check your connection and try again.");
            connectionSuccessful = false;
        }
        return connection;
    }
}
