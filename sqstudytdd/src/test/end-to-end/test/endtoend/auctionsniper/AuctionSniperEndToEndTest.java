package test.endtoend.auctionsniper;

import org.jivesoftware.smack.XMPPException;
import org.junit.After;
import org.junit.Test;

/**
 * End to end Test
 */
public class AuctionSniperEndToEndTest {
    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinAuctionUntilAuctionCloses() throws XMPPException, InterruptedException {
        /*
           In Chapter 10, we force on a basic function: a sniper joins, then auction closes. This process needs 5 steps.
         */
        // needs 5 steps.
        // Step 1-5
        auction.startSellingItem();
        application.startBiddingIn(auction);
        auction.hasReceivedJoinRequestFromSniper();
        auction.announceClosed();
        application.showsSniperHasLostAuction();
    }

    // Additional cleanup
    @After
    public void stopAuction() {
        auction.stop();
    }
    @After
    public void stopApplication() {
        application.stop();
    }
}
