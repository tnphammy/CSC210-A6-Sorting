import java.util.ArrayDeque;

/**
 *  Program sorts cards using Merge Sort, omitting graphics
 */
public class MergeSortTimer {

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

  /** Program sorts cards using MergeSort */
  public static CardPile sort(CardPile unsorted) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    // ***********************************************************

    // Make each card its own pile
    for (Card card : unsorted) {
      // Make a pile
      CardPile oneCard = new CardPile();
      // Add singular card to pile
      oneCard.add(card);
      // Add pile to queue
      queue.add(oneCard);
    }

    // Merge Sort body
    while (queue.size() > 1) {
      // Merge first 2 lists
      CardPile listOne = queue.remove();
      CardPile listTwo = queue.remove();
      // 1. Compare and sort
      CardPile merged = new CardPile();
      // Continue comparing until either list is empty
      while (listOne.peek() != null && listTwo.peek() != null) {
        Card a = listOne.peek();
        Card b = listTwo.peek();
        // Compare first elements
        if (a.compareTo(b) < 0) {
          merged.add(listOne.remove());
        }
        else {
          merged.add(listTwo.remove());
        }
      }
      // 2. When either list is empty
      if (listOne.peek() == null && listTwo.peek() != null) {
        merged.addAll(listTwo);
      }
      else if (listTwo.peek() == null && listOne.peek() != null) {
        merged.addAll(listOne);
      }
      // 3. Add merged list to the queue
      queue.add(merged);
    }
    // return the sorted result here
    return queue.remove();
  }
}


