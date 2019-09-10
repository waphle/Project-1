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
      Integer playerYears = 0, agentYears = 0;
      Integer numPlayerBetrayed = 0, numAgentBetrayed = 0;
      String agentStrategy = "";
      
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
         System.out.println("Very good. I will always stay silent.");
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
         System.out.println("Hey, we may play the game in sensible rounds! Why not try it again?");
         return;
      }

      // Run a selected strategy
      while (currentRound <= numRounds) {
         System.out.println("Round " + currentRound);
      
         switch (strategyChoice) {
         //Strategy 1: Agent using no prior information and choosing at random
         case 1:
            agentChoice = rand.nextBoolean();             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == BETRAYED) {
               System.out.println("Your choice is to betray.");
            }
            else {
               System.out.println("Your choice is to stay silent.");
            } 
            
            break;
            
         // Strategy 2: Always betrate
         case 2:
            agentChoice = BETRAYED;             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == BETRAYED) {
               System.out.println("Your choice is to betray.");
            }
            else {
               System.out.println("Your choice is to stay silent.");
            } 
            
            break;
            
         // Strategy 3: Always keep silent
         case 3:
            agentChoice = SILENT;             
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == BETRAYED) {
               System.out.println("Your choice is to betray.");
            }
            else {
               System.out.println("Your choice is to stay silent.");
            } 
            
            break;
            
         // Strategy 4: Tit-for-tat
         case 4:
            // Start with a cooperational play
            agentChoice = SILENT; // Will cooperate this time      
            System.out.println("I have made my choice. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == BETRAYED) {
               System.out.println("Your choice is to betray.");
            }
            else {
               System.out.println("Your choice is to stay silent.");
            } 
            
            // Update prisoners' years and betraying times for this cooperation run
            updateYears(playerChoice, agentChoice, playerYears, agentYears);
            updateBetrayingTimes(playerChoice, agentChoice, numPlayerBetrayed, numAgentBetrayed);
            
            // Continue the play by always resembling the player's last choice
            agentChoice = playerLastChoice;
            System.out.println("Let's continue on our play. Do you betray?");
            playerChoice = in.nextBoolean();
            if (playerChoice == BETRAYED) {
               System.out.println("Your choice is to betray.");
            }
            else {
               System.out.println("Your choice is to stay silent.");
            } 

            break;
            
          default:
          // Skip running any invalid strategy selection 
            continue;
         }
         
         // Update the penalty years of each prisoner
         updateYears(playerChoice, agentChoice, playerYears, agentYears);
         
         // Update betraying times of each prisoner
         updateBetrayingTimes(playerChoice, agentChoice, numPlayerBetrayed, numAgentBetrayed);
         
         playerLastChoice = playerChoice;
         agentLastChoice = agentChoice;
         currentRound++;
      }

      // Output results
      System.out.println("Number of Player betrayed: " + numPlayerBetrayed);
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
  
  // Update prinsoners' betraying times
  static void updateBetrayingTimes(boolean betrateA, boolean betrateB, Integer betrayingsA, Integer betrayingsB)
  {
      if (betrateA) {
         betrayingsA++;
      }
      
      if (betrateB) {
         betrayingsB++;
      }
  }
}