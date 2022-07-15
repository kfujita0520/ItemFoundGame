# System Architecture

This is a role of each java class in this system.
1) Main  
  Starting point of system execution. Initialize GameController class and provide command-line interfaces to users. 

2) GameController  
  Validate input value and return appropriate message such as "Item is not found" or "A-rank item is found" to Interface. 
Also, record user input history during the game.

3) AllRanksItemSets  
  Data class generating initial ItemSet of each rank to follow the given definition 
and managing the operations related to those "ItemSet" and "Combination Pieces".

4) ItemSet  
  Data class stored item set of "combination" and "permutation" respectively.
  "combination" set is used when initially generating item set to avoid having duplicated combination item.

5) ItemUtils  
  Utility class providing the general useful function such as shuffling letter of String.

6) ItemLetter  
  Define a letter as constant variable to avoid hardcode typing.

# How to execute
Please execute Main class with Java.  
Verified working on JDK16



# Definition of Item Rank:
This defines the length and composition of letters for each rank item.
Except for "Combination Pieces", each item should have unique letter combination from others, 
in order to make sure that not causing any item duplication when reshuffle event occurs.  
- S Rank (10):  
  10 letter, including X and 2Y
- A Rank (20):  
  9,10 letter, including 2Y
- B Rank (30):  
  3-8 letter including 1Y 
- C Rank (50):  
  9,10 letter, only ABC
- D Rank (90):  
  3-8 letter, only ABC 
- Combination Pieces (10):  
  10 letter only ABC


## Reference
This is the reference material used for defining each rank above.
Considered the number of unique combination for given length of String in case compositing 3 common letters "A, B, C".  

10=> 12C10= 66  
9=> 11C9= 55  
8=> 10C8= 45  
7=> 9C7= 36  
6=> 8C6= 28  
5=> 7C5= 21  
4=> 6C4= 15  
3=> 5C3= 10  






