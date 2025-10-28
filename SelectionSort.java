import java.util.Collections;
import java.util.ListIterator;

public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
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
    cards = SelectionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: SelectionSort");
  }
}
