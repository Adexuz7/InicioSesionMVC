package dad.javafx.iniciosesion.mvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {
	
	private Label userLabel, passLabel;
	private TextField userText;
	private PasswordField passText;
	private Button accederButton, cancelarButton;
	
	public View() {
		
		super();
		
		userLabel = new Label("Usuario");
		userLabel.setMinWidth(80);
		
		passLabel = new Label("Contraseña");
		passLabel.setMinWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Usuario");
		userText.setFocusTraversable(false);
		userText.setMaxWidth(175);
		
		passText = new PasswordField();
		passText.setPromptText("Contraseña");
		passText.setFocusTraversable(false);
		passText.setMaxWidth(175);
		
		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		
		cancelarButton = new Button("Cancelar");
		cancelarButton.setDefaultButton(false);
		
		HBox userBox = new HBox(5, userLabel, userText);
		userBox.setAlignment(Pos.CENTER);
		
		HBox passBox = new HBox(5, passLabel, passText);
		passBox.setAlignment(Pos.CENTER);
		
		HBox authBox = new HBox(5, accederButton, cancelarButton);
		authBox.setAlignment(Pos.CENTER);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(userBox, passBox, authBox);
		
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPassText() {
		return passText;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}
	
}
