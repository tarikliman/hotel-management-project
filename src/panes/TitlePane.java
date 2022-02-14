package panes;

import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
public class TitlePane extends VBox {

	public TitlePane(int a) {
		Label t1 = new Label("Hotel Management System");
		t1.setId("main-title");

		super.setAlignment(Pos.CENTER);
		getChildren().add(t1);
		
		if(a==1) {
			Label title3 = new Label("Login As Administrator");
			title3.getStyleClass().add("sub-title");
			getChildren().add(title3);
		}
		if(a==2) {
			Label title2 = new Label("Main Menu");
			title2.getStyleClass().add("sub-title");
			getChildren().add(title2);
		}
		if(a==3) {
			Label title3 = new Label("Customer");
			title3.getStyleClass().add("sub-title");
			getChildren().add(title3);
		}
		if(a==4) {
			Label title4 = new Label("New Registration");
			title4.getStyleClass().add("sub-title");
			getChildren().add(title4);
		}
		if(a==5) {
			Label title5 = new Label("Hotel");
			title5.getStyleClass().add("sub-title");
			getChildren().add(title5);
		}
		if(a==6) {
			Label title5 = new Label("Hotel Document");
			title5.getStyleClass().add("sub-title");
			getChildren().add(title5);
		}
		if(a==7) {
			Label title5 = new Label("Customer List");
			title5.getStyleClass().add("sub-title");
			getChildren().add(title5);
		}
		
	}
}
