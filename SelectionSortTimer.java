import java.util.ListIterator;
/**
 *  Program sorts cards using Selection Sort, omitting graphics
 */
public class SelectionSortTimer {

  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
  }
  /** Program sorts cards using SelectionSort */
  public static CardPile sort(CardPile unsorted) {
    

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"

    // ***********************************************************
    

    // Sorting Algorithm
    // Perform procedure to each element of unsorted
    while (unsorted.size() > 0) {
      // Assign the next Iterator position
      ListIterator<Card> compareIt = unsorted.listIterator();
      ListIterator<Card> minIt = unsorted.listIterator();
      // The comparison procedure - until the end of pile
      Card tempMin = minIt.next();
      while(compareIt.hasNext()) {
        // Get "next" element for comparison
        Card second = compareIt.next();
        // Comparison:
        if (tempMin.compareTo(second) > 0) {
          // Update min card and iterator
          tempMin = second;
          while(minIt.next() != second) {
            // Loop until minIt is the same as compareIt (but a deep copy)
          }
        }
        else {
        }
      }
      // Found min 
      // Add min to sorted
      sorted.add(tempMin);
      // Remove min from unsorted using minIt
      minIt.remove();
    }

    // return the sorted result here
    return sorted;
  }
}


