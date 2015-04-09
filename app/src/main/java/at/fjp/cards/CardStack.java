package at.fjp.cards;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by fjp on 03.04.15.
 */
public class CardStack {

    private static final String LOG_TAG = CardStack.class.getSimpleName();

    private int mCardStack;
    public static final int JASS_KARTEN = 0;
    public static final int POKER_KARTEN = 1;




    public Map<Integer,String> mCardMap = new HashMap<Integer,String>();
    private ArrayList<Card> mCardArray;
    private String[] mCardImageUrls;

    private int mNumOfCards;
    private int mCardCount;
    private boolean mCardStackEmpty;

    private void fillCardMap(int cardStack) {
        switch (cardStack) {
            case JASS_KARTEN:
                mCardMap.put(0, "Herz Sechs");
                mCardMap.put(1, "Herz Sieben");
                mCardMap.put(2, "Herz Acht");
                mCardMap.put(3, "Herz Neun");
                mCardMap.put(4, "Herz Zehn");
                mCardMap.put(5, "Herz Unter");
                mCardMap.put(6, "Herz Ober");
                mCardMap.put(7, "Herz König");
                mCardMap.put(8, "Herz Ass");

                mCardMap.put(9, "Laub Sechs");
                mCardMap.put(10, "Laub Sieben");
                mCardMap.put(11, "Laub Acht");
                mCardMap.put(12, "Laub Neun");
                mCardMap.put(13, "Laub Zehn");
                mCardMap.put(14, "Laub Unter");
                mCardMap.put(15, "Laub Ober");
                mCardMap.put(16, "Laub König");
                mCardMap.put(17, "Laub Ass");

                mCardMap.put(18, "Eichel Sechs");
                mCardMap.put(19, "Eichel Sieben");
                mCardMap.put(20, "Eichel Acht");
                mCardMap.put(21, "Eichel Neun");
                mCardMap.put(22, "Eichel Zehn");
                mCardMap.put(23, "Eichel Unter");
                mCardMap.put(24, "Eichel Ober");
                mCardMap.put(25, "Eichel König");
                mCardMap.put(26, "Eichel Ass");

                mCardMap.put(27, "Weli");
                mCardMap.put(28, "Shell Sieben");
                mCardMap.put(29, "Shell Acht");
                mCardMap.put(30, "Shell Neun");
                mCardMap.put(31, "Shell Zehn");
                mCardMap.put(32, "Shell Unter");
                mCardMap.put(33, "Shell Ober");
                mCardMap.put(34, "Shell König");
                mCardMap.put(35, "Shell Ass");
                break;

            case POKER_KARTEN:

                break;

            default:

                break;
        }

        mNumOfCards = mCardMap.size();
    }

    CardStack(int cardStack) {
        switch (cardStack) {
            case JASS_KARTEN:
                mCardStack = JASS_KARTEN;
                fillCardMap(mCardStack);
                mCardArray = new ArrayList<>(mCardCount);
                mCardImageUrls = Images.JassCardsImageUrls;
                break;
            case POKER_KARTEN:
                mCardStack = POKER_KARTEN;
                break;
            default:
                mCardStack = -1;
                break;
        }

        mCardCount = 0;
        initializeCards();
        mCardStackEmpty = false;
    }


    private void initializeCards() {
        for (int i = 0; i < mNumOfCards; i++) {
            int cardIndex = i;
            String cardName = mCardMap.get(cardIndex);
            String cardImageUrl = mCardImageUrls[cardIndex];
            Card card = new Card(cardIndex, cardName, cardImageUrl);
            mCardArray.add(cardIndex, card);
        }
    }

    private int getRandomCardIndex() {
        Random r = new Random();
        return r.nextInt(mNumOfCards);
    }

    private Card getCard(int cardIndex) {
        Log.v(LOG_TAG, "cardIndex " + cardIndex);
        return mCardArray.get(cardIndex);
    }


    private Card getNextCard() {
        Card card;
        boolean cardDrawn;



        do {
            int cardIndex = getRandomCardIndex();
            card = getCard(cardIndex);
            cardDrawn = card.getCardDrawn();
            Log.v(LOG_TAG, "do while card Drawn " + cardDrawn);
        } while (cardDrawn == true && mCardCount < mNumOfCards);

        mCardCount++;
        card.setCardDrawn(true);

        Log.v(LOG_TAG, "getNextCard" +
                "\n Card Index: " + card.getCardIndex() +
                "\n Card Name: " + card.getCardName() +
                "\n Card Drawn: " + card.getCardDrawn());

        if (mCardCount == mNumOfCards) {
            mCardStackEmpty = true;
            Log.v(LOG_TAG, "Card Stack Empty");
        }

        Log.v(LOG_TAG, "CardCount " + mCardCount);

        return card;
    }

    public String getNextCardImageUrl() {
        Card card = getNextCard();
        return card.getCardImageUrl();
    }

    public boolean empty() {
        return mCardStackEmpty;
    }
}
