package application;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import panes.ColorPane;
import panes.HotelPane;
import panes.RegistrationPane;
import panes.TitlePane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;
public class Main extends Application  {
	
	Stage window;
	Scene scene1,scene2,scene3,scene4,scene5,hotelinfoscene,listscene,deletescene;
	
	private final double roomdisX = 17.75; 
	private final double roomdisY = 17.05;
	private final double roomX = 56; 
	private final double roomY = 25;
	private final double firstX = 60;
	private final double firstY = 127;
	private final double distanceX=roomX+roomdisX;
	private final double distanceY=roomY+roomdisY;
	
    public static void main(String[] args) {
        launch(args);
    }
   
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX App");
        
        window = primaryStage;

        ArrayList<Room> rooms = new ArrayList<Room>();
        
        rooms.add(new Room(1,40,1,0,100));
        rooms.add(new Room(2,40,1,0,100));
        rooms.add(new Room(3,40,1,0,100));
        rooms.add(new Room(4,40,1,0,100));
        rooms.add(new Room(5,40,1,0,100));
        rooms.add(new Room(6,40,1,0,100));
        
        rooms.add(new Room(7,55,1,0,120));
        rooms.add(new Room(8,55,1,0,120));
        rooms.add(new Room(9,55,1,0,120));
        rooms.add(new Room(10,55,1,0,120));
        rooms.add(new Room(11,55,1,0,120));
        rooms.add(new Room(12,55,1,0,120));
        
        rooms.add(new Room(13,50,0,1,125));
        rooms.add(new Room(14,50,0,1,125));
        rooms.add(new Room(15,50,0,1,125));
        rooms.add(new Room(16,50,0,1,125));
        rooms.add(new Room(17,50,0,1,125));
        rooms.add(new Room(18,50,0,1,125));
        
        rooms.add(new Room(19,70,0,1,140));
        rooms.add(new Room(20,70,0,1,140));
        rooms.add(new Room(21,70,0,1,140));
        rooms.add(new Room(22,70,0,1,140));
        rooms.add(new Room(23,70,0,1,140));
        rooms.add(new Room(24,70,0,1,140));
       
        rooms.add(new Room(25,60,1,1,130));
        rooms.add(new Room(26,60,1,1,130));
        rooms.add(new Room(27,60,1,1,130));
        rooms.add(new Room(28,60,1,1,130));
        rooms.add(new Room(29,60,1,1,130));
        rooms.add(new Room(30,60,1,1,130));
        
        rooms.add(new Room(31,60,1,1,135));
        rooms.add(new Room(32,60,1,1,135));
        rooms.add(new Room(33,60,1,1,135));
        rooms.add(new Room(34,60,1,1,135));
        rooms.add(new Room(35,60,1,1,135));
        rooms.add(new Room(36,60,1,1,135));
        
        rooms.add(new Room(37,80,2,1,150));
        rooms.add(new Room(38,80,2,1,150));
        rooms.add(new Room(39,80,2,1,150));
        rooms.add(new Room(40,80,2,1,150));
        rooms.add(new Room(41,80,2,1,150));
        rooms.add(new Room(42,80,2,1,150));
        
        rooms.add(new Room(43,100,0,1,250));
        rooms.add(new Room(44,120,0,1,300));
        rooms.add(new Room(45,120,0,1,300));
        rooms.add(new Room(46,120,0,1,300));
        rooms.add(new Room(47,100,0,1,250));
        rooms.add(new Room(48,100,0,1,250));
        int incX=0;
 	    int incY=0;
 	   
       for(int s = 47 ; s>=0 ; s--) {
    	   
    	   rooms.get(s).setXandY(firstX+incX*distanceX, firstY+incY*distanceY);
    	   incX++;
    	   
    	   if(s % 6  == 0) {
    		   incX=0;
    		   incY++;
    	   }
       }
       for(int k = 0; k<48 ; k++) {
		   rooms.get(k).fullRoomO.setX(rooms.get(k).getWindowX());
  			rooms.get(k).fullRoomO.setY(rooms.get(k).getWindowY());
  			rooms.get(k).fullRoomO.setFitHeight(26.5);
  			rooms.get(k).fullRoomO.setFitWidth(53);
  			
		}
      
       
       
       
      //FIRST SCENE
        Label label = new Label("Username : ");
        Label label2 = new Label("Password : ");
        Label errorlabel1 = new Label();
        errorlabel1.getStyleClass().add("label-warning");
        Label errorlabel2 = new Label();
        errorlabel2.getStyleClass().add("label-warning");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();
        Button enter;
        enter = new Button("enter");
        
      //Login Event
        enter.setOnAction(new EventHandler<ActionEvent>() {
           	
           	public void handle(ActionEvent e) {
           		try {
           			String openname=tf1.getText();
               		int password = Integer.parseInt(tf2.getText());
           			
               		if(openname.equals("gohotel")==true && password==12345 ) {
               			window.setScene(scene2);
               			tf1.clear();
               			tf2.clear();
               			errorlabel1.setText("");
               			errorlabel2.setText("");
               			FileOperations.fileCreate();
               		}
               		else 
               			errorlabel1.setText("Invalid Password");
           		}catch(Exception T){
           			errorlabel2.setText("Invalid Password");
           		}
           	}
        });
        
        GridPane pane = new GridPane();
        
        pane.add(label, 1, 1 );
        pane.add(label2,1 ,2 );
        pane.add(tf1, 2,1);
        pane.add(tf2, 2,2);
        pane.add(enter, 2, 3);
        pane.add(errorlabel1, 2,4 );
        pane.add(errorlabel2, 2,4 );
        
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);
       
        BorderPane borderPane = new BorderPane();
        
        TitlePane titlePane = new TitlePane(1);
        titlePane.setStyle("-fx-background-color :#e74c3c");
        
        borderPane.setLeft(new ColorPane());
        borderPane.setRight(new ColorPane());
        borderPane.setTop(titlePane);
        borderPane.setCenter(pane);
        
        scene1 = new Scene(borderPane,1280,720);
        scene1.getStylesheets().add(getClass().getResource("esthetic.css").toExternalForm());
        
      //SCENE 2       
        Label option1 = new Label("New Registration");
        Label option2 = new Label("Hotel Document");
        Label option3 = new Label("Back to Admin Login");
        Label option4 = new Label("Exit");


        //go to scene3 event 
        option1.setOnMouseClicked(e -> { window.setScene(scene3);} );
        option1.setOnMouseEntered(e -> { option1.setTextFill(Color.DARKRED);});
        option1.setOnMouseExited(e -> {option1.setTextFill(Color.BLACK);});
        
        //go to scene4 event 
        option2.setOnMouseClicked(e -> { window.setScene(scene4);  });
        option2.setOnMouseEntered(e -> {option2.setTextFill(Color.DARKRED);});
        option2.setOnMouseExited(e -> {option2.setTextFill(Color.BLACK);});
        
      //Back to scene1 event
        option3.setOnMouseClicked(e -> { 
        	window.setScene(scene1);
        	
        });
        option3.setOnMouseEntered(e -> {option3.setTextFill(Color.DARKRED);});
        option3.setOnMouseExited(e -> {option3.setTextFill(Color.BLACK);});
       //close program event
        option4.setOnMouseClicked(e -> { window.close();} );
        option4.setOnMouseEntered(e -> {option4.setTextFill(Color.DARKRED);});
        option4.setOnMouseExited(e -> {option4.setTextFill(Color.BLACK);});
     
        GridPane pane2 = new GridPane();
        BorderPane borderPane2 = new BorderPane();
        
        pane2.add(option1, 0, 0);
        pane2.add(option2, 0, 1);
        pane2.add(option3, 0, 2);
        pane2.add(option4, 0, 3);
        
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(60);
        pane2.setVgap(60);
        
        TitlePane titlePane2 = new TitlePane(2);
        titlePane2.setStyle("-fx-background-color :#e74c3c");
        
        borderPane2.setTop(titlePane2);
        borderPane2.setCenter(pane2);
        borderPane2.setLeft(new ColorPane());
        borderPane2.setRight(new ColorPane());
        
        scene2 = new Scene(borderPane2,1280,720);
        scene2.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());
        
      //SCENE 3
        BorderPane borderPane3 = new BorderPane();
        GridPane pane3 = new GridPane();
        
        Label namelbl = new Label("Customer First Name : ");
        Label surnamelbl = new Label("Customer Last Name : ");
        Label idlbl =      new Label("Customer ID (11 digits) :");
        Label agelbl = new Label("Customer Age : ");
        Label backmenu1 = new Label("Back");
        Label errorlbl1 = new Label();
        Label errorlbl2 = new Label();
       
        
        errorlbl1.getStyleClass().add("label-warning");
        errorlbl2.getStyleClass().add("label-warning");
      
        
        backmenu1.setTextFill(Color.BLACK);
        backmenu1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,18));
        
        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        TextField iDField = new TextField();
        TextField ageField = new TextField();
        ageField.setMaxWidth(35);
        Button enter2;
        enter2 = new Button("Enter");
        enter2.setOnAction(new EventHandler<ActionEvent>() {
           	
        	public void handle(ActionEvent e) {
        		try {
           			String name=nameField.getText();
           			String surname= surnameField.getText();
               		String iD = iDField.getText();
               		int age2 = Integer.parseInt(ageField.getText());
               		int test;
               		long iDtest = Long.valueOf(iD);
               		long iDlong = Long.valueOf(iD);
               		boolean match = false;
               		boolean namehata = false;
               		boolean numeric = false;
               		
               		if(name.indexOf(" ")== -1 && surname.indexOf(" ")==-1 )
               		{
               			for(int r=0;r<name.length();r++) {
                   			for(int f=0;f<10;f++) {
                   				char kk=name.charAt(r);
                   				int a=Character.getNumericValue(kk);
                   				
                   				if (a==f) {
                   					numeric=true;}}}
                   		for(int r=0;r < surname.length();r++) {
                   			for(int f=0;f<10;f++) {
                   				char kk=surname.charAt(r);
                   				int a=Character.getNumericValue(kk);
                   				
                   				if (a==f) {
                   					numeric=true;}}}
                   		
                   		for (test=0;iDtest>0;test++) {
               				iDtest = iDtest/10;	}
                   		
                   			char iD0= iD.charAt(0);
                   			char c0='0';
                   		
                   		if(age2>17 && test==11 && c0!=iD0 && name.isEmpty()==false && numeric == false && name != null && !name.isEmpty()&& surname != null && !surname.isEmpty()) {
                   			FileOperations.fileCreate();
                   			String[] words = FileOperations.readArrayTest();
                   			
                   			
                   			for(int y=2; y<words.length; y=y+4) {
                   				long arraylong = Long.valueOf(words[y]);
                   				if(arraylong == iDlong) {
                   					
                   					match = true;
                   				 
                   					for (int g=0 ; g<words.length; g++) {
                   						if (words[g] == name || words[g] == surname) {
                   							namehata = true; 
                   						}
                   					}
                   				}
                   				
                   				else if(arraylong != iDlong) {
                   					
                   				}
                   			}
                   			if(match == false && namehata==false ) {
                   				
                   				FileOperations.writetemp(name, surname, iD);
                   				errorlbl1.setText("");
                   				errorlbl2.setText("");
                   				window.setScene(scene5);
                   				
                   			}
                   			else {
                   				errorlbl2.setText("It is already registered");
                   			}
                   		}
                   		else {
                   			
                   			if(iD0==c0) {
                   				errorlbl1.setText("ID cant start with 0");
                   			}
                   			else if(name.isEmpty()==true || surname.isEmpty()==true ) errorlbl1.setText("Name or Surname is Null");
                   			else if(numeric==true) errorlbl1.setText("numeric name or surname");
              
                   			else if(age2<18) errorlbl2.setText("Age must be at least 18"); 
                   				
                   				
                   			else errorlbl2.setText("ID must be 11 digits.");
                   				
                   			
                   		}
               		}
               		else
               			errorlbl2.setText("You can't use a space key");
               		nameField.clear();
               		surnameField.clear();
                	iDField.clear();
                	ageField.clear();
                	
           		}catch(Exception T){
           			errorlbl1.setText("Invalid Sign!!!");
           		}
           	}
        });
     //Back to main menu Event 
        backmenu1.setOnMouseClicked(e -> { 
        	window.setScene(scene2);

        	nameField.clear();
        	surnameField.clear();
        	iDField.clear();
        	ageField.clear();
        	
        });
        
        backmenu1.setOnMouseEntered(e -> {backmenu1.setTextFill(Color.DARKRED);});
        backmenu1.setOnMouseExited(e -> {backmenu1.setTextFill(Color.BLACK);});
        
        pane3.add(namelbl, 1, 1 );
        pane3.add(surnamelbl, 1, 2);
        pane3.add(idlbl,1 ,3 );
        pane3.add(agelbl, 1, 4);
        pane3.add(nameField, 2,1);
        pane3.add(surnameField, 2,2);
        pane3.add(iDField, 2,3);
        pane3.add(ageField, 2, 4);
        pane3.add(enter2, 3, 2,1,1);
        pane3.add(errorlbl1, 2,6 );
        pane3.add(errorlbl2, 2,5 );
        pane3.add(backmenu1, 2, 7);
       
        pane3.setAlignment(Pos.CENTER);
        pane3.setHgap(10);
        pane3.setVgap(10);
        TitlePane titlePane3 = new TitlePane(3);
        titlePane3.setStyle("-fx-background-color :#e74c3c");
        borderPane3.setTop(titlePane3);
        borderPane3.setCenter(pane3);
        borderPane3.setLeft(new ColorPane());
        borderPane3.setRight(new ColorPane());
        scene3 = new Scene(borderPane3,1280,720);
        scene3.getStylesheets().add(getClass().getResource("esthetic.css").toExternalForm());
        
        //SCENE 4 
        Label optionh1 = new Label("Hotel Informations");
        Label optionh2 = new Label("Customer List");
        Label optionh3 = new Label("Back ");
        
      //go to hotelscene event 
        optionh1.setOnMouseClicked(e -> { window.setScene(hotelinfoscene);} );
        optionh1.setOnMouseEntered(e -> { optionh1.setTextFill(Color.DARKRED);});
        optionh1.setOnMouseExited(e -> {optionh1.setTextFill(Color.BLACK);});
      // go to customer list event 
        
        ListView<String> list = new ListView<>();
        
        
        optionh2.setOnMouseClicked(e -> {
        	
        	list.getItems().clear();
        	int numOfCustomer = FileOperations.NumberOfCustomer();
            String[] data = FileOperations.readArrayTest();
            int d = 0;	
            while(d!=numOfCustomer*4) {
            	list.getItems().add("ID :" +data[d+2] + "  Room Number :"+ data[d+3]+ "  Name :"+data[d] +" "+data[d+1] );
                d+=4;	
            }
        	window.setScene(listscene);
        });
        
        optionh2.setOnMouseEntered(e -> {optionh2.setTextFill(Color.DARKRED);});
        optionh2.setOnMouseExited(e -> {optionh2.setTextFill(Color.BLACK);});
      //Back to scene1 event
        optionh3.setOnMouseClicked(e -> { window.setScene(scene1);  });
        optionh3.setOnMouseEntered(e -> {optionh3.setTextFill(Color.DARKRED);});
        optionh3.setOnMouseExited(e -> {optionh3.setTextFill(Color.BLACK);});
       
    
        BorderPane borderPane4 = new BorderPane();
        GridPane pane4 = new GridPane();
        pane4.add(optionh1, 0, 1);
        pane4.add(optionh2, 0, 0);
        pane4.add(optionh3, 0, 2);
       
        pane4.setAlignment(Pos.CENTER);
        pane4.setHgap(60);
        pane4.setVgap(60);
        
        TitlePane titlePane6 = new TitlePane(6);
        titlePane6.setStyle("-fx-background-color :#e74c3c");
        
        borderPane4.setLeft(new ColorPane());
        borderPane4.setRight(new ColorPane());
        borderPane4.setCenter(pane4);
        borderPane4.setTop(titlePane6);
        
        scene4 = new Scene(borderPane4,1280,720) ;
        scene4.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());
        
        //SCENE 5
        BorderPane borderPane5 = new BorderPane();
        BorderPane inBorderPane2 = new BorderPane();
        
        inBorderPane2.setRight(new RegistrationPane(rooms,window,scene2));
        inBorderPane2.setLeft(new HotelPane(1,rooms,window,scene2));
        
        TitlePane titlePane5 = new TitlePane(5);
        titlePane5.setStyle("-fx-background-color :#e74c3c");
        
        borderPane5.setLeft(new ColorPane());
        borderPane5.setRight(new ColorPane());
        borderPane5.setCenter(inBorderPane2);
        borderPane5.setTop(titlePane5);
        
        scene5 = new Scene(borderPane5,1270,720);
        scene5.getStylesheets().add(getClass().getResource("hotelStyle.css").toExternalForm());
        
        //HOTEL info SCENE
        
        TitlePane titlePane7 = new TitlePane(5);
        titlePane7.setStyle("-fx-background-color :#e74c3c");
        
        BorderPane borderPaneH = new BorderPane();
        borderPaneH.setLeft(new ColorPane());
        borderPaneH.setRight(new ColorPane());
        borderPaneH.setCenter(new HotelPane(2,rooms,window,scene2));
        borderPaneH.setTop(titlePane7);
        
        hotelinfoscene = new Scene(borderPaneH,1280,720) ;
        hotelinfoscene.getStylesheets().add(getClass().getResource("esthetic.css").toExternalForm());
        
        //CUSTOMER LIST SCENE
    
           
        Label deleteLab= new Label("ID :");
        TextField deleteField = new TextField();
        Button deleteBtn = new Button("Delete");
        
        Label backLabel2 = new Label("Back");
		backLabel2.setOnMouseClicked(e -> { window.setScene(scene2);  });
		backLabel2.setOnMouseEntered(e -> { backLabel2.setTextFill(Color.DARKRED);});
		backLabel2.setOnMouseExited(e -> { backLabel2.setTextFill(Color.BLACK);});
		
		backLabel2.setLayoutX(610);
		backLabel2.setLayoutY(470);
		
		 deleteBtn.setOnAction(e -> {
	        	
	        	String iDdelete=deleteField.getText();
	           FileOperations.deleteCus(iDdelete);
	            window.setScene(scene2);
	        	deleteField.clear();
	        });
	        ;
        deleteLab.setLayoutX(670);
        deleteLab.setLayoutY(230);
        
        deleteField.setLayoutX(715);
        deleteField.setLayoutY(232);
        
        deleteBtn.setLayoutX(760);
        deleteBtn.setLayoutY(280);
        
        list.setPrefSize(500, 600);
        
        Pane paneList = new Pane();
        paneList.getChildren().addAll(list,deleteLab,deleteField,deleteBtn,backLabel2);
        
        TitlePane titlePane8 = new TitlePane(7);
        titlePane8.setStyle("-fx-background-color :#e74c3c");
        
        BorderPane borderPaneC = new BorderPane();
        borderPaneC.setLeft(new ColorPane());
        borderPaneC.setRight(new ColorPane());
        borderPaneC.setTop(titlePane8);
        borderPaneC.setCenter(paneList);
        
        listscene = new Scene(borderPaneC,1280,720) ;
        listscene.getStylesheets().add(getClass().getResource("esthetic.css").toExternalForm());
       
      //STAGE 
        window.setResizable(false);
        window.setTitle("hotel management system");
        window.setScene(scene1);        
        window.show();
    }
}