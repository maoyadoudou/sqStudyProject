package endtoend.test.endtoend.auctionsniper;

import org.jivesoftware.smack.XMPPException;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;

/**
 * End to end Test
 */
public class AuctionSniperEndToEndTest {
    private final FakeAuctionServer auction1 = new FakeAuctionServer("item-54321");
    private final FakeAuctionServer auction2 = new FakeAuctionServer("item-65432");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinAuctionUntilAuctionCloses() throws XMPPException, InterruptedException {
        /*
           In Chapter 10, we force on a basic function: a sniper joins, then auction closes. This process needs 5 steps.
         */
        // needs 5 steps.
        // Step 1-5
        auction1.startSellingItem();

        application.startBiddingIn(auction1);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);

        auction1.announceClosed();
        application.showsSniperHasLostAuction();
    }

    @Test
    public void sniperMakesAHigherBidButLoses() throws XMPPException, InterruptedException {
        auction1.startSellingItem();
        application.startBiddingIn(auction1);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding(auction1, 1000,1098);
        auction1.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);
        auction1.announceClosed();
        application.showsSniperHasLostAuction();
    }

    @Test
    public void sniperWinsAnAuctionByBiddingHigher() throws XMPPException, InterruptedException {
        auction1.startSellingItem();
        application.startBiddingIn(auction1);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding(auction1, 1000, 1098);
        auction1.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);

        auction1.reportPrice(1098, 97, ApplicationRunner.SNIPER_XMPP_ID);
        application.hasShownSniperIsWinning(auction1, 1098);

        auction1.announceClosed();
        application.showsSniperHasWonAuction(auction1, 1098);
    }

    @Test
    public void sniperAnAuctionByBiddingHigher() throws XMPPException, InterruptedException {
        auction1.startSellingItem();
        application.startBiddingIn(auction1);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding(auction1, 1000, 1098);
        auction1.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1098, 97, ApplicationRunner.SNIPER_XMPP_ID);
        application.hasShownSniperIsWinning(auction1, 1098);
        auction1.announceClosed();
        application.showsSniperHasWonAuction(auction1, 1098);
    }

    @Test
    public void sniperBidsForMultipleItems() throws XMPPException, InterruptedException {
        auction1.startSellingItem();
        auction2.startSellingItem();

        application.startBiddingIn(auction1, auction2);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction2.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);

        auction1.reportPrice(1000, 98, "other bidder");
        auction1.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);

        auction2.reportPrice(500, 21, "other bidder");
        auction2.hasReceivedBid(521, ApplicationRunner.SNIPER_XMPP_ID);

        auction1.reportPrice(1098, 97, ApplicationRunner.SNIPER_XMPP_ID);
        auction2.reportPrice(521, 22, ApplicationRunner.SNIPER_XMPP_ID);

        application.hasShownSniperIsWinning(auction1, 1098);
        application.hasShownSniperIsWinning(auction2, 521);

        auction1.announceClosed();
        auction2.announceClosed();

        application.showsSniperHasWonAuction(auction1, 1098);
        application.showsSniperHasWonAuction(auction2, 521);
    }

    @Test
    public void sniperLosesAnAuctionWhenThePriceIsTooHigh() throws XMPPException, InterruptedException {
        auction1.startSellingItem();
        application.startBiddingWithStopPrice(auction1, 1100);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding(auction1, 1000,1098);
        auction1.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);
        auction1.reportPrice(1197, 10, "third party");
        application.hasShownSniperIsLosing(auction1, 1197, 1098);
        auction1.reportPrice(1207, 10, "fourth party");
        application.hasShownSniperIsLosing(auction1, 1207, 1098);
        auction1.announceClosed();
        application.showsSniperHasLostAuction();
    }

    @Test
    public void sniperReportsInvalidAuctionMessageAndStopsRespondingToEvents() throws XMPPException, InterruptedException, IOException {
        String brokenMessage = "a broken message";
        auction1.startSellingItem();
        auction2.startSellingItem();

        application.startBiddingIn(auction1, auction2);
        auction1.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);

        auction1.reportPrice(500, 20, "other bidder");
        auction1.hasReceivedBid(520, ApplicationRunner.SNIPER_XMPP_ID);

        auction1.sendInvalidMessageContaining(brokenMessage);
        application.hasShownSniperHasFailed(auction1);

        auction1.reportPrice(520, 21, "other bidder");
        waitForAnotherAuctionEvent();

        application.reportsInvalidMessage(auction1, brokenMessage);
        application.hasShownSniperHasFailed(auction1);
    }

    private void waitForAnotherAuctionEvent() throws InterruptedException, XMPPException {
        auction2.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        auction2.reportPrice(600, 6, "other bidder");
        application.hasShownSniperIsBidding(auction2, 600, 606);
    }


    // Additional cleanup
    @After
    public void stopAuction() {
        auction1.stop();
    }
    @After
    public void stopApplication() {
        application.stop();
    }
}
