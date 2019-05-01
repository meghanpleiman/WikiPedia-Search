import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class UserInterface extends Application{
    private String title = " ";
    private TableView<RevisionParser> tableView = new TableView<>();
    private TableColumn<RevisionParser, String> username = new TableColumn<>("User");
    private TableColumn<RevisionParser, Integer> numberOfRevisions = new TableColumn<>("Number of Revisions");
    private TableColumn<RevisionParser, String> timestamp = new TableColumn<>("Timestamp");
    private VBox background = new VBox();
    private Label wrongLabel = new Label("");
    private Label redirected = new Label();
    private Label label = new Label("What would you like to search Wikipedia for?");
    private HBox wikiTitleArea = new HBox(label);

    @Override
    public void start(Stage primaryStage) {
        VBox background = makeDesign();
        primaryStage.setScene(new Scene(background, 650, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private VBox makeDesign() {
        TableView<RevisionParser> tableView = addtoTableView();
        HBox wikiTitle = addWikiTitle();
        wrongLabel.setTextFill(Color.AQUAMARINE);
        label.setTextFill(Color.CADETBLUE);
        background.getChildren().addAll(wikiTitle, tableView, wrongLabel);
        return background;
    }

    private TableView<RevisionParser> addtoTableView(){
        username.setMinWidth(225);
        username.setMaxWidth(225);
        timestamp.setMinWidth(200);
        timestamp.setMaxWidth(200);
        numberOfRevisions.setMinWidth(225);
        numberOfRevisions.setMaxWidth(225);
        tableView.getColumns().addAll(username, timestamp, numberOfRevisions);
        return tableView;
    }

    private HBox addWikiTitle(){
        label.setFont(new Font("Calibri", 14));
        wikiTitleArea.setSpacing(10);
        wikiTitleArea.setPadding(new Insets(15, 15, 15, 15));
        wikiTitleArea.setStyle("-fx-background-color: rgba(0, 355, 355, 0.05)");
        TextField textField = new TextField();
        Button searchButton = new Button("Search");
        Button clearButton = new Button("Clear");
        setButton(clearButton, searchButton, textField);
        wikiTitleArea.getChildren().addAll(textField, searchButton, clearButton);
        return wikiTitleArea;
    }

    private void setButton(Button clearButton, Button searchButton, TextField textField) {
        searchButton.setOnAction((javafx.event.ActionEvent event) -> {
            title = textField.getText();
        });
        clearButton.setOnAction(event -> {
            textField.clear();
            wrongLabel.setText("");});
    }

}
