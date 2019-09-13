import java.util.Random;
import java.util.Scanner;

public class Prison {
  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args)
  {

    boolean playerChoice = silent, playerLastChoice = silent;
    boolean agentChoice = silent, agentLastChoice = silent;
    int playerYears=0, agentYears=0;
    int numPlayerBetrayed = 0, numAgentBetrayed = 0;
    String agentStrategy = "";
    boolean firstRunTFT = true;
    
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
    System.out.println("Enter the number for the strategy that you would like me to use: ";
    strategyChoice = in.nextInt();
    
    if (strategyChoice == 1) {
      System.out.println("Very well. I will betray at random.");
      agentStrategy = "Random";
    }
    else if (strategyChoice == 2) {
      System.out.println("Very well. I will always betray.");
      agentStrategy = "Always betraying";
    }
    else if (strategyChoice == 3) {
      System.out.println("Very well. I will always keep silent.");
      agentStrategy = "Always cooperating";
    }
    else if (strategyChoice == 4) {
      System.out.println("Very well. I will play with you using the 'tit-for-tat' strategy.");
      agentStrategy = "Tit-for-tat";
    } 
    else {
      System.out.println("Sorry, you have made an invalide choice of the game strategy. Please try again. Good luck!");
      agentStrategy = "Invalid Stratgy";
      return;
      
    }
    
    int numRounds = 10, currentRound = 1
    System.out.println("How many rounds would you like to play?";
    numRounds = in.nextInt();
    
    if (numRounds > 0)
    
    { 
      System.out.println("Very well, We will play " + numRounds + " rounds together");
    }
    else
    {
      System.out.println("Hey, we may play the game in sensible rounds! Why not try it again?");
      return;
     }
     
// Run a selected strategy
    while(currentRound <= numRounds) {
      System.out.println("Round" + currentRound);
      
      
         System.out.println("I havbe made my choice. Do you betray?";
         playerChoice = in.nextBoolean();
         if (playerChoice == betrayed) {
            System.out.println("Your choice is to betray.";
         }
            else {
            System.out.println("Your choice is to keep silent.");
         }
      
            break;
            
// Strategy 2: Always betray
      case 2:
      agentChoice = betrayed;             
      System.out.println("I have made my choice. Do you betray?");
      playerChoice = in.nextBoolean();
      if (playerChoice == betrayed) {
         System.out.println("Your choice is to betray.");
      }
      else {
         System.out.println("Your choice is to keep silent.");
      } 
      
      break;
      
// Strategy 3: Always keep silent
      case 3:
      agentChoice = silent;             
      System.out.println("I have made my choice. Do you betray?");
      playerChoice = in.nextBoolean();
      if (playerChoice == betrayed) {
         System.out.println("Your choice is to betray.");
      }
      else {
         System.out.println("Your choice is to keep silent.");
      } 

      break;
      
// Strategy 4: Tit-for-tat
      case 4:
         if (firstRunTFT)
         {
            // Always start with a cooperational gameplay
            
            agentChoice = silent;
            firstRunTFT = false;
         }
         else
         {
            // Always repeat the last choice made by the player
            agentChoice = playerLastChoice;
         }
          
         }
        
         System.out.println("I have made my choice. Do you betray?");
         
         playerChoice = in.nextBoolean();
         if (playerChoice == betray) {
            System.out.println("Your choice is to betray.");
         
         }
         else {
            System.out.println("Your choice is to keep silent.");
         } 
       
         break;
     
     // Skip running any invalid strategy selection (choosing a number option out of range)
     default:
         continue;
     }


     // Update the jailtime of each prisoner
     if (playerChoice && agentChoice) {
     
        playerYears += 2;
        agentYears += 2:
     }
     else if (playerChoice && !agentChoice) {
        agentYears += 3;
     }
     else if (playerChoice && agentChoice) {
        playerYears += 3; 
     }
     else if (!playerChoice && !agentChoice) {
        agentYears += 3;
        playerYears += 3;
     }
     
     // Update amount of betrayals of each prisoner
     if (playerChoice) {
        
        numPlayerBetrayed++;
     }
     
     
     playerLastChoice = playerChoice;
     agentLastChoice = agentChoice;
     currentRound++;
  }
  
  // Output Results
      System.out.println("Number of Player betrayals: " + numPlayerBetrayed);
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
  }