package panes;

import java.util.ArrayList;
import application.FileOperations;
import application.Room;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrationPane extends Pane{

	private int totalService=0;
	private int totalCost=0;
	
	private final int ser1price = 20;
	private final int ser2price = 35;
	private final int ser3price = 40;
	private final int ser4price = 30;
	private final int ser5price = 15;
	private final int ser6price = 45;
	private  int howManyDay;
	private int numOfCustomer = 1;
	
	
	public RegistrationPane( ArrayList<Room> rooms,Stage window,Scene scene2) {
		
		Label textHeader2 = new Label("Services");
		textHeader2.getStyleClass().add("header-text");
		
		Label service1 = new Label("BreakFast :(20$) ");
		Label service2 = new Label("Baby Sitting :(35$) ");
		Label service3 = new Label("Spa :(40$) ");
		Label service4 = new Label("Restaurant:(30$)");
		Label service5 = new Label("Parking :(15$) ");
		Label service6 = new Label("Flowers in Room :(45$)");
		Label dayLabel = new Label ("Day :");
		TextField dayField = new TextField();
		
		Label serviceP = new Label("Service's Cost :   ");
		Label roomP = new Label("Room Cost :");
		Label TotalP = new Label("Total Cost :");
		
		Label servicePm = new Label();
		Label roomPm = new Label();
		Label TotalPm = new Label();
		
		Label errorlblBuy = new Label(); 
		errorlblBuy.getStyleClass().add("label-warning");
		
		servicePm.getStyleClass().add("label-cost");
		roomPm.getStyleClass().add("label-cost");
		TotalPm.getStyleClass().add("label-cost");
		
		Button calculate = new Button("Calcute");
		Button buy = new Button("Buy");
		
		CheckBox check1 = new CheckBox();
		CheckBox check2 = new CheckBox();
		CheckBox check3 = new CheckBox();
		CheckBox check4 = new CheckBox();
		CheckBox check5 = new CheckBox();
		CheckBox check6 = new CheckBox();
		
		
		dayField.setMaxWidth(30);
		dayField.setText("1");
		
       calculate.setOnAction( e ->{
    	   totalService=0;
    	   if (check1.isSelected() == true) {
    		   
    	   totalService+=ser1price*numOfCustomer;}
    	   if (check2.isSelected() == true) {
    		   
    	   totalService+=ser2price;}
    	   if (check3.isSelected() == true) {
    		 
    	   totalService+=(ser3price*numOfCustomer);}
    	   if (check4.isSelected() == true) {
    		  
    	   totalService+=(ser4price*numOfCustomer);}
    	   if (check5.isSelected() == true) {
    		   
    	   totalService+=(ser5price);}
    	   if (check6.isSelected() == true) {
    		  
    	   totalService+=(ser6price);;
    	   }
    	   howManyDay= Integer.parseInt(dayField.getText());
    	   
    	   
    	   totalCost=totalService + HotelPane.pickedRoom.roomPrice;
    	   totalCost*=howManyDay;
    	   servicePm.setText(Integer.toString(totalService));
    	   roomPm.setText(Integer.toString(HotelPane.pickedRoom.roomPrice));
    	   TotalPm.setText(Integer.toString(totalCost));
    	   
       });
      
       buy.setOnAction(e -> {
    	   
    	   
    	   int SelectedRoomint=HotelPane.pickedRoom.getRoomNumber();
    	   
    	   
    	   if(SelectedRoomint !=0) {
    		   
    		   String SelectedRoom = String.valueOf(SelectedRoomint);
        	   
        	   HotelPane.pickedRoom.soldRoom=true;
        	   FileOperations.writeRoom(SelectedRoom);
        	   FileOperations.readandwriteFile();
        	   FileOperations.deleteTemp();
        	 
        	   dayField.setText("1");
        	   
        	   window.setScene(scene2);
    	   }
    	   else
    		   errorlblBuy.setText("You Should Pick a Room!");
    	   
    	   
       });
       
        GridPane pane5= new GridPane();
        GridPane pane6= new GridPane();
        GridPane pane7= new GridPane();
		pane5.add(service1, 0, 1);
		pane5.add(service2, 0, 2);
		pane5.add(service3, 0, 3);
		pane5.add(service4, 0, 4);
		pane5.add(service5, 0, 5);
		pane5.add(service6, 0, 6);
		pane5.add(check1, 1, 1);
		pane5.add(check2, 1, 2);
		pane5.add(check3, 1, 3);
		pane5.add(check4, 1, 4);
		pane5.add(check5, 1, 5);
		pane5.add(check6, 1, 6);
		pane6.add(dayLabel,0, 0);
		pane6.add(dayField,1, 0);
		
		pane7.add(serviceP, 0, 0);
		pane7.add(roomP, 0, 1);
	    pane7.add(TotalP, 0, 2);
		pane7.add(servicePm, 1, 0);
		pane7.add(roomPm, 1, 1);
		pane7.add(TotalPm, 1, 2);
		
		pane5.setHgap(8);
		pane5.setVgap(8);
		
		pane7.getStyleClass().add("text-border");
		pane7.setPadding(new Insets(5,56,5,5));
		
		pane5.getStyleClass().add("text-border");
		pane5.setPadding(new Insets(5,10,10,10));
		
		textHeader2.setLayoutX(90);
		textHeader2.setLayoutY(70);
		
		pane5.setLayoutX(10);
		pane5.setLayoutY(95);
		
		pane6.setLayoutX(90);
		pane6.setLayoutY(330);
		
		calculate.setLayoutX(90);
		calculate.setLayoutY(370);
		
		pane7.setLayoutX(10);
		pane7.setLayoutY(410);
		
		buy.setLayoutX(102);
		buy.setLayoutY(520);
		
		errorlblBuy.setLayoutX(15);
		errorlblBuy.setLayoutY(550);
		
		Pane mainPane = new Pane();
		 mainPane.setPadding(new Insets(20,0,0,20));
		mainPane.getChildren().addAll(pane5,textHeader2,pane6,calculate,pane7,buy,errorlblBuy);
		
		super.getChildren().add(mainPane);
        
	}
}