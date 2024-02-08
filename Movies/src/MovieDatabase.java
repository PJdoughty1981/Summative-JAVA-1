//-----------------Import utils ------------------------------------------------
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

//-----------------MovieDatabase Code ------------------------------------------
public class MovieDatabase {

  //Method Arraylist of Movie Objects
   public static ArrayList<Movie> readMovies(){
   //Create an ArrayList to store the Movies
    var movieList = new ArrayList<Movie>();

   //Create a Scanner to read the file
   try {
      Scanner scan = new Scanner(new File("movies.txt"));

      //Loop through the file and add each line to the list
      while (scan.hasNextLine()) {
         //Scan the next line to a String
         String line = scan.nextLine();
         //use the method getMovieInfo to iterate through each line
         ArrayList<Object> data = getMovieInfo(line);
         //Create a Movie object with the Data/Int/Data/Data/Int/Double layout.
         Movie movie = new Movie(
            data.get(0).toString(),
            Integer.parseInt(String.valueOf(data.get(1))),
            data.get(2).toString(),
            data.get(3).toString(),
            Integer.parseInt(String.valueOf(data.get(4))),
            Double.parseDouble(String.valueOf(data.get(5))));
         //Add the movie to the movieList Array.
         movieList.add(movie);
         }
      //Close the scanner.
      scan.close();

   // Catch file not found exception & number format exception.
   } catch (FileNotFoundException e)
   {
      System.err.println("Error Movies.txt file not found: 'movies.txt' ");
      System.out.println("File not found!");

   } catch (NumberFormatException e){
      System.err.println("Number Format Exception: " + e.getMessage());
   } catch (Exception e) {
         System.out.println("Exception thrown: Scan Skip not found. " + e);
   }

   // Return the completed movieList.
      return movieList;
   }
//---- Method to sort through each line and skip commas inside quotations
   private static ArrayList<Object> getMovieInfo(String line) {
      ArrayList<Object> data = new ArrayList<>();
      //set starting int at 0
      int movieInfo = 0;
      //create boolean for commas inside quotes
      boolean insideQuotes = false;
      //iterate through each character in the string and check for quotes
      for (int i = 0; i < line.length(); i++){
         if (line.charAt(i) == '\"'){
            insideQuotes = !insideQuotes;
            //when a comma is found add the substring between the start of the
            //movie info and the next comma to the data list
         } else if (line.charAt(i) == ',' && !insideQuotes) {
            data.add(line.substring(movieInfo, i));
            movieInfo = i + 1;
         }
      }
      data.add(line.substring(movieInfo));
      //return the data item for use in the movie list
      return data;
   }
//-------------------- END of MovieDatabase code -------------------------------



//-------------------- TEST HARNESS & initial method development ---------------
   public static void TEST(){
      //------------ list files in the working DIR -----------------------------
      File path = new File(".");
      String[] DIRList = path.list();
      System.out.println("Current Working DIR contents: \n");
      assert DIRList != null;
      for (String s : DIRList)
      {
         System.out.println(s);
      }
      System.out.println("\n*************************************************");
      System.out.println("Does the working DIR contain movies.txt?: \n");
      if (Arrays.toString(DIRList).contains("movies.txt"))
      {
         System.out.println("movie.txt is in working DIR. PASS! ");
      } else
      {
         System.out.println("movie.txt is not in working DIR. FAIL! ");
      }
      System.out.println("***************************************************");
      //---- TEST the testMovieList is being created properly to known size -
      // Visual and other associated tests with Movie attached.
      List<Movie> testMovieList = MovieDatabase.readMovies();
      if (testMovieList.size() == 248)
      {
         System.out.println("Movie List Size Test PASSED! ");
         System.out.println("Movie List Read from movies.txt PASSED! ");
         System.out.println("MovieDatabase function PASSED! ");
         System.out.println("Movie Constructor Test PASSED! ");
         System.out.println(testMovieList.get(0));
         System.out.println("Movie toString return for visual assessment. ");
      } else
      {
         System.out.println("Movie List Size, and associated methods" +
            " Test FAIL! ");
      }
      //---- TEST the testMovieList sorted into the known longest runtime
      testMovieList.sort(Comparator.comparing
         (Movie::getRuntime).thenComparing(Movie::getRuntime));
         Collections.reverse(testMovieList);
      if (testMovieList.get(0).getTitle().equals("\"Gangs of Wasseypur\""))
      {
         System.out.println("Movie Runtime Test PASSED! ");
         System.out.println("Get Runtime Test PASSED! ");
      } else
      {
         System.out.println("Movie Runtime Test FAIL! ");
      }
//------------------------------------------------------------------------------
      //---- TEST the List can be sorted into the Known SciFi lowest score
      List<Movie> testSciFiList = new ArrayList<>();
      for (Movie movie : testMovieList)
      {
         if (movie.getGenre().contains("Sci-Fi"))
         {
            // add it to sciFiList
            testSciFiList.add(movie);
         }
      }
      testSciFiList.sort(Comparator.comparing
         (Movie::getScore).thenComparing(Movie::getScore));

      if (testSciFiList.get(0).getTitle().equals("\"Sharknado\""))
      {
         System.out.println("Movie SciFi Sort Test PASSED! ");
         System.out.println("Get Score Test PASSED! ");
      } else
      {
         System.out.println("Movie SciFi Sort Test FAIL! ");
      }
//------------------------------------------------------------------------------
      //---- TEST the list can be sorted into PG by known value
      List<Movie> testPGList = new ArrayList<>();
      for (Movie movie : testMovieList)
      {
         // for a movie in the movie list check if the rating == "PG"
         if (movie.getRating().contains("PG"))
         {
            // add it to ratingList
            testPGList.add(movie);
         }
      }
      testPGList.removeIf(movie -> movie.getRating().contains("-"));
      // Sort the list using the Comparator in Movie
      testPGList.sort(Comparator.comparing
         (Movie::getYear).thenComparing(Movie::getYear));
      Collections.reverse(testPGList);

      if (testPGList.get(4).getTitle().equals("\"Up\""))
      {
         System.out.println("Movie PG Rating Sort Test PASSED! ");
         System.out.println("Get Year Test PASSED! ");
      } else
      {
         System.out.println("Movie PG Rating Sort Test FAIL! ");
      }
//------------------------------------------------------------------------------
      //---- TEST the longest title against known title.
      String testlongestTitle = "";
      ArrayList<Movie> testtitleList = new ArrayList<>();
      // for a movie in the movie list
      for (Movie movie : testMovieList){
         // get the title from MovieDatabase
         String title = movie.getTitle();
         // compare length to the local variable testlongestTitle
         // and replace if needed.
         if (title.length() > testlongestTitle.length()){
            testlongestTitle = title;
            testtitleList.add(movie);
         }
      }
      testtitleList.sort(Comparator.comparing
         (Movie::getTitle).thenComparing(Movie::getTitle));
      if (testtitleList.get(0).getTitle().equals("\"Dr. Strangelove or: How I "
         + "Learned to Stop Worrying and Love the Bomb\""))
      {
         System.out.println("Movie Title length Sort Test PASSED! ");
         System.out.println("Get Title Test PASSED! ");
      } else
      {
         System.out.println("Movie Title length Sort Test FAIL! ");
      }
//------------------------------------------------------------------------------
      //--- TEST find the years between old and new movies
      int testoldestYear;

      int testnewestYear;
      testoldestYear = Collections.min(testMovieList, Comparator.comparing
         (Movie->Movie.getYear())).getYear();
      // Sort for the max year
      testnewestYear = Collections.max(testMovieList, Comparator.comparing
         (Movie->Movie.getYear())).getYear();
      if (testnewestYear - testoldestYear == (95))
      {
         System.out.println("Movie Years between Test PASSED! ");
         System.out.println("Get Years Test PASSED! ");
      } else
      {
         System.out.println("Movie Years between Test FAIL! ");
      }
   }
//---------------------Main code TESTS -----------------------------------------

}
//------------------END OF MovieDatabase.java CODE -----------------------------
