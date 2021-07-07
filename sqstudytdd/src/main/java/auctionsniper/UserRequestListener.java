package auctionsniper;

import java.util.EventListener;

public interface UserRequestListener extends EventListener {
    void joinAuction(Item item);

    public static class Item {
        public final String identifier;
        public final int stopPrice;

        public Item(String identifier, int stopPrice) {
            this.identifier = identifier;
            this.stopPrice = stopPrice;
        }

        public boolean allowsBid(int bid) {
            return bid <= stopPrice;
        }

        @Override
        public String toString() { return "Item: " + identifier + ", stop price: " + stopPrice; }

    }


}
