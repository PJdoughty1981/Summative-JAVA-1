// Imported utils --------------------------------------------------------------

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


//----------------- Movie Class ------------------------------------------------
public class Movie implements Comparable<Movie> {

// Longest Title. Question  5 --------------------------------------------------
public static String longestTitle = "";
// Year sort code. Question 6 --------------------------------------------------
public static int oldestYear;
public static int newestYear;
// Movie Layout data type setup ------------------------------------------------
private final String title;
private final int year;
private final String rating;
private final String genre;
private final int runtime;
private final double score;

//Movie Constructor ------------------------------------------------------------
public Movie(String title, int year, String rating, String genre,
             int runtime, double score) {
   this.title = title;
   this.year = year;
   this.rating = rating;
   this.genre = genre;
   this.runtime = runtime;
   this.score = score;
}

// Movie with the longest runtime first. Question  2 ---------------------------
public static ArrayList<Movie> runtimeSort(ArrayList<Movie> sortingList) {
   // Sorting and printing the Movies in duration order.
   sortingList.sort(Comparator.comparing
      (Movie::getRuntime).thenComparing(Movie::getRuntime));
   // Reverse the sorted collection to satisfy question 1, (longest duration)
   Collections.reverse(sortingList);

   return sortingList;
}

// Lowest rated SciFi Movie. Question  3 ---------------------------------------
public static Movie sciFiSort(ArrayList<Movie> sortedSciFiList) {
   ArrayList<Movie> sciFiList = new ArrayList<>();
   // for a movie in the movie list check if the genre == "Sci-Fi"
   for (Movie movie : sortedSciFiList)
   {
      if (movie.getGenre().contains("Sci-Fi"))
      {
         // add it to sciFiList
         sciFiList.add(movie);
      }
   }
   // Sort the list using the Comparator in Movie.java
   sciFiList.sort(Comparator.comparing
      (Movie::getScore).thenComparing(Movie::getScore));

   return sciFiList.get(0);
}

// Fifth most recent PG Movie. Question  4 -------------------------------------
public static Movie PGSort(ArrayList<Movie> sortedPGList) {
   ArrayList<Movie> PGList = new ArrayList<>();
   // for a movie in the movie list check if the genre == "Sci-Fi"
   for (Movie movie : sortedPGList)
   {
      // for a movie in the movie list check if the rating == "PG"
      // I could have done a getGenre comparison and moved to a list
      // But wanted to show another way for knowledge and variety.
      if (movie.getRating().contains("PG"))
      {
         // add it to ratingList
         PGList.add(movie);
      }
   }
   //This is just an easy way to whittle down to only "PG" movies left
   PGList.removeIf(movie -> movie.getRating().contains("-"));
   // Sort the list using the Comparator in Movie
   PGList.sort(Comparator.comparing
      (Movie::getYear).thenComparing(Movie::getYear));
   // want the newest first.
   Collections.reverse(PGList);
   // returning the 5th entry including 0
   return PGList.get(4);
}

public static Movie longestTitleSort(ArrayList<Movie> sortedTitleList) {
   ArrayList<Movie> titleList = new ArrayList<>();
   // for a movie in the movie list
   for (Movie movie : sortedTitleList)
   {
      // get the title from MovieDatabase
      String title = movie.getTitle();
      // compare length to the local variable longestTitle
      // and replace if needed.
      if (title.length() > longestTitle.length())
      {
         longestTitle = title;
         titleList.add(movie);
      }
   }
   titleList.sort(Comparator.comparing
      (Movie::getTitle).thenComparing(Movie::getTitle));

   return titleList.get(0);
}

public static int yearsSort(ArrayList<Movie> sortedYearList) {
   // Sort for the min year
   oldestYear = Collections.min(sortedYearList, Comparator.comparing
      (Movie -> Movie.getYear())).getYear();
   // Sort for the max year
   newestYear = Collections.max(sortedYearList, Comparator.comparing
      (Movie -> Movie.getYear())).getYear();
   // calculate the number of years in the return

   return newestYear - oldestYear;
}

// Movie Getters Collection ----------------------------------------------------
public String getTitle() {
   return title;
}

public int getYear() {
   return year;
}

public String getRating() {
   return rating;
}

public String getGenre() {
   return genre;
}

public int getRuntime() {
   return runtime;
}

public double getScore() {
   return score;
}

// To String method: Title, Year, Rating, Genre, Runtime, ImDb Score -----------
// Would be coloured for visual appeal but PASS won't accept colours
public String toString() {
   return
      "\n Title " + title
         + "\n : Year " + year
         + "\n : Rating " + rating
         + "\n : Genre " + genre
         + "\n : Runtime " + runtime + " minutes"
         + "\n : ImDb Score " + score + "\n";
}

// this compareTo will compare a movie to another movie, default runtime--------
@Override
public int compareTo(Movie other) {
   // compare by any of the Movie getters
   return this.runtime - other.runtime;
   }
}
//--------------------- END OF MOVIE CLASS CODE --------------------------------



