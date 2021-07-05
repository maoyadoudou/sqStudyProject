package auctionsniper;

public class SniperStateOld {
    public final String itemId;
    public final int lastPrice;
    public final int lastBid;

    public SniperStateOld(String itemId, int lastPrice, int lastBid) {
        this.itemId = itemId;
        this.lastPrice = lastPrice;
        this.lastBid = lastBid;
    }
}
