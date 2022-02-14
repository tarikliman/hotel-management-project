package panes;
import application.FileOperations;
import application.Room;
import javafx.scene.control.*;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.*;
public class HotelPane extends Pane {

	private final double roomX = 56; 
	private final double roomY = 25;
	
	Text roominfo;
	public static Room pickedRoom;
	
	public HotelPane(int a, ArrayList<Room> rooms,Stage window,Scene scene2) {
	
		pickedRoom = new Room();
		
		ImageView img = new ImageView(new Image("hotelpicture.png"));
		ImageView selectedRoom = new ImageView(new Image("selectedRoom.png"));
		
		img.setFitHeight(520);
		img.setFitWidth(550);
		selectedRoom.setFitHeight(26.5);
		selectedRoom.setFitWidth(53);
		selectedRoom.setVisible(isDisabled());
		
		Label warning = new Label("You Should Press Refresh For See Full Rooms.");
		warning.setLayoutX(45);
		warning.setLayoutY(570);
		warning.getStyleClass().add("header-text");
		
		Label textheader = new Label("Room Information");
		textheader.getStyleClass().add("header-text");
		textheader.setLayoutX(570);
		textheader.setLayoutY(68);
		textheader.setVisible(isDisabled());
		
		Button refresh = new Button("Refresh");
		refresh.setLayoutX(230);
		refresh.setLayoutY(525);
		
		Label backLabel = new Label("Back");
		backLabel.setOnMouseClicked(e -> { window.setScene(scene2);  });
		backLabel.setOnMouseEntered(e -> { backLabel.setTextFill(Color.DARKRED);});
		backLabel.setOnMouseExited(e -> { backLabel.setTextFill(Color.BLACK);});
		
		backLabel.setLayoutX(610);
		backLabel.setLayoutY(470);
		
		roominfo = new Text();
		roominfo.setId("text-area");
		roominfo.setX(20);
		roominfo.setY(38);
	
		Pane textPane = new Pane();
		textPane.getChildren().add(roominfo);
		textPane.getStyleClass().add("text-border");
		textPane.setLayoutX(550);
		textPane.setLayoutY(95);
		textPane.setVisible(isDisabled());
		textPane.setPadding(new Insets(0,15,36,0));
		
		if(a==1) {
			backLabel.setVisible(isDisabled());
		}
		getChildren().addAll(img,selectedRoom,textPane,backLabel,refresh,textheader,warning);
		
		refresh.setOnAction(e ->{
			
			try{
				 String[] data = FileOperations.readArrayTest();
				 int numOfCustomer =FileOperations.NumberOfCustomer();
			       
			    	       for(int z= 3; z<(numOfCustomer*4); z+=4) {
			    	    	   
			    	    	  int numOfRoom;
			    	    	  
			    	    	  numOfRoom = Integer.parseInt(data[z]);
			    	    	  for(int i=0;i<48;i++) {
			    	    		  if( numOfRoom== rooms.get(i).getRoomNumber()) {
				    	    		   rooms.get(i).soldRoom = true;
				    	    	   } 
			    	    	  }
			    	       }
				for(int k = 0; k<48 ; k++) {
					if(rooms.get(k).soldRoom == true)
					    getChildren().add(rooms.get(k).fullRoomO);
					
				}}catch(Exception Z) {
			}
		});
		
		img.setOnMouseClicked( e -> 
		{
			try{
				textheader.setVisible(isVisible());
				textPane.setVisible(isVisible());
				selectedRoom.setVisible(isVisible());
				
				for(int i=47; i>=0; i--) {
					if(e.getY()>rooms.get(i).windowY && e.getY()<rooms.get(i).windowY + roomY) {
						if(e.getX()> rooms.get(i).windowX && e.getX()< rooms.get(i).windowX +roomX) {
							selectedRoom.relocate(rooms.get(i).windowX, rooms.get(i).windowY);
							pickedRoom=rooms.get(i);
						
						}
					}
				}	
				
				roominfo.setText( "Room number :"+pickedRoom.getRoomNumber() +"\nMetersquare : " + pickedRoom.getMeterSquare()  +
						"\nSingle Bed: " +pickedRoom.getSingleBed()  + "\nDouble Bed: "+ pickedRoom.getDoubleBed()  );
				
				
			}catch(Exception T) {
			}
		});
	}
}