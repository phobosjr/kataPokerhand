import model.Hand;
import service.PokerHandsService;

public class Main {

    public static void main(String[] args) {


        Hand hand1;
        Hand hand2;

        hand1 = new Hand("2H 3D 5S 9C KD", "Black");
        hand2 = new Hand("2C 3H 4S 8C AH", "White");
        System.out.println(PokerHandsService.compareHands(hand1, hand2));


        hand1 = new Hand("2H 4S 4C 2D 4H", "Black");
        hand2 = new Hand("2S 8S AS QS 3S", "White");
        System.out.println(PokerHandsService.compareHands(hand1, hand2));

        hand1 = new Hand("2H 3D 5S 9C KD", "Black");
        hand2 = new Hand("2C 3H 4S 8C KH", "White");
        System.out.println(PokerHandsService.compareHands(hand1, hand2));

        hand1 = new Hand("2H 3D 5S 9C KD", "Black");
        hand2 = new Hand("2D 3H 5C 9S KH", "White");
        System.out.println(PokerHandsService.compareHands(hand1, hand2));


    }
}
