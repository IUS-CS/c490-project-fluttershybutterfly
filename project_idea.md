#**Section 1 – Motivation for Your App**
My motivation for this app is to create a mobile mockup of an indie game title that i have been working on in various class projects over the years. the target user base is all ages, since anyone can pick it up and play. My app is comparable to various arcade games of the 90’s, with less raging streets, trash cans, and way more cute things. While not really a mobile app (unless you count the switch in handheld mode), I believe that river city girls best resembles the type of title I wish to work on.
steam version: https://store.steampowered.com/app/1049320/River_City_Girls/

If you do need a mobile app though, here’s streets of rage, another old, yet classic beat-em-up: https://apps.apple.com/us/app/streets-of-rage-classic/id320540355

#**Section 2 - Meeting Minimum Requirements**
I have 3 screens for this app, the start screen, the character select screen (which is basically the player screen but with all the characters present), and the player screen where the action happens. The character select and player screen are square ratio, so they will be the same in landscape or portrait view and the start screen will be cropped accommodate the screen size (as visibility is a non-issue on this screen). I will use the concepts from the book implementations in order to keep score, character, and other elements from disappearing whenever the user switches screens or rotates the device. Below is both start screens, the character select screen, and player screen, respectively.

![portrait mode](/images/splash_by_olivia_stinston_vertical_format_mockup.png)
portrait mode
![landscape mode](/images/splash_by_olivia_stinston_horizontal_format_mockup.png)
landscape mode
![character select screen](/images/character_select_screen.png)
character select screen
![player screen](/images/you_chose_bow-wow.png) 
player screen

The user’s current score will be kept on the device. I may also implement cloud data storage for things such as high scores saves and leaderboards, but only if the requirements above are not met or it would be simple or easier to implement. The data will be stored using a simple variable that increases over time inside the user’s device, in other words, each time the player does something to increase their score, a call to a function will be made and the score will be updated. An SQL database in the cloud may also be required for implementation of high scores/leaderboards. The point at which the user’s score data may be stored/changed is during runtime of the app, onResume(), as well as at the end of the game for high scores and leaderboards, onStop(). The data will be retrieved by simply looking at the information stored on the device (or having an SQL data base call function to the cloud if it is high scores and leaderboards we are looking up) at the start of the app, onCreate(), or if the user has restarted the app, on onRestart(), as well as the end if, again, high scores and leaderboards are implemented, which would be at onStop() again. The app will use wi-fi to communicate to with the internet in order to retrieve high scores or save them or the user’s position on the leaderboard from some… server to be set up by me I suppose. I am also considering implementing a vs. mode where two devices will both communicate to the internet via wi-fi in real time.

#**2.1 User Interface**
1.	Must work in both landscape and portrait configuration and not lose any of the user’s input when switching between configurations, and/or screens
2.	There can be an exception to #1, but in your initial design document, you must make a compelling argument for it to work in only one configuration
3.	Must work on both the Samsung Tab A 10.1" and the Nexus Asus 7" tablets
4.	There can be an exception to #3, but in your initial design document, you must make a compelling argument for it to work on only one of these devices
5.	You must submit diagrams for all the different screens in your app (both portrait and landscape configurations), one diagram per screen. These diagrams must clearly show the layout of your app’s screens, i.e., where images, menus, widgets, views, etc., appear. These can be hand drawn with a .png submitted of the drawing.
 
#**2.2 Data Persistence**
1.	Your app must demonstrate that it saves data from one use to another
2.	To test this, your app will be shut down by an onDestroy() event, and then restarted
3.	Data entered in by the user during one use must be present when the app is restarted for another use

#**2.3 Communication**
Your app must demonstrate that it communicates with the outside world, with either another device or an external resource
Section 3 – MVC Breakdown of Your App
In this section, you must utilize the MVC Design Pattern to describe each of the screens supported by your app. There are a couple of ways you might go about organizing this section of your document:
1.	This approach uses one design document section per screen – i.e., provide View, Model, and Controller descriptions about each screen, one screen’s MVC set of descriptions after another
2.	This approach has three sections, a View section, a Model section, and a Controller section. In the View section provide a description of each screen appearing in your app, in the Model section provide a description of all Java classes used in the model, in the Controller section provide a description of all controllers required by your app.
 
#**3.1 View Descriptions**
![landscape mode](/images/splash_by_olivia_stinston_horizontal_format_mockup.png)
For the start screen we have a listener on the start button that when clicked, calls the onClick method. The xml file will be referred to as start.xml. As with all of my screens, I believe any size screen should look fine (although they may have some difficulty on their smart watch), so standard sizes like 600dp and 800dp is fine and will be supported. It will be a ConstraintLayout as will most of, if not all of the screens will be as the view will contain an image and a button.

![character select screen](/images/character_select_screen.png)
For the character select screen we have a key listener for whenever the user presses a key, which is handled by keyListener. The xml file will be referred to as select.xml. Again, any size should look fine, 600dp and 800dp included. It will be a ConstraintLayout as the view will contain multiple images, with the arrow being removed and added with each key press.

![you_choose_bow-wow](/images/you_choose_bow-wow.png)
For the player screen we have a key listener for whenever the user presses a key, which is handled by keyListener. The xml file will be referred to as select.xml. Second verse, same as the first for the minimum dp sizes. This one will also be a ConstraintLayout as the view will contain multiple images, some of which move around, are removed, or are added to the screen. After the game is finished, a picture will be displayed over the current screen showcasing the user’s saved high scores.
If I do decide to add a separate leaderboard/cloud-based high score screen, then that view will be a LinearLayout since it mainly contains a list of data.

#**3.2 Model Descriptions**
The first thing that needs to be stored is the current score that the user has, which will be saved on to the user’s device, probably through a userScore class (or to the cloud if I just go ahead and implement cloud saves as well). The second thing to remember is to store the user’s end score and compare that to their all-time high score. The last thing would be to consider storing their placement on a leaderboard of some sort or rank them based on other player’s high scores, both of which would use databases stored inside the cloud. 
Since userScore would have one public method and that requires a previous (positive) score to be added to, and then would be to simply add the required number of points (determined by an if or case statement), then store the new value of the user’s score in a variable of some sort and return that.
For each Java class used to store data, you must supply the name of the class, and a list of all public methods called by clients of the class (note: Controller classes are the likely clients). If a method has a precondition that must be satisfied by the calling client, e.g., a setter method that stores positive integer, then you must include a requires clause stating what the precondition is – this requires clause can be written in English or user mathematics if possible. Utilize design by contract in your design of the model java classes, i.e., if a setter method stores only positive integers, the setter method has a requires clause indicating that the value being supplied by the client must be positive, and the setter method does not have an if statement to check the requires clause.
And if I were to go with the leaderboard or cloud high score idea, I would require an SQL database that would have the rows be usernames and columns be user’s high scores.

#**3.3 Controller Descriptions**
onCreate() controls the start screen. onStart() handles the character select screen and onResume() handles the player screen. onStop() displays the image popup showing the user’s high scores (or the leaderboard screen if I choose to implement it, I might also allow the user to press a button to restart the app if required), and onDestroy cleans up the screens and closes the app. OnCreate() will start up the app and display the start screen, as well as create the button widget at the bottom which the user can press to call onStart() to switch the screen to the character select screen. Once a character is chosen onStart() stores the character choice to which onResume() retrieves (character frames, ect). onResume() then waits for a button press, plays the appropriate sound, and displays the appropriate sprite image. When the user does something to increase their score, the score is retrieved, updated appropriately, stored, and redisplayed. When the game is over, onResume saves the user score onto the user’s device so it may retrieve it after the onDestroy() is called and the user restarts the app, to which it then passes over to onStop(), which displays the user’s final score on the high scores image popup. When the user wishes to stop playing onDestroy is called, simply ending the app.
Start off with a high-level description of each controller and what screen it controls. Then include which Life Cycle methods are overridden by the controller. This part of the description will almost certainly have to include as a minimum how onCreate is implemented. Describe how and when the controller saves off data into the model, and how and when it retrieves data from the model.
You must describe how your app will satisfy the data persistence requirement in the controller descriptions and/or the model descriptions. If the model is designed so that it always keeps the persistent data store up-to-date, then the model description will more than likely discuss persistence. If the controller is implemented to update the persistent data store at some specific time of the app’s life cycle, then the controller’s description will more than likely discuss persistence. The discussion might need to appear in both the model and the controller descriptions.
