import java.util.Collections;

public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    if (unsorted.size() == 0) {
      return unsorted; // return the single element in list
    }
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  
    
    // Part the remaining elements into two list
    while (unsorted.size() > 0) {
      Card each = unsorted.removeFirst();
      if (each.compareTo(pivot) < 0) {
        smaller.add(each);
      }
      else {
        bigger.add(each);
      }
    }
  
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    // call mergeSort on `smaller` and `bigger`
    CardPile pre = sort(smaller, record);
    CardPile post = sort(bigger, record);
    result.addAll(pre);
    result.add(pivot);
    result.addAll(post);
    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }

  /** Starts the program running */
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
    cards = Quicksort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Quicksort");
  }
}
