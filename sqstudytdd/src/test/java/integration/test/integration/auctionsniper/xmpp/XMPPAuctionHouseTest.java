package integration.test.integration.auctionsniper.xmpp;

import auctionsniper.Auction;
import auctionsniper.AuctionEventListener;
import auctionsniper.xmpp.XMPPAuction;
import endtoend.test.endtoend.auctionsniper.ApplicationRunner;
import endtoend.test.endtoend.auctionsniper.FakeAuctionServer;
import org.hamcrest.text.X;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static endtoend.test.endtoend.auctionsniper.ApplicationRunner.SNIPER_ID;
import static endtoend.test.endtoend.auctionsniper.ApplicationRunner.SNIPER_PASSWORD;
import static endtoend.test.endtoend.auctionsniper.FakeAuctionServer.AUCTION_RESOURCE;
import static endtoend.test.endtoend.auctionsniper.FakeAuctionServer.XMPP_HOSTNAME;
import static org.junit.Assert.assertTrue;

public class XMPPAuctionHouseTest {
    private XMPPConnection connection;
    private FakeAuctionServer auctionServer = new FakeAuctionServer("item-54321");

    @Before
    public void openConnection() throws XMPPException {
        this.connection = new XMPPConnection(XMPP_HOSTNAME);
        connection.connect();
        connection.login(SNIPER_ID, SNIPER_PASSWORD, AUCTION_RESOURCE);
    }

    @After
    public void closeConnection() {
        if (connection != null) {
            connection.disconnect();
        }
    }

    @Before
    public void startAuction() throws XMPPException {
        auctionServer.startSellingItem();
    }

    @After
    public void stopAuction() {
        auctionServer.stop();
    }




    @Test
    public void receivesEventsFromAuctionServerAfterJoining() throws InterruptedException, XMPPException {
        CountDownLatch auctionWasClosed = new CountDownLatch(1);
        Auction auction = new XMPPAuction(connection, auctionServer.getItemId());
        auction.addAuctionEventListener(auctionClosedListener(auctionWasClosed));
        auction.join();
        auctionServer.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auctionServer.announceClosed();
        assertTrue("should have been closed", auctionWasClosed.await(2, TimeUnit.SECONDS));
    }

    private AuctionEventListener auctionClosedListener(final CountDownLatch auctionWasClosed) {
        return new AuctionEventListener() {
            @Override
            public void auctionClosed() {
                auctionWasClosed.countDown();
            }

            @Override
            public void currentPrice(int price, int increment, PriceSource fromOtherBidder) {

            }
        };
    }
}
