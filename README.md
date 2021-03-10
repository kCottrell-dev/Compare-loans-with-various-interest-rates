# Compare loans with various interest rates

The Programming exercise is asking me to rewrite programming exercise 5.21 and create a GUI that has an example picture
to show how exactly I need to program it to look like. The program needs to allow you need enter the loan amount and loan period
in number of years from a text field, and it should display monthly and total payments for each interest rate starting from 5 percent to 8 percent, with increments of one-eighth in the text area. Basically, the assignment wants me to program a GUI that calculates loans with interest rates from exercise 5.21

## Example Output

![image](https://user-images.githubusercontent.com/73491964/110555036-81f1f400-8101-11eb-8bc4-0604b0ccadd7.png)

## Analysis Steps

This section should restate the assignment and explain how you analyzed the requirements in order 
to develop a solution.
Well, I analyzed the requirements by simply reading the text in the pearson and looking at the images provided in the pearson
to get a good look on how the program should be layed out and what it needs to be doing. All the information needed to recognize a solution
is available in the pearson text. Which is basically create a GUI out programming exercise 5.21 and let the user
calculate loan interest rates.

### Design

Yes I used multiple classes to approach my design I used various JavaFX classes in order to build my GUI, and I just borrowed
the loan interest code from the exercise 5.21 so that it would display the values in the GUI, by registering it to the program
like so.

```
btShowTable.setOnAction(e -> {
			print();
		});
    
    private void print() {
		// Create a output string
		String output = "";
		double monthlyInterestRate; // Monthly interest rate
		double monthlyPayment;	// Monthly payment
		
		// Header
		output += "Interest Rate       Monthly Payment          Total Payment\n";
		
		// Calculate and add table with interest rates to output
		for (double i = 5.0; i <= 8; i += 0.125) {
			monthlyInterestRate = i / 1200;
			monthlyPayment = Double.parseDouble(tfLoanAmount.getText()) * 
				monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,
				Double.parseDouble(tfNumberOfYears.getText()) * 12));

			output += String.format("%-24.3f%-34.2f%-8.2f\n", i, 
				monthlyPayment, (monthlyPayment * 12) * 
				Double.parseDouble(tfNumberOfYears.getText()));
```

### Testing

A step by step series of examples that you developed to properly test the program. 

Say what the step will be

Step 1: Create the required textfields.

```tfLoanAmount = new TextField();
tfNumberOfYears = new TextField();
textArea = new TextArea();
```

Step 2: Create hBox

And repeat

```
// Create a hbox
		HBox paneForControls = new HBox(10);
		paneForControls.setAlignment(Pos.CENTER);
```

Step 3: Create Pane
```
// Create a pane
		BorderPane pane = new BorderPane();
```

Step 4: Create output code from exercise 5.21

```
private void print() {
		// Create a output string
		String output = "";
		double monthlyInterestRate; // Monthly interest rate
		double monthlyPayment;	// Monthly payment
```
```
btShowTable.setOnAction(e -> {
			print();
		});
```
Step 5: Create Scene and place it in stage
```
Scene scene = new Scene(pane);
		primaryStage.setTitle("LoanInterest"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
```

End with an example of getting some data out of the system or using it for a little demo

## Notes

No issues or notes.

## Do not change content below this line
## Adapted from a README Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
