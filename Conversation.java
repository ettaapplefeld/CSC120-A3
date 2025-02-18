import java.util.Scanner;
import java.util.Random;

/** 
 * includes attributes needed for conversation, the Conversation constructor, and methods for starting the conversation, printing the transcript, and responding to the user
 */
class Conversation implements Chatbot {


  // Attributes 

  public int Rounds;
  public String[] transcript;
  public int transcriptIndex;
  Random random = new Random();
  public String[] cannedResponses = {"That's awesome.", "Wow!!", "Oh cool, tell me more!", "Mmhmm", "For sure for sure."};

  /**
   * Constructor 
   */
  Conversation() {
    this.transcript = new String[0]; //placeholder size for the array
    this.transcriptIndex = 0;
    
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in);

    /**
     * asks user how many rounds of conversation they would like and scans for integer in their response
    */
    System.out.println("How many rounds of conversation would you like to have?");
    int Rounds = input.nextInt();
    input.nextLine();
    /**
     * Defines the array that will store the transcript. length of array based on number of rounds and hello and goodbye statements
     */
    transcript = new String[(Rounds +1) *2];
    System.out.println("Hey! How's it going?");
    transcript[transcriptIndex++] = "Hey! How's it going?"; //makes sure greeting is stored

    for(int i = 0; i < Rounds; i++) {
      String userInput = input.nextLine();
      transcript[transcriptIndex++] = userInput;
      String botResponse = respond(userInput);
      System.out.println(botResponse);
      transcript[transcriptIndex++] = botResponse;
    }
    System.out.println("Nice talking to you! Goodbye!");
    transcript[transcriptIndex++] = "Nice talking to you! Goodbye!";
  }

  /**
   * Prints transcript of conversation. includes heading to alert that this is the transcript.
   */
  public void printTranscript() {
    System.out.println("\n TRANSCRIPT:");
    for(int i = 0; i < transcriptIndex; i++)  {
      System.out.println(transcript[i]);

    }

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   * 
   * my program does not include mirrored responses at this point
   */
  public String respond(String inputString) {
    String botResponse = cannedResponses[random.nextInt(cannedResponses.length)];
    return botResponse;

  }

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();


  }
}
