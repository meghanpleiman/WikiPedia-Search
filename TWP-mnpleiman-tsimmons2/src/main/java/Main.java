import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        URLConnectionReader CReader = new URLConnectionReader();
        CReader.connectToWikipedia();
        CReader.searchWiki();
        RevisionParser parser = new RevisionParser();
        parser.Revisions("sample.json");


    }
}

