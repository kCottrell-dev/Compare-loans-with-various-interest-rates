import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ContentDisplay;

public class LoanInterest extends Application {
	protected TextField LoanAmount = new TextField();
	protected TextField NumberOfYears = new TextField();
	protected TextArea textArea = new TextArea();
        

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		NumberOfYears.setPrefColumnCount(2);
		LoanAmount.setPrefColumnCount(7);
		textArea.setPrefColumnCount(30);
                

		EventHandler<ActionEvent> handler = event -> print();
        NumberOfYears.setOnAction(handler);
        LoanAmount.setOnAction(handler);

        HBox topPane = new HBox();
        topPane.setSpacing(10);
        topPane.setPadding(new Insets(5));
        Label lblLoanAmount = new Label("Loan Amount:", LoanAmount);
        lblLoanAmount.setContentDisplay(ContentDisplay.RIGHT);

        Label lblNumOfYears = new Label("Number Of Years:", NumberOfYears);
        lblNumOfYears.setContentDisplay(ContentDisplay.RIGHT);

        Button btShowTable = new Button("Show Table");
        btShowTable.setOnAction(handler);
        topPane.getChildren().addAll(lblLoanAmount, lblNumOfYears, btShowTable);


        BorderPane borderPane = new BorderPane(textArea);
        borderPane.setTop(topPane);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Loan Interest");
        primaryStage.show();
	}
        
               
         public static void main(String[] args) {
        Application.launch(args);
    }
         

	private void print() {
		// Create a output string
		String output = "";
		double monthlyInterestRate; // Monthly interest rate
		double monthlyPayment;	// Monthly payment
		
		// Add table header
		output += "Interest Rate       Monthly Payment          Total Payment\n";
		
		// Calculate and add table with interest rates to output
		for (double i = 5.0; i <= 8; i += 0.125) {
			monthlyInterestRate = i / 1200;
			monthlyPayment = Double.parseDouble(LoanAmount.getText()) * 
				monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,
				Double.parseDouble(NumberOfYears.getText()) * 12));

			output += String.format("%-24.3f%-34.2f%-8.2f\n", i, 
				monthlyPayment, (monthlyPayment * 12) * 
				Double.parseDouble(NumberOfYears.getText()));
		}

		textArea.setText(output);
	}
        
}


   
  
