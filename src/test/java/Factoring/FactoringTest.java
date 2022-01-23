package Factoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class FactoringTest {

    @Test
    @DisplayName("input1 other values than numbers")
    void firstLine_inputOtherValuesThanNumbers() {
        //given
        Factoring factoringInputs = new Factoring();
        String input = this.generateString();
        //when
        var exception = factoringInputs.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("input1 more than 1 number")
    void firstLine_inputMoreThanOneNumber() {
        //given
        Factoring factoringInputs = new Factoring();
        String input = this.randomInt()+" "+this.randomInt();
        //when
        var exception = factoringInputs.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("input1 negative numbers")
    void firstLine_inputNegativeNumbers() {
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = "-"+String.valueOf(numberTwo);
        //when
        var exception = factoringInputs.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("correct input1")
    void firstLine_correctInput() {
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne);
        //when
        var exception = factoringInputs.firstLine(input);
        //than
        assertThat(exception).contains("Correct");
    }

    @Test
    @DisplayName("input2 incorrect number of numbers - more than excepts")
    void secondLine_inputIncorrectNumberOfNumbers_MoreThanExcepts(){
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne);
        factoringInputs.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne+2;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();

        //when
        var exception = factoringInputs.secondLine(input2);
        //than
        assertThat(exception).contains("size");
    }
    @Test
    @DisplayName("input2 incorrect number of numbers - less than excepts")
    void secondLine_inputIncorrectNumberOfNumbers_LessThanExcepts(){
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne);
        factoringInputs.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne-2;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();

        //when
        var exception = factoringInputs.secondLine(input2);
        //than
        assertThat(exception).contains("size");
    }
    @Test
    @DisplayName("input2 incorrect format of input")
    void secondLine_inputIncorrectFormatOfInput(){
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne);
        factoringInputs.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne-1;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.generateString();
        //when
        var exception = factoringInputs.secondLine(input2);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("correct input2")
    void secondLine_correctInput(){
        //given
        Factoring factoringInputs = new Factoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne);
        factoringInputs.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne-1;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();
        //when
        var exception = factoringInputs.secondLine(input2);
        //than
        assertThat(exception).contains("Correct");
    }


    public String generateString () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public Integer randomInt () {
        return (int)(Math.random() * 1000) + 1;
    }
}