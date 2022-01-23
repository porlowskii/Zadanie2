package UserInterface;

import Factoring.Factoring;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private Factoring factoringInputs = new Factoring();

    public UserInterface() {
        this.scan=new Scanner(System.in);
    }
    public void start() {
        System.out.println("Write table size");
        System.out.println("Format: number");
        //first input line
        while (true) {
            String input;
            input = String.valueOf(scan.nextLine());
            if (!factoringInputs.firstLine(input).equals("Correct")) {
                System.out.println(factoringInputs.firstLine(input));
                continue;
            }
            break;
        }

        //second input line
        System.out.println("Write "+ factoringInputs.getTableSize()+" numbers for add to table");
        while (true) {
            String inputTable = String.valueOf(scan.nextLine());
            if (!factoringInputs.secondLine(inputTable).equals("Correct")) {
                System.out.println(factoringInputs.secondLine(inputTable));
                continue;
            }
            break;
        }

        System.out.println(factoringInputs.getTableSize() + " " + factoringInputs.getTable());
        if (factoringInputs.getLookingForNumbers().size()==1) {
            System.out.println("Your looking for number is: " + factoringInputs.getLookingForNumbers());
        }
        if (factoringInputs.getLookingForNumbers().size()>1) {
            System.out.println("Your looking for numbers are: " + factoringInputs.getLookingForNumbers());
        }
    }
}