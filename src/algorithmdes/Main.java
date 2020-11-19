package algorithmdes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.event.EventHandler;


public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label();
        Label passwordLabel = new Label("Введите пароль-ключ");
        Label textLabel = new Label("Введите текст для шифрования");
        Label resultLabel = new Label("Зашифрованный текст:");
        Label passwordRules = new Label ("0-9, a-z, A-Z, @#$%^&+=, не должно быть пробелов, пароль больше 8 символов  ");

        Controller desAlgorithm = new Controller();
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(45);
        textArea.setPrefRowCount(5);
        TextArea passwordArea = new TextArea();
        passwordArea.setPrefColumnCount(15);
        passwordArea.setPrefRowCount(1);
        Button btn = new Button("Зашифровать");


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String encryptedText;
                String userPassword = passwordArea.getText();
                if (desAlgorithm.checkPassword(userPassword) == true) {
                    encryptedText = desAlgorithm.encryptLaunch(textArea.getText(), userPassword);
                    lbl.setText(encryptedText);
                } else lbl.setText("Введите сложный пароль!");

            }
        });

        ScrollPane scrollPane = new ScrollPane(lbl);
        scrollPane.setPrefViewportHeight(150);
        scrollPane.setPrefViewportWidth(200);
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, passwordLabel,passwordRules,
                passwordArea, textLabel, textArea, btn, resultLabel, scrollPane);

        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 550, 600);

        stage.setScene(scene);
        stage.setTitle("DES Шифровальщик");
        stage.show();
    }
}
