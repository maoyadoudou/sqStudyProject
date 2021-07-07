package auctionsniper.xmpp;

import auctionsniper.Auction;
import auctionsniper.AuctionHouse;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class XMPPAuctionHouse implements AuctionHouse {
    private static final String LOGGER_NAME = "auction-sniper";
    public static final String LOG_FILE_NAME = "auction-sniper.log";
    public static final String ITEM_ID_AS_LOGIN = "auction-%s";
    public static final String AUCTION_ID_FORMAT = ITEM_ID_AS_LOGIN + "@%s/" + XMPPAuctionHouse.AUCTION_RESOURCE;
    public static final String AUCTION_RESOURCE = "Auction";

    private final XMPPConnection connection;

    public XMPPAuctionHouse(XMPPConnection connection) {
        this.connection = connection;
    }

    public static XMPPAuctionHouse connect(String hostname, String username, String password) throws XMPPAuctionException {
        XMPPConnection connection = new XMPPConnection(hostname);
        try {
            connection.connect();
            connection.login(username, password, AUCTION_RESOURCE);
            return new XMPPAuctionHouse(connection);
        } catch (XMPPException e) {
            throw new XMPPAuctionException("Could not connect to auction: " + connection, e);
        }
    }

    @Override
    public Auction auctionFor(String itemId) {
        return new XMPPAuction(connection, itemId);
    }


    public void disconnect() {
        connection.disconnect();
    }
}
