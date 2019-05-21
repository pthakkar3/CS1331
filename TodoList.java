import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.binding.Bindings;

public class TodoList extends Application {

    private ObservableList<String> list;
    private ListView<String> listView;
    private Button addButton;
    private Button finishButton;
    private TextField input;

    @Override
    public void start(Stage stage) {

        input = new TextField();

        list = FXCollections.observableArrayList();

        listView = new ListView<String>(list);

        addButton = new Button();
        addButton.setText("Add");
        addButton.setOnAction(e -> {
            list.add(input.getText());
            input.setText("");
        });

        addButton.disableProperty().bind(Bindings.isEmpty(input.textProperty()));

        finishButton = new Button();
        finishButton.setText("Finish");
        finishButton.setOnAction(e -> {
            int index = listView.getFocusModel().getFocusedIndex();
            if (index >= 0) {
                list.remove(index);
            }
        });

        //finishButton.disableProperty().bind(Bindings.notEqual(listView.getFocusModel().getFocusedIndex()));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(input, addButton, finishButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(listView, hbox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Todo List");
        stage.show();
    }
}
