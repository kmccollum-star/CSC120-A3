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

  
  Conversation(){
    inputPronoun = new ArrayList<String>();
    outputPronoun = new ArrayList<String>();
    response = new ArrayList<String>();
    finalSentence = new ArrayList<String>();
    //sentence = input.nextLine();

    
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
    //boolean replaced = false;

    for (int i = 1; i <= rounds; i++ ){
      
      if(i == 1){
        boolean replaced = false;
        System.out.println("Hi there! What's on your mind?");
        input.nextLine();

        sentence = input.nextLine();
        //System.out.println(sentence); //test

        String[] words = sentence.split(" ", -1);
        //System.out.println(words); //test
        String currResponse= "";

        //System.out.println("length");//test
        //need if statement to check if answer has been replaced or not
        System.out.println(words.length); //test
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
        
        //problem somewhere here
        if(replaced == true){
          System.out.println("hi");//test
          System.out.println(currResponse);
        } 
        else{
          System.out.println(response.get((1))); 
        }
        sentence = input.nextLine();

      }
      //second round starts here*****************
      else if (i > 1 && i <= rounds) {
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
          System.out.println("hi");//test
          System.out.println(currResponse);
        } 
        else{
          System.out.println("Hi");//test
          System.out.println(response.get((1))); 
        }
        } 
      }
      System.out.println("See ya!"); 
      input.close();
    }
  
      

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
// **want to try storing all the scanners in an array, then printing the array?
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
    myConversation.printTranscript();

  }
}

//1. break string sentence into words arraylist(?)
//2. create empty array list
//3. for loop{if words[i] matches any of inputPronoun, then change to outputPronoun 
//add new word to empty array list
// if the word doesn't match any of inputPronoun, then add original word to empty array list
//print each item in the array list and should repeat back word
//if havent replaced anything, return canned response

// String sentence = input.next();
      // String[] words = sentence.split(" ");
      // //StringReader punctuation = new StringReader(sentence);
      
      // for (int n = 0; n < words.length; n++){
      //   if(inputPronoun.indexOf(words[n]) != -1){
      //     words[n] = outputPronoun.get(inputPronoun.indexOf(words[n]));
      //     System.out.println(words[n]);
      //   }
      // }
      // sentence = String.join(" ", words);
      // System.out.println(sentence);
      // System.out.println(words);

      // //for (int k = 0; k < punctuation.length; k++){
      // //  if()
      // //}