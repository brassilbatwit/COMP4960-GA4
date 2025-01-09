# COMP4960-GA4

Group 3
Instructions:

You will make a simple text adventure collaboratively using java with your existing intro group team of around 4 to 5 people. 
See  COMP4960 - Lab - Text-adventure-1__0x08 for inspiration.

The goal is to let the user explore rooms / environments / worlds / areas I through IV.

You may decide what it means to exit / win / quit, but it must be clear to the user what the objective is and how to quit.
The player may explore within each area freely as you decide, but is only able to move between cardinally adjacent areas (no diagonal movement).

The team leader should start the primary class and area 1. Divide up areas 2, 3, and 4 fairly. Each team member should be responsible for at least one class.

To finish the assignment, please submit the code, any documentation, and if you can, the jar.


A Possible structure:
1. Start with a Java project.
2. Create a main class and 4 different classes named I, II, II, and IV.
3. In each of the named classed, have the constructor take a Scanner object and have a method called enter().
4. The enter() method should have the form `public int enter(Scanner s, ArrayList<String> arr)`.
5. In enter(), the `s` is to be used to get instructions and events from the game.
6. If enter() returns a negative, that means it is time to exit the game.
7. If there has been a selection to a new area, append that to the end of `arr` and return the new area number.
8. Newgame+: Save when the player wins and use that to offer a different play-through when detected on start.
   (You can decide how that works - an example might be a character says "You look familiar..." or something completely different.)
9. Newgame++: Add a save feature so you can stop and reload at any point. Add some ASCII Art!

Room Scheme
I	  II

IV   III



# Salad Maker
Each room is a type of garden and they have different things in them.
Brendan is working room 1
Dalton is working room 2 with salad
Tyler is working room 3
Cole is working room 4

