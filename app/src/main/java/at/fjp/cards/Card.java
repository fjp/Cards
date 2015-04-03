package at.fjp.cards;

/**
 * Created by fjp on 03.04.15.
 */
public class Card {

    private int mCardIndex;
    private String mCardName;
    private String mCardImageUrl;
    private boolean mCardDrawn;

    Card(int cardIndex, String cardName, String imageUrl) {
        mCardIndex = cardIndex;
        mCardName = cardName;
        mCardImageUrl = imageUrl;
        mCardDrawn = false;
    }

    public void setCardDrawn(boolean cardDrawn) {
        mCardDrawn = cardDrawn;
    }

    public boolean getCardDrawn() {
        return mCardDrawn;
    }

    public int getCardIndex() {
        return mCardIndex;
    }

    public String getCardName() {
        return mCardName;
    }

    public String getCardImageUrl() {
        return mCardImageUrl;
    }

}
