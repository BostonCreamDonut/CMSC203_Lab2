import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what bs or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five bs, a label, and a textfield
	//  declare two HBoxes
	Button b;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Label label;
	TextField textf;
	HBox hbox;
	HBox hbox2;
	VBox vbox;
	Insets inset;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the bs, label, and textfield
		//  instantiate the HBoxes
		b = new Button("Hello");
		b2 = new Button("Howdy");
		b3 = new Button("Chinese");
		b4 = new Button("Clear");
		b5 = new Button("Exit");
		label = new Label("Feedback");
		textf = new TextField();
		hbox = new HBox();
		hbox2 = new HBox();
		vbox = new VBox();	
		//student Task #4:
		//  instantiate the DataManager instance
		data= new DataManager();
		b.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());
		//  set margins and set alignment of the components
		Insets inset = new Insets(5);
		HBox.setMargin(b, inset);
		HBox.setMargin(b2, inset);
		HBox.setMargin(b3, inset);
		HBox.setMargin(b4, inset);
		HBox.setMargin(b5, inset);
		hbox.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		this.getChildren().addAll(label, textf);
		//  add the buttons to the other HBox
		this.getChildren().addAll(b, b2, b3, b4, b5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hbox,hbox2);
	}
	
	//Task #4:
	//  create a private inner class to handle the b clicks
	private class ButtonHandler implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getTarget()==b)
			{
				textf.setText(data.getHello());
			}
			else if(event.getTarget()==b2)
			{
				textf.setText(data.getHowdy());
			}
			else if(event.getTarget()==b3)
			{
				textf.setText(data.getChinese());
			}
			else if(event.getTarget()==b5)
			{
				textf.setText("");
			}
			else if(event.getTarget()==b5)
			{
				 Platform.exit();
				 System.exit(0);
			}
		}
		
	}
}
