package com.company;

import java.util.Random;

class card {
        // The reason for both suit and value being numbers is to maitain fast execution with high levels of comparisons
        public int value; //the value is the cards over strength as wells as number for 2-10 and with Jack-Ace being 11-14
        public int suit; // 0 - Clubs, 1 - Diamonds, 2 - Spades, 3 - Hearts
        public String verbose_value;
        public String verbose_suit;
        public card(int card_value, int card_suit){
            value = card_value;
            suit = card_suit;
            if (card_value <= 10)
                verbose_value = String.valueOf(card_value);
            if(card_value>10){
                switch (card_value) {
                    case 11:
                        verbose_value = "Jack";
                        break;
                    case 12:
                        verbose_value = "Queen";
                        break;
                    case 13:
                        verbose_value = "King";
                        break;
                    case 14:
                        verbose_value = "Ace";
                        break;
                    default:
                        verbose_value = "Undefined";
                        break;
                }

            }
            switch (card_suit) {
                case 0:
                    verbose_suit="Clubs";
                    break;
                case 1:
                    verbose_suit="Diamonds";
                    break;
                case 2:
                    verbose_suit="Spades";
                    break;
                case 3:
                    verbose_suit="Hearts";
                    break;
                default:
                    verbose_suit = "Undefined";
                    break;
            }
        }
    }
    class deck {
        public card[] cards = new card[52];
        public int current_card = 0;

        public deck() {
            int iter = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 2; j < 15; j++) {
                    cards[iter] = new card(j, i);
                    iter++;
                }
        }
        public void shuffle(){
            Random rnum = new Random();
            for(int i=0;i<1000;i++){
                int x = rnum.nextInt(52);
                int y = rnum.nextInt(52);
                card temp = cards[x];
                cards[x] = cards[y];
                cards[y] = temp;
            }
        }
        public void printDeck(){
            for (com.company.card card : cards) {
                System.out.println(card.verbose_value + " Of " + card.verbose_suit);
            }
        }
        public card[] draw(int num_of_cards){
            card[] drawArr = new card[52];
            for(int i=0; i<num_of_cards; i++){
                if(current_card < 52){
                    drawArr[i] = cards[current_card];
                    current_card++;
                } else {
                    break;
                }
            }
            return drawArr;
        }
    }

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello!");
        deck testdeck = new deck();
        testdeck.printDeck();
//        System.out.println("---- Deck ----");
//        testdeck.shuffle();
//        testdeck.printDeck();

        card[] hand = testdeck.draw(5);
    }
}
