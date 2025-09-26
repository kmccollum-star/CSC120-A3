import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine; 


class Conversation implements ConversationRequirements {

  // Attributes 

  /**
   * Constructor 
   */
  int rounds;
  ArrayList<String> inputPronoun;
  ArrayList<String> outputPronoun;
  ArrayList<String> response;
  Scanner input;
  ArrayList<String> finalSentence;
  String sentence;
  Random random;

  
  Conversation(){
    inputPronoun = new ArrayList<String>();
    outputPronoun = new ArrayList<String>();
    response = new ArrayList<String>();
    finalSentence = new ArrayList<String>();
    random = new Random();
    // int min = 0;
    // int max = 7;
    //int randomNumber = random.nextInt(max - min +1) + min;

    
      inputPronoun.add("I");
      inputPronoun.add("Me");
      inputPronoun.add("me");
      inputPronoun.add("am");
      inputPronoun.add("You");
      inputPronoun.add("you");
      inputPronoun.add("My");
      inputPronoun.add("my");
      inputPronoun.add("Your");
      inputPronoun.add("your");

      outputPronoun.add("You");
      outputPronoun.add("You");
      outputPronoun.add("you");
      outputPronoun.add("are");
      outputPronoun.add("I");
      outputPronoun.add("I");
      outputPronoun.add("Your");
      outputPronoun.add("your");
      outputPronoun.add("My");
      outputPronoun.add("my");

      response.add("Oh, that's so cool!");
      response.add("Wow, that's interesting!");
      response.add("Fun!");
      response.add("Mhmm");
      response.add("Sounds nice!");
      response.add("Amazing");
      response.add("Awesome!");
      response.add("That's so great!");

  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    
    System.out.println("How many rounds?");
    Scanner input = new Scanner(System.in);
    rounds = input.nextInt();

    int min = 0;
    int max = 7;
    int randomNumber = random.nextInt(max - min +1) + min;

    for (int i = 0; i < rounds; i++ ){
      
      if(i == 1){
        boolean replaced = false;
        System.out.println("Hi there! What's on your mind?");
        finalSentence.add("Hi there! What's on your mind?");
        input.nextLine();

        sentence = input.nextLine();
        finalSentence.add(sentence);

        String[] words = sentence.split(" ", -1);
        String currResponse= "";

        for(int m = 0; m < words.length; m++){
          for (int j = 0; j < inputPronoun.size(); j++){
            if(words[m].equals(inputPronoun.get(j))){
              words[m] = outputPronoun.get(j);
              replaced = true;
              break;
            } 
          }
          currResponse = currResponse + words[m] + " ";
        }
        finalSentence.add(currResponse); 
        
        if(replaced == true){
          System.out.println(currResponse);
        } 
        else{
          System.out.println(response.get(randomNumber));
          finalSentence.add(response.get(randomNumber)); 
        }
        sentence = input.nextLine();
        finalSentence.add(sentence);

      }
      //second round starts here*****************
      else if (i > 1 && i < rounds) {
      boolean replaced = false;
      String currResponse= "";
      String[] words = sentence.split(" ", -1);

       for(int m = 0; m < words.length; m++){
          for (int j = 0; j < inputPronoun.size(); j++){
            if(words[m].equals(inputPronoun.get(j))){
              words[m] = outputPronoun.get(j);
              replaced = true; 
              break;
            } 
          }
          currResponse = currResponse + words[m] + " ";
        }
        finalSentence.add(currResponse); 
        
        if(replaced == true){
          System.out.println(currResponse);
        } 
        else{
          System.out.println(response.get((randomNumber)));
          finalSentence.add(response.get(randomNumber));
        }
        } 
      }
      System.out.println("See ya!");
      finalSentence.add("See ya!"); 
      input.close();
    }


  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("Transcript: ");
    for (int p = 0; p < finalSentence.size(); p++){
      System.out.println(finalSentence.get(p));
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    System.out.println("\n");
    myConversation.printTranscript();

  }
}