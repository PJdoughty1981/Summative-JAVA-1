/*##############################################################################
#              ##   Student ID 100393011                                      ##
#  DOC String  ##   Student ID 100391845                                      ##
################################################################################
#  Code Date 30/11/2023  01:55AM                                              ##
################################################################################
#                                                                              #
# Main.java                file size 7.52 KB (7,708 bytes)                     #
# Contains: ( Main class with code to answer 6 questions )                     #
#                                                                              #
#                                                                              #
# MovieDatabase.java      file size 9.00 KB (9,220 bytes)                      #
# Contains: ( MovieDatabase Class with methods to read a txt file to data set  #
#            and output that set as a movieList), TEST HARNESS.                #
# Inputs:  Scanner movie.txt                                                   #
# Returns: movieList, data                                                     #
#                                                                              #
# Movie.java        file size 5.83 KB (5,980 bytes)                            #
# Contains: Constructor, DataTypes, CompareTo, Getters, toString,              #
# Returns: title,year,rating,runtime,genre,score, toString,                    #
# sortingList, sciFiList, PGList, titleList, oldestYear-newestYear.            #
# Overridable compareTo returning any data comparison                          #
#                                                                              #
################################################################################
# REFERENCES: learning material references ONLY no non standard code used.     #
#                                                                              #
# Constructors: Absolute Java, W Savitch, 3rd Ed, 2008 ,Page 216               #
# CompareTo: JAVA for students, Bell&Parr,6th Ed, 2010 ,Page 284               #
# ArrayLists: Absolute Java, W Savitch, 3rd Ed, 2008 ,Page 741-743             #
# Collections: Absolute Java, W Savitch, 3rd Ed, 2008 ,Page 882 & 890          #
#                                                                              #
######################### END OF DOC STRING ####################################
################################################################################
*/

//-------------------------- Main.java -----------------------------------------
//-------------------------- Import statements ---------------------------------
import java.util.ArrayList;

//--------------------------- Start of Main Class Code -------------------------
public class Main {
   //-------------------------- Main Args --------------------------------------
   public static void main(String[] args) {

      //Call the database and store in a local variable
      ArrayList<Movie> movieList = MovieDatabase.readMovies();
//-----------------------------TEST HARNESS-------------------------------------

      System.out.println(" ************************************************* ");
      System.out.println("TEST HARNESS OUTPUT (For current Movie Set ONLY):  ");
      MovieDatabase.TEST();
      System.out.println("****************** END OF TEST CHECKS *************");
      System.out.println("***************************************************");

// -----------------------------Question 1--------------------------------------
   // Printing the Database of movies and showing the size of the arrayList
      // created from MovieDatabase class.
      System.out.println("************************************************** ");
      System.out.println("** Question 1 Create a Movie Database **");
      System.out.println(" MovieDatabase printing size of movieList : ");
      // Print the total amount of movies in the ArrayList : movieList .
      System.out.println(" movieList has " + movieList.size() + " Movies");
      System.out.println(" ************************************************* ");

//----------------------------- Question 2 -------------------------------------

      System.out.println("***************************************************");
      System.out.println("* Question 2 Sort " +
         "into Duration *");

      System.out.println("Movies sorted into duration order (longest first): ");
      System.out.println("***************************************************");
      System.out.println(Movie.runtimeSort(movieList));
      System.out.println("***************************************************");

//----------------------------- Question 3 -------------------------------------
      // Display the lowest scored Sci-Fi movie.

      System.out.println("***************************************************");
      System.out.println("* Question 3 Lowest " +
         "rated Sci-Fi movie *");

      System.out.println("The lowest rated (Sci-Fi) movie is: ");
      //Print the movie

      System.out.println(Movie.sciFiSort(movieList));
      System.out.println("***************************************************");

//----------------------------- Question 4 -------------------------------------
      // Display the fifth most recent “PG” rated movie.
      System.out.println("***************************************************");
      System.out.println("* Question 4 fifth most recent PG Movie *");

      System.out.println("\n The 5th most recent (PG) movie is: ");
      //Print the movie
      System.out.println(Movie.PGSort(movieList));
      System.out.println("***************************************************");

//----------------------------- Question 5 -------------------------------------
      // Display the movie with the longest name.

      // Print the result and the length of the title
      System.out.println("***************************************************");
      System.out.println("* Question 5 Longest Titled movie *");
      // Print the longest title.
      System.out.println("\n The longest Movie Title is: "
         + Movie.longestTitleSort(movieList));
      // Print the length of the title.
      System.out.println("With a total of " + Movie.longestTitle.length()
         + " Characters including spaces");
      System.out.println("\n*************************************************");

//----------------------------- Question 6 -------------------------------------
      // Display the number of years separating the oldest movie and the newest.

      // Print the result
      System.out.println("***************************************************");
      System.out.println("* Question 6: Years between oldest and " +
         "newest Movie *");
      // using math.abs to remove the minus symbol from the int.
      System.out.println("\nThe number of years between the newest and " +
         // Math.abs used here to display a positive integer result.
         "oldest Movie: " + Math.abs(Movie.yearsSort(movieList)) + " Years");
      System.out.println("\nThe oldest movie is from " + Movie.oldestYear);
      System.out.println("The newest movie is from " + Movie.newestYear);
      System.out.println("***************************************************");

   }
}
//------------------------- End of Main.java -----------------------------------
