Manifest-Version: 1.0
Main-Class: edu.neu.ccs.cs5010.server.YahtzeeServer


*Project Summary*
---
This project implements the all the game rules from the Yahtzee game, and allows any number of player.

**Project Structure**
---
This project implements a Server-Client structure, where server needs to launch first, with particular commandline arguments in a server-client scheme.

**Class Summary**
---
* YahtzeeClient:
This class launches the client, sets up socket with the server as well as the Player class.
During each player's turn, the client is responsible to process the incoming String message from the player class, and determine the corresponding State of the game, then output message to the player to drive the next move.

* YahtzeeServer:
This class launches the server, sets up the socket with the client.
The server class is mainly responsible for starting the game, monitoring the turns for each player, and verifies the termination of the entire game.

* YahtzeeGame:
This class is the entry point to kickoff the game and pass the turn to the player. In addition this class has a method to check whether this game is reaching the finish status.

* Player:
This class mainly maintains a player with a various attributes including the player name, the player's scorecard, allow the player to choose dices and scores and etc.
The main logic to interpreting the user input and providing the appropriate feedback to the YahtzeeClient is also in this class.

* Dice:
This is the root class of implementing a die. Keeping track of the value, allowing a roll.

* SetOfDice:
This is the class to keep track of a set of dice and the related methods to get total values for score patterns.
There are also additional methods to roll dice -- either all of them all except for the one being chosen by the player.

* gameutil.scores
This package contains all the classes to implement all score patterns.
Each score pattern associated pattern basically implements the corresponding algorithm to calculate the total score based on the given set of dice.
The Manufacturer Pattern is used here to construct and instantiate new score pattern based on user choice every time, and the player's scorecard would be filled gradually.

**Usage Examples**
---
The project has been built into jar files, and can be launched in command line.

Below are the examples for launching the Server and Client.

Navigate to the specific folding containing the Jar file before inputting the following commands.

command for running standard server on [port number] (by default the game starts for two players):
```
java -cp yahtzee.jar edu.neu.ccs.cs5010.server.YahtzeeServer [port number]
```

command for running server in DEV mode:
```
java -cp yahtzee.jar edu.neu.ccs.cs5010.server.YahtzeeServer [port number] DEV
```

command for running server with X number of player:
```
java -cp yahtzee.jar edu.neu.ccs.cs5010.server.YahtzeeServer [port number] [player number X]
```

command for running server with X number of player AND in DEV mode:
```
java -cp yahtzee.jar edu.neu.ccs.cs5010.server.YahtzeeServer [port number] [player number X] DEV
```

command for running client:
```
java -cp yahtzee.jar edu.neu.ccs.cs5010.server.YahtzeeServer [port number]
```
