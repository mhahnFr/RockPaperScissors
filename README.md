# Welcome to RockPaperScissors!
This repository contains a small Android app that I wrote in 2015. It is about
the very popular game Rock-Paper-Scissors.

## The game
The game itself is very simple: you can choose one of the three possible items,
either the rock, the paper or the scissors. Each one can beat another item and
is beaten by the other one. If the two players take the same item, the game is
a draw.

 - The scissors beat the paper, as it cuts it; they are beaten by the stone.
 - The paper beats the stone, as it envelopes it, and is beaten by the
   scissors.
 - The rock beats the scissors, and is beaten by the paper.

The two players secretly choose one item, and show their choice to each other
at the same time. Then, they can see who has won.

## The idea
The idea was to play this game alone against the computer, which would choose
an item randomly. In 2013, this game was the first project that I did, so I had
the idea to implement it as my first Android app.

## GUI design
The design is quite simple, there are two pictures showing the choice of the
user and the computer, above it one can find a text label showing who has won,
underneath the pictures are the three buttons showing the choosable items, from
which the user can choose. In the menu, the stats of the game can be displayed.

## Approach
After creating the view from the appopriate XML file, a click listener is added
to each button. Each listener calls the game logic class with the choice of the
user and the win and loose possibilities. It will then set the picture of the
user to the appopriate one. After that, the function to display the choice of
the computer and the winner is called.

The function to display the winner sets the picture of the computer to the
appopriate one, after that it displays the corresponding string of the game
status from the localization file.

The game logic class is responsible of managing the statistics and the choices
of the players. It can generate the choice of the computer and choose upon the
given possibilities the winner.

The stats of the are simply displayed in its own activity, the are simply
written on the screen.

### Additions
In 2016, I added some advertisements for learning purposes. A small banner is
shown at the bottom of the main game view, an interstitial advertisement is
shown before showing the statistics of the game.

© 2015 [mhahnFr](https://www.github.com/mhahnFr)
