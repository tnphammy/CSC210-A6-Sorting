import java.util.ListIterator;

/**
 *  Program sorts cards using InsertionSort, omitting graphics

 */
public class InsertionSortTimer {

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
  /** Program sorts cards using InsertionSort */
  public static CardPile sort(CardPile unsorted) {
    

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************
    while (unsorted.size() > 0) {
      // Get the first element and its Iterator
      ListIterator<Card> beginning = unsorted.listIterator();
      Card first = beginning.next();

      // Make Iterators in sorted list
      ListIterator<Card> compareIt = sorted.listIterator();
      ListIterator<Card> addIt = sorted.listIterator();
      // Find its placement in the sorted list
      while (compareIt.hasNext()) {
        // Get next element for comparison
        Card second = compareIt.next();
        // Find the place where 'first' is smaller than its next element in sorted
        if (first.compareTo(second) > 0) {
          addIt.next(); // advances add position
        }
      }
      // Add it to sorted list
      addIt.add(first);
      // Remove it from unsorted list
      beginning.remove();
    }
    // return the sorted result here
    return sorted;
  }
}


