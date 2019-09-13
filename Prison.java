import java.util.Random;
import java.util.Scanner; 

public class Prison {
   //True : the prisoner betrayed.
   //False : the prisoner stayed silent.
   final static boolean BETRAYED = true;
   final static boolean SILENT = false;

   public static void main(String[] args)
   {
      boolean playerChoice = SILENT, playerLastChoice = SILENT;
      boolean agentChoice = SILENT, agentLastChoice = SILENT;
      int playerYears = 0, agentYears = 0;
      int numPlayerBetrayed = 0, numAgentBetrayed = 0;
      String agentStrategy = "";
      boolean firstRunTFT = true; // First run in a Tit-for-Tat strategy
      
      Scanner in = new Scanner(System.in); 
      Random rand = new Random();
      
      System.out.println("Welcome to the Prisoner's Dilemma Game!");
      System.out.println("I know how to play this game many ways.");
      System.out.println("Here is a list of the strategies I know:");
      System.out.println("1. Betray at random");
      System.out.println("2. Always betray");
      System.out.println("3. Always stay silent");
      System.out.println("4. Tit-for-Tat");
       
      int strategyChoice = 1;
      System.out.println("Enter the number for the strategy that you would like me to use:");
      strategyChoice = in.nextInt();
   
      if (strategyChoice == 1) {
         System.out.println("Very good. I will betray at random.");
         agentStrategy = "Random";
      }
      else if (strategyChoice == 2) {
         System.out.println("Very good. I will always betray.");
         agentStrategy = "Always Betraying";
      }
      else if (strategyChoice == 3) {
         System.out.println("Very good. I will always stay SILENT.");
         agentStrategy = "Always Coorperating";
      }
      else if (strategyChoice == 4) {
         System.out.println("Very good. I will play with you using the 'tit-for-tat' strategy.");
         agentStrategy = "Tit-for-Tat";
      }
      else {
         System.out.println("Oops, you have made an invalid choice of the game strategies. Please try to play the game again. Good luck!");
         agentStrategy = "Invalid Strategy";
         return;
      }
      
      int numRounds = 10, currentRound = 1;
      System.out.println("How many rounds would you like to play?");
      numRounds = in.nextInt();
   
      if (numRounds > 0)
      {
         System.out.println("Very good. We will play " + numRounds + " rounds together");
      }
      else
      {
         System.out.println("Hey man, we may play the game in sensible number of rounds! Why not try it again?"); // Easter Egg
         return;
      }

      // Run a selected strategy for the given number of rounds
      while (currentRound <= numRounds) {
         System.out.println("Round " + currentRound);
      
         switch (strategyChoice) {
         //Strategy 1: Agent using no prior information and choosing at random
         case 1:
            agentChoice = rand.nextBoolean();             
            playerChoice = getPlayersChoice();
            break;
            
         // Strategy 2: Always betray
         case 2:
            agentChoice = BETRAYED;             
            playerChoice = getPlayersChoice();
            
            break;
            
         // Strategy 3: Always keep silent
         case 3:
            agentChoice = SILENT;             
            playerChoice = getPlayersChoice();
            
            break;
            
         // Strategy 4: Tit-for-tat
         case 4:
            if (firstRunTFT)
            {
               // Always start the play with a cooperational play
               agentChoice = SILENT;      
               firstRunTFT = false;
            }
            else
            {
               // Always repeat the last choice of the player
               agentChoice = playerLastChoice;
            }
            
            playerChoice = getPlayersChoice();
            
            break;
            
         // Skip running any invalid strategy selection 
         default:
            continue;
         }
         
         // Update the penalty years of each prisoner
         if (playerChoice && agentChoice) {
            playerYears += 2;
            agentYears += 2;
         }
         else if (playerChoice && !agentChoice) {
            agentYears += 3;
         }
         else if (!playerChoice && agentChoice) {
            playerYears += 3;
         }
         else if (!playerChoice && !agentChoice) {
            playerYears += 1;
            agentYears += 1;
         }
         
         // Update betraying times of each prisoner
         if (playerChoice) {
            numPlayerBetrayed++;
         }
         
         if (agentChoice) {
            numAgentBetrayed++;
         }
        
         playerLastChoice = playerChoice;
         agentLastChoice = agentChoice;
         currentRound++;
      }

      // Output results
      System.out.println("Number of Player BETRAYED: " + numPlayerBetrayed);
      System.out.println("Number of Aagent betrayed: " + numAgentBetrayed);
      System.out.println("Player's total sentenced years: " + playerYears);
      System.out.println("Agent's total sentenced years: " + agentYears);
      System.out.println("Strategy that Agent used: " + agentStrategy);
      if (playerYears > agentYears)
      {
         System.out.println("Agent won the game!");
      }
      else if (playerYears < agentYears)
      {
         System.out.println("Player won the game!");
      }
      else
      {
         System.out.println("Player and Agent tied the game.");
      }

      System.out.println("Game Over.");
  }
  
  static boolean getPlayersChoice()
  {
      String response = "";
      boolean playerChoice = SILENT;
      Scanner in = new Scanner(System.in); 
      
      System.out.println("I have made my choice. Do you betray (y/n)?");
      response = in.nextLine();
      if (response.compareToIgnoreCase("y") == 0 || response.compareToIgnoreCase("yes") == 0)
      {
         playerChoice = BETRAYED;
      }
      else
      {
         playerChoice = SILENT;
      }
      
      if (playerChoice == BETRAYED) {
         System.out.println("Your choice is to betray.");
      }
      else {
         System.out.println("Your choice is to stay silent.");
      } 
      
      return playerChoice;
  }
}
// Final Commit. 