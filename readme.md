# Project 1
In this project, you will write code that plays a simple game called "The Prisoner's Dilemma." There are many strategies to play this game. You will write the code that allows a user to play your version of the game. You will write the code for several strategies that your program will use to compete with the user. These strategies are incredibly simple, and consist of a few lines of code each.

# Teams
You may partner with another student on this project to discuss code and strategies for completing the various parts of the assignment. You may share code with your partner, but you should still write much of your own code in your own repository. You should still update your repository (by pushing) incrementally as you make progress. It is up to teammates to ensure that their partner adheres to the <a href="https://www.american.edu/academics/integrity/code.cfm">American University Honor Code.</a> You may use [pair programming](https://en.wikipedia.org/wiki/Pair_programming), however, you must each take turns in the driver role on your own laptop. I should see commits and a submission on Github for each of you to get full credit for this assignment. If you decide to work with a partner, modify the statement below:

- [ ] I worked with [insert partner name] on this project.
- [x] I worked on my own.

## Step 0 - Background Research.
1. **Both members** should review the description for the <a href="https://en.wikipedia.org/wiki/Prisoner%27s_dilemma">Prisoner's Dilemma</a> on Wikipedia. You *do not* need to become familiar with the intimate mathematical details of the Dilemma, just the general mechanism and the difference between the iterated dilemma and the non-iterated version (Introduction through the end of Section 3.1).
1. This topic has been debated endless in a variety of fields, so there is a lot of additional material available if you want to dig deeper. For this assignment, you will only be required to be familiar with the basics (e.g., you will not need to understand the Nash equilibrium or the proof that goes with it).
1. **Both members** should work together to devise three strategies for "winning" the prisoner's dilemma over a long number of rounds. I recommend first writing these strategies down in simple English rather than trying to jump directly into developing code. You may use the 'tit-for-tat' strategy as one of them, or come up with ones of your own. You cannot count the provided "random" strategy as one of your three - sorry! **At least one** of your three strategies must take into account the previous choice, or choices, made by the player
1. **Optional** There are several good videos that can help make these concepts a little clearer. I recommend [this one](https://www.youtube.com/watch?v=BOvAbjfJ0x0), but there are many others.

## Step 1 - Create the Repo for your Team.
1. **Both members** will clone the repository to your local machines (i.e., using `git clone <URL>`). You will then each have a local repository that is linked to the shared repository, and can work on the code together.
1. As a reference for how to use git, I suggest <a href='http://codingdomain.com/git/'>this site</a>, as it avoids some of the more complicated theory behind git and focuses on the bare minimum practicalities.

## Step 2 - Review the Provided Code.
In the repository is a starter class, `Prison`, that has the bare minimum for the prisoner's dilemma. There is a variable for the last choice made by each of two prisoners, (i.e., the player and the computer-controlled "Agent").

```java
    boolean playerChoice, playerLastChoice;
    boolean agentChoice, agentLastChoice;
```

The minimum structure for a game of Prisoner's dilemma is given. The user is prompted to answer several questions, but the skeleton code does not yet accept user input. Instead, default values are set for many of the questions.

## Step 3 - Get Player Input.
When the player starts the game they are asked to answer questions. Update the skeleton code so that the strategy selection, number of rounds, and player betray decision come from the user input to the console instead of using the default methods in the code now.

## Step 3.5 - Commit and Push to Github
Remember, this is not like using Blackboard for submitting assignments. As you are working with your teammate, you will need to frequently push code to the Github repo. If you wait to the last minute, you could have conflicts that are difficult to resolve. It is much better to get into a rhythm with your partner early. To get full credit for your part in this, I need to see multiple commits from each team member.

## Step 4
You are going to need to plan in advance how you will structure your project code so that the player choices affect which "path" the execution takes. This means constructing an overall way for the strategy selected by the player to determine which code executes, and which code does not. There are several ways to do this:
- nested if-else conditions
- multiway if-else-if conditions
- switch statement

You are going to also need to plan in advance how you will allow the user to play multiple rounds. If the player wants to play ten times, you certainly don't want to have to copy and paste the code ten times to allow this! There are several ways to do this:
- for loop
- while loop
- do-while loop

## Step 4.1 - Write the code for your first strategy
If your first strategy is selected, the computer agent will decide whether to betray or not using the logic that you have devised. The player will be prompted for their response. The computer will print to console what the selections were.

## Step 4.2 - Write the code for your second strategy
If your second strategy is selected, the computer agent will decide whether to betray or not using the logic that you have devised. The player will be prompted for their response. The computer will print to console what the selections were.

## Step 4.3 - Write the code for your third strategy
If your third strategy is selected, the computer agent will decide whether to betray or not using the logic that you have devised. The player will be prompted for their response. The computer will print to console what the selections were.

## Step 5 - Write code for scoring the outcome
If they both stay silent then both prisoners serve 1 year. If a prisoner *stays silent* and the other *betrays*, then the prisoner who stayed silent gets 3 years in prison while the other goes free. If both *betray*, then each prisoner serves 2 years. Write a method that assigns a score to a strategy based upon the outcome. A high score is a bad thing, as each point represents a number of additional years added to the prisoner's sentence.

A betrays | B betrays | A years added | B years added
-|-|-|-
T | T | 2 | 2
T | F | 0 | 3
F | T | 3 | 0
F | F | 1 | 1

After each pair of choices is made in a round, you should score the results of that round and add the correct number of years to each player's sentence.

## Step 6 - Cleanly Print the Results
After the last round, print to the screen the total number of times each player betrayed and the number of years added to each sentence. Print which strategy the computer agent was using, and whether the player or the computer agent was the winner or if there was a tie.

## Step 7 - Add an "Easter Egg"
There are many moments when the user is asked for input from a well-defined collection of possible responses (e.g., the number of rounds, whether or not to betray). At any one of these points, you should include a response to a non-standard input. If the user is asked to type in the number of rounds, but types in a zero, the game can say "Hey, why play this at all?" and quit. This [Easter Egg](https://en.wikipedia.org/wiki/Easter_egg_(media)#Software) is yours to design - do not spend too much time fretting over this, but it should be unique to your project submission. This Easter Egg should not be advertised at runtime, but it should be clearly labeled in your source code by a comment.

## Step 8 - Push to Github
Do not forget to push your final submission to Github before the deadline.

# Grading
Grading will be assigned according to the following categories. As described in the syllabus, each category can receive a  &#10003; (satisfactory); a &#10003;+ (above and beyond); a &#10003;- (incorrect, incomplete, or sloppy); or in the worst case an &#10005;, meaning it was incorrect in several ways. A category assigned an &#10005; can carry significant grade penalties for this assignment, but usually does not receive more than 50% of the possible credit for an task.

Missing components receive a score of zero, but it is better to be missing a component (or comment it out) instead of submitting code that does not compile. Code that does not compile will not be graded, and a zero will be assigned for the project. Submitted code that contains runtime errors will be graded at the instructor's discretion.

1. **10%** Multiple commits were made throughout the project as progress was made, not just one big upload at the end.
1. **10%** The code is easy to follow and understand. Good comments, meaningful variable names, and good indentation are all present.
1. **15%** Depending on which selection is made, the project will redirect the path of execution to use one of three possible strategies to try to win the game against the player.
1. **20%** The game will play as many rounds as the player requests, and will keep score and a record of previous choices between rounds.
1. **10%** One strategy is present and works.
1. **10%** A second strategy is present, works, and is different from the first.
1. **10%** A third strategy is present, works, and is different from the other two. This strategy must use the previous choice or choices of the player to decide whether to betray or not.
1. **10%** The results are printed cleanly at the end.
1. **5%** An Easter Egg is included.