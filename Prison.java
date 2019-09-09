import java.util.Random;
import java.util.Scanner; 

public class Prison {
   //True : the prisoner betrayed.
   //False : the prisoner stayed silent.
   final static boolean BETRAYED = true;
   final static boolean SILENT = false;

   public static void main(String[] args)
   {
      boolean playerChoice = false, playerLastChoice = false;
      boolean agentChoice = false, agentLastChoice = false;
      Integer playerYears = 0, agentYears = 0;
      Scanner in = new Scanner(System.in); 
      
      Random rand = new Random();
      
      System.out.println("Welcome to the Prisoner's Dilemma Game!");
      System.out.println("I know how to play this game many ways.");
      System.out.println("Here is a list of the strategies I know:");
      System.out.println("1. Betray at random");
      System.out.println("2. Always betray");
      System.out.println("3. Always be silent");
      System.out.println("4. Tit-for-Tat");
       
      int strategyChoice = 1;
      System.out.println("Enter the number for the strategy that you would like me to use:");
      strategyChoice = in.nextInt();
   
      if (strategyChoice == 1) {
         System.out.println("Very good. I will betray at random.");
      }
      else if (strategyChoice == 2) {
         System.out.println("Very good. I will always betray.");
      }
      else if (strategyChoice == 3) {
         System.out.println("Very good. I will always keep silent.");
      }
      else if (strategyChoice == 4) {
         System.out.println("Very good. I will play with you using the 'tit-for-tat' strategy.");
      }
      else {
         System.out.println("Sorry, you have made an invalide choice of the game strategies. Please try again. Good luck!");
         return;
      }
      
      int numRounds = 10, currentRound = 1;
      System.out.println("How many rounds would you like to play?");
      numRounds = in.nextInt();
   
      System.out.println("Very good. We will play " + numRounds + " rounds together");

      while (currentRound <= numRounds) {
         System.out.println("Round " + currentRound);
      
         switch (strategyChoice) {
         //Strategy 1: Agent using no prior information and choosing at random
         case 1:
            agentChoice = rand.nextBoolean();             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == true) {
            System.out.println("Your choice is to betrate.");
            }
            else {
            System.out.println("Your choice is to keep silent.");
            } 
            
            // Update the penalty years of each prisoner
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            
            break;
         // Strategy 2: Always betrate
         case 2:
            agentChoice = true;             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == true) {
            System.out.println("Your choice is to betrate.");
            }
            else {
            System.out.println("Your choice is to keep silent.");
            } 
            
            // Update the penalty years of each prisoner
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            
            break;
         // Strategy 3: Always keep silent
         case 3:
            agentChoice = false;             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == true) {
            System.out.println("Your choice is to betrate.");
            }
            else {
            System.out.println("Your choice is to keep silent.");
            } 
            
            // Update the penalty years of each prisoner
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            
            break;
         // Strategy 4: Tit-for-tat
         case 4:
            // Start with a cooperational play
            agentChoice = true;             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == true) {
               System.out.println("Your choice is to betrate.");
            }
            else {
               System.out.println("Your choice is to keep silent.");
            } 
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            
            // Continue the play by always resembling the player's last choice
            agentChoice = playerLastChoice;
            System.out.println("Let's continue on our play. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == true) {
               System.out.println("Your choice is to betrate.");
            }
            else {
               System.out.println("Your choice is to keep silent.");
            } 
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            
            break;
         }
         
         playerLastChoice = playerChoice;
         agentLastChoice = agentChoice;
         currentRound++;
      }

      System.out.println("I'm sorry, I do not know who won.");
      System.out.println("I'm sorry, I do not yet know how to play multiple rounds.");
      System.out.println("Game Over");
  }
  
  // Update prisoners' penalty years based on their defection/cooperation choice
  static void updateYears(boolean betrateA, boolean betrateB, Integer yearsA, Integer yearsB)
  {
      if (betrateA && betrateB) {
         yearsA += 2;
         yearsB += 2;
      }
      else if (betrateA && !betrateB) {
         yearsB += 3;
      }
      else if (!betrateA && betrateB) {
         yearsA += 3;
      }
      else if (!betrateA && !betrateB) {
         yearsA += 1;
         yearsB += 1;
      }
  }
}