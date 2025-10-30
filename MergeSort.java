import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
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
      record.next(); // tell it this is a new step
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }
    }
    // return the sorted result here
    return queue.remove();
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
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}
