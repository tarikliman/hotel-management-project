package panes;

import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;

public class ColorPane extends StackPane {

	public ColorPane() {
		setStyle("-fx-background-color : #596275");
		setPadding(new Insets (100,100,10,10));
	}
}
