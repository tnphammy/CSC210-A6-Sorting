import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

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
        System.out.println("SECOND: " + second);
        // Find the place where 'first' is smaller than its next element in sorted
        while (first.compareTo(second) > 0) {
          System.out.println("FIRST: " + first);
          addIt.next(); // keep advancing if 'first' is still too big
        }
      }
      // Add it to sorted list
      addIt.add(first);
      System.out.println("SORTED: " + sorted);
      // Remove it from unsorted list
      beginning.remove();
      // Update graphics
      record.next(); // tell it this is a new step
      record.add(sorted); // the allegedly sorted pile
      record.add(unsorted); // the unsorted pile
    }
    // return the sorted result here
    return sorted;
  }

  public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: InsertionSort");
  }
}
