import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Editor {
    public static void main(String[] args) throws IOException{
        Editor editor = new Editor();
        editor.connectToWikipedia();
        //editor.getEditorName(URL Connection connection);
    }
    private URLConnection connectToWikipedia() throws IOException{
        URL url = new URL(
                "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=barack%20obama&redirects=");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revisions/0.1 (@bsu.edu)");
        connection.connect();
        return connection;
    }
    private void getEditorName(URLConnection connection) throws IOException{
        InputStream in = connection.getInputStream();
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(in);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = new JsonArray();
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
            for (int i = 0; i < array.size(); i++){
                System.out.printf("User: %s%n", array.get(i).getAsJsonObject().getAsJsonPrimitive("user"));
            }
        }

    }
}
