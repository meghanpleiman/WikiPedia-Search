import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class RevisionParser {
    String redirectedTitle = "";

    public void Revisions(String inputLine){
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(inputStream);

        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array;
        for (Map.Entry<String, JsonElement> entry: pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
            System.out.printf("Page ID: %s%n", entry.getKey());
            System.out.printf("NS: %s%n", entry.getValue().getAsJsonObject().getAsJsonPrimitive("ns"));
            System.out.printf("Title: %s%n", entry.getValue().getAsJsonObject().getAsJsonPrimitive("title"));
            for (int i = 0; i <array.size(); i++){
                System.out.printf("User: %s%n", array.get(i).getAsJsonObject().getAsJsonPrimitive("user"));
                System.out.printf("Time Stamp: %s%n", array.get(i).getAsJsonObject().getAsJsonPrimitive("timestamp"));
            }
        }
    }
    private void redirectedTitle(JsonArray redirect){
        if (redirect != null) {
            redirectedTitle = redirect.get(0).getAsJsonObject().get("to").getAsString();
        }
    }

}
