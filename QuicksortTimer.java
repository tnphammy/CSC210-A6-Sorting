/**
 *  Program sorts cards using Quick Sort, omitting graphics
 */
public class QuicksortTimer {

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
  /** Program sorts cards using Quicksort */
  public static CardPile sort(CardPile unsorted) {

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
  
    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    // call mergeSort on `smaller` and `bigger`
    CardPile pre = sort(smaller);
    CardPile post = sort(bigger);
    result.addAll(pre);
    result.add(pivot);
    result.addAll(post);
    
    // return the sorted result here
    return result;
  }
}


