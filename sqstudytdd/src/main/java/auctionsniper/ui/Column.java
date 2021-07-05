package auctionsniper.ui;

import auctionsniper.SniperSnapshot;

import java.util.Objects;

public enum Column {
    ITEM_IDENTIFIER("Item") {
        @Override
        public Object valueIn(SniperSnapshot snapshot) {
            return snapshot.itemId;
        }
    },
    LAST_PRICE("Last Price") {
        @Override
        public Object valueIn(SniperSnapshot snapshot) {
            return Objects.nonNull(snapshot) ? snapshot.lastPrice : 0;
        }
    },
    LAST_BID("Last Bid") {
        @Override
        public Object valueIn(SniperSnapshot snapshot) {
            return Objects.nonNull(snapshot) ? snapshot.lastBid : 0;
        }
    },
    SNIPER_STATE("State") {
        @Override
        public Object valueIn(SniperSnapshot snapshot) {
            return Objects.nonNull(snapshot) ? SnipersTableModel.textFor(snapshot.state) : "Lost";
        }
    };

    public final String name;

    private Column(String name) {
        this.name = name;
    }

    public abstract Object valueIn(SniperSnapshot snapshot);
    public static Column at(int offset) {
        return values()[offset];
    }
}
