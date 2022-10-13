<h1 align="center">
  <br>
  <a href="https://github.com/rohira-dhruv/DiceGames"><img src="https://i.imgur.com/aCDxBer.png" alt="Dice Games" width="200"></a>
  <br>
  Dice Games
  <br>
</h1>

<h4 align="center">A simple Android application that allows the user to roll a dice and earn coins if they roll sixes, but there is a catch - Rolling double numbers other than six will cost them coins.
<br>
<br>

<p align="center">
  <a href="#student-details">Student details</a> •
  <a href="#brief-description">Brief Description</a> •
  <a href="#task-descriptions">Task Descriptions</a> •
  <a href="#testing">Testing</a> •
  <a href="#time-taken">Time Taken</a> •
  <a href="#accessibility">Accessibility</a> •
  <a href="#difficulty-rating">Difficulty Rating</a> •
  <a href="credits">Credits</a>
</p>

## Student details

- <strong>Name of the Project :</strong> Dice Games
    - <strong>Created By :</strong> Dhruv Rohira
    - <strong>BITS ID : </strong> 2020A7PS1725G
    - <strong>Email ID : </strong> f20201725@goa.bits-pilani.ac.in , dhruvjrohira@gmail.com

## Brief Description

- The application, "Dice Games", is a game where the user can roll a normal dice and based on the outcome, the user earns or loses some coins. 

- If the user rolls a six, they earn 5 coins and for every consecutive six rolled, they earn 5 bonus coins in addition, i.e., 10 coins for each consecutive six.

- But there is a catch, If the user rolls any number other than six, i.e, rolls consecutive ones, twos, threes, fours, or fives, they will lose 5 coins.

- <strong>Any Known bugs :</strong> There are some bugs which I have identified as of now:
    - The UI elements might not be symmetric vertically on devices of different lengths.
    - Tapping the dice button in quick succession might result in multiple Toasts being created which are displayed at a delay.

## Task Descriptions

- <strong> Task 1: </strong>

    - I implemented the WalletActivity class in my Android project by following the lecture material provided by the professor and understanding each steps well as I implemented them one after the other. Some changes like changing the LinearLayout to ConstraintLayout, and adding other UI elements was done.

    - Persisting the UI state can be done in two ways, one by using Bundle and one by using a ViewModel class for the activity. I tried both ways of persisting the UI state but in using Bundle, I encountered a bug that on multiple orientation changes, the UI state is lost. 

    - This is not the case with ViewModel (suggested by our professor), which offers more easier and modular approach to solving this problem. So I have used a ViewModel class - "WalletViewModel" to have persistent data in "WalletActivity".

    - Next, I created the alternative layout xml file with LinearLayout as the root element. But since the requirement was that of a ConstraintLayout, I found a method to convert LinearLayout to ConstraintLayout offered by Android Studio itself. I used this and made some changes in the constraints to get the final landscape UI for my app.
<br>

- <strong> Task 2: </strong>

    - In order to implement a Toast object, I first went through the official Android developer documents [(Toast Documentation)](https://developer.android.com/guide/topics/ui/notifiers/toasts). 

    - The Android documentation was quite easy to understand but I needed some data from the <i>WalletViewModel.java</i> file in order to create the Toast exactly when it was needed. So I created a static boolean field <i>inc</i> using which I could create the Toast whenever the user earns some coins. 
<br>

- <strong> Task 3: </strong>

    - To get the win rate, I had to count the total number of rolls that have been done as well as the number of sixes (both single and double sixes) that have been rolled so far. 

    - To do this, I created various static fields and defined getter methods to access these in the <i>WalletActivity</i> class and set them according to my Model.
    <br>

- <strong> Task 4: </strong>

    - Further statistics such as number of sixes rolled, number of double sixes rolled, number of doubles (other than six) rolled and the last rolled number were added to the UI.

    - This was done by adding these fields to the <i>WalletViewModel</i> class and then accessing them in the <i>WalletActivity</i> class using getter methods.

    - This also provides some clarity to the user and it allows him to calculate the coins as the game progresses.

## Testing

- Yes, I have followed a test-driven approach :

    - While developing the model, I had written down several inputs to check different edge cases. So after every iteration of developing the model, I manually ran all those test cases to check my test cases. Later, I also implemented these as Unit test cases in my project. This approach was helpful but it has the downside that it slows down the development process.

    - <strong> Stress Testing using Monkey : </strong> Yes I used the monkey tool to stress test my app. I started with 500 actions and gradually increased it until 5000 and the "monkey" did not report an error or crash any of the time. So my app has been stress tested as well.

## Accessibility


## Time Taken

- It took me roughly 15 hours to finish the assignment. Developing the model and Integrating the UI took roughly 6 hours, while the majority of my time was spent in learning how to use Mockito for implementing my Unit test cases.

- I also spent a considerable amount of time trying to implement [Material Component](https://material.io/components) UI to enhance user experience but It was generating a lot of issues while implementing it so I was unable to do so in this project.
## Difficulty Rating

- I would rate this assignment as a <strong>7/10</strong> where 10 being the most difficult. The major issues I faced were of implementing the UI and learning how to use ConstraintLayout as this layout would have been much easier to do if it was a LinearLayout. 

- I also had to learn about Mockito, which further added to the complexity of the assignment.

## Credits

I have used the following websites during the development process:

- [Accessibility](https://material.io/design/usability/accessibility.html#understanding-accessibility)
- [Material Components](https://material.io/components)
- [Toast Documentation](https://developer.android.com/guide/topics/ui/notifiers/toasts)
- [Mockito](https://site.mockito.org/)

