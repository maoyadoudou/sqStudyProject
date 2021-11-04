package endtoend.test.endtoend.auctionsniper;

import auctionsniper.Main;
import auctionsniper.SniperState;
import auctionsniper.ui.MainWindow;
import org.jivesoftware.smack.packet.Message;

import java.io.IOException;

import static auctionsniper.SniperState.*;
import static auctionsniper.ui.SnipersTableModel.textFor;
import static endtoend.test.endtoend.auctionsniper.FakeAuctionServer.XMPP_HOSTNAME;
import static org.hamcrest.CoreMatchers.containsString;

public class ApplicationRunner {
    public static final String SNIPER_ID = "sniper";
    public static final String SNIPER_PASSWORD = "sniper";
    public static final String SNIPER_XMPP_ID = "sniper@localhost/Auction";

    private AuctionLogDriver logDriver = new AuctionLogDriver();
    private AuctionSniperDriver driver;
    private String itemId;

    public void reportsInvalidMessage(FakeAuctionServer auction, String meassage) throws IOException {
        logDriver.hasEntry(containsString(meassage));
    }

    public void startBiddingIn(final FakeAuctionServer... auctions) {
        startSniper();
        for (FakeAuctionServer auction : auctions) {
            final String itemId = auction.getItemId();
            driver.startBiddingFor(itemId);
            driver.showsSniperStatus(itemId, 0, 0, textFor(JOINING));
        }
    }

    private void startSniper() {
        logDriver.clearLog();
        Thread thread = new Thread("Test Application") {
            @Override public void run() {
                try {
                    Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        driver = new AuctionSniperDriver(1000);
        driver.hasTitle(MainWindow.APPLICATION_TITLE);
        driver.hasColumnTitles();
    }

    protected static String[] arguments(FakeAuctionServer... auctions) {
        String[] arguments = new String[auctions.length + 3];
        arguments[0] = XMPP_HOSTNAME;
        arguments[1] = SNIPER_ID;
        arguments[2] = SNIPER_PASSWORD;
        for (int i = 0; i < auctions.length; i++) {
            arguments[i + 3] = auctions[i].getItemId();
        }
        return arguments;
    }

    public void showsSniperHasLostAuction() {
        driver.showsSniperStatus(itemId, textFor(LOST));
    }

    public void hasShownSniperIsBidding(FakeAuctionServer auction, int lastPrice, int lastBid) {
        driver.showsSniperStatus(auction.getItemId(), lastPrice, lastBid, textFor(BIDDING));
    }

    public void hasShownSniperIsWinning(FakeAuctionServer auction, int winningBid) {
        driver.showsSniperStatus(auction.getItemId(), winningBid, winningBid, textFor(WINNING));
    }

    public void showsSniperHasWonAuction(FakeAuctionServer auction, int lastPrice) {
        driver.showsSniperStatus(auction.getItemId(), lastPrice, lastPrice, textFor(WON));
    }

    public void stop() {
        if (driver != null) {
            driver.dispose();
        }
    }

    public void startBiddingWithStopPrice(FakeAuctionServer auction, int stopPrice) {
        startSniper();
        openBiddingFor(auction, stopPrice);
    }

    public void hasShownSniperIsLosing(FakeAuctionServer auction, int lastPrice, int lastBid) {
        driver.showsSniperStatus(auction.getItemId(), lastPrice, lastBid, textFor(LOSING));
    }

    public void hasShownSniperHasFailed(FakeAuctionServer auction) {
        driver.showsSniperStatus(auction.getItemId(), 0, 0, textFor(SniperState.FAILED));
    }

    private void openBiddingFor(FakeAuctionServer auction, int stopPrice) {
        final String itemId = auction.getItemId();
        driver.startBiddingForStopPrice(itemId, stopPrice);
        driver.showsSniperStatus(itemId, 0, 0, textFor(JOINING));
    }
}
