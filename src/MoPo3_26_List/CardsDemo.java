package MoPo3_26_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsDemo {
    public static final String[] suits = {"♠","♣","♥","♦"};
    //创建一副牌;
    private static List<Cards> buyDeck(){
        List<Cards> Deck = new ArrayList<>(52);
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <14; j++) {
                Cards cards = new Cards();
                cards.rank = j;
                cards.suit = suits[i];
                Deck.add(cards);
            }
        }
        return Deck;
    }
    private static void swap(List<Cards> Deck,int i,int j){
        Cards tmp = Deck.get(i);
        Deck.set(i,Deck.get(j));
        Deck.set(j,tmp);
    }
    private static void shuffle(List<Cards> Deck){
        Random random = new Random(System.nanoTime());
        for (int i = Deck.size()-1; i > 0 ; i--) {
            int r = random.nextInt(i);
            swap(Deck,i,r);
        }
    }

    public static void main(String[] args) {
        List<Cards> deck = buyDeck();
        System.out.println("一副新牌");
        System.out.println(deck);
        System.out.println("洗过的牌");
        shuffle(deck);
        System.out.println(deck);
    }
}
