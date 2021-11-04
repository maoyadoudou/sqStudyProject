package integration.test.integration.auctionsniper.xmpp;

import auctionsniper.Auction;
import auctionsniper.AuctionEventListener;
import auctionsniper.Item;
import auctionsniper.xmpp.XMPPAuction;
import auctionsniper.xmpp.XMPPAuctionException;
import auctionsniper.xmpp.XMPPAuctionHouse;
import endtoend.test.endtoend.auctionsniper.ApplicationRunner;
import endtoend.test.endtoend.auctionsniper.FakeAuctionServer;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class XMPPAuctionHouseTest {
    private XMPPAuctionHouse auctionHouse;
    private FakeAuctionServer auctionServer = new FakeAuctionServer("item-54321");

    @Before public void openConnection() throws XMPPAuctionException, XMPPException {
        auctionHouse = XMPPAuctionHouse.connect(FakeAuctionServer.XMPP_HOSTNAME, ApplicationRunner.SNIPER_ID, ApplicationRunner.SNIPER_PASSWORD);

    }

    @After
    public void closeConnection() {
        if (auctionHouse != null) {
            auctionHouse.disconnect();
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
        Auction auction = auctionHouse.auctionFor(new Item(auctionServer.getItemId(), 567));
        auction.addAuctionEventListener(auctionClosedListener(auctionWasClosed));
        auction.join();
        auctionServer.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auctionServer.announceClosed();
        assertTrue("should have been closed", auctionWasClosed.await(2, TimeUnit.SECONDS));
    }

    private AuctionEventListener auctionClosedListener(final CountDownLatch auctionWasClosed) {
        return new AuctionEventListener() {
            @Override
            public void auctionFailed() {
                auctionWasClosed.countDown();
            }

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
