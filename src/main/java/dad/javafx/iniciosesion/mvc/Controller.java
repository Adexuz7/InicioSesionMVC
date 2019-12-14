package dad.javafx.iniciosesion.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	private Model model = new Model();
	private View root = new View();
	
	public Controller() {		
		
		model.userProperty().bind(root.getUserText().textProperty());
		model.passProperty().bind(root.getPassText().textProperty());
		
		root.getAccederButton().setOnAction(e -> onAccederAction(e));
		root.getCancelarButton().setOnAction(e -> onCancelarAction(e));
		
	}
		
	private void onCancelarAction(ActionEvent e) {
		Platform.exit();
	}

	private void onAccederAction(ActionEvent e) {

		if (checkPass()) {
			alert(AlertType.INFORMATION, "Acceso permitido", "Las credenciales de acceso son válidas");
		} else {
			alert(AlertType.ERROR, "Acceso denegado", "El usuario y/o la contraseña no son válidos");
		}
		
	}

	public View getRoot() {
		return root;
		
	}
	
	
	private boolean checkPass() {
		
		boolean accesoPermitido = false;
		
		String csvUser, csvPass, row;
		
		String inputUser = model.getUser();
		String inputPass = DigestUtils.md5Hex(model.getPass()).toUpperCase();
		
		BufferedReader csvReader;
		
		try {
			csvReader = new BufferedReader(new FileReader("users.csv"));
			
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    
			    csvUser = data[0];
			    csvPass = data[1];
			    
			    if (inputUser.equals(csvUser) && inputPass.equals(csvPass)) {
					accesoPermitido = true;
				} 
			}
			csvReader.close();
			
		} catch (FileNotFoundException e) {
			alert(AlertType.ERROR, "Archivo no encontrado", "Falta el archivo CSV");
		} catch (IOException e) {
			alert(AlertType.ERROR, "IOException", "IOException");
		}
	
		return accesoPermitido;
	    
	}
			
	private void alert(AlertType alertType, String headerText,String contentText) {
		Alert alert = new Alert(alertType);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
		
		Platform.exit();
	}	
	
}
