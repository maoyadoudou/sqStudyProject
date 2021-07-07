package auctionsniper;

import auctionsniper.ui.MainWindow;
import auctionsniper.ui.SnipersTableModel;
import auctionsniper.util.Announcer;
import auctionsniper.xmpp.AuctionMessageTranslator;
import auctionsniper.xmpp.XMPPAuction;
import auctionsniper.xmpp.XMPPAuctionHouse;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    private static final int ARG_HOSTNAME = 0;
    private static final int ARG_USERNAME = 1;
    private static final int ARG_PASSWORD = 2;
    private static final int ARG_ITEM_ID = 3;

    public static final String AUCTION_RESOURCE = "Auction";
    public static final String ITEM_ID_AS_LOGIN = "auction-%s";
    public static final String AUCTION_ID_FORMAT =
            ITEM_ID_AS_LOGIN + "@%s/" + AUCTION_RESOURCE;
    public static final String JOIN_COMMAND_FORMAT = "SOLVersion: 1.1; Command: JOIN;";
    public static final String BID_COMMAND_FORMAT = "SOLVersion: 1.1; Command: BID; Price: %d;";

    private final SnipersTableModel snipers = new SnipersTableModel();
    private MainWindow ui;
    private final SniperPortfolio portfolio = new SniperPortfolio();
    private final Announcer<UserRequestListener> userRequests = Announcer.to(UserRequestListener.class);
    @SuppressWarnings("unused")
    private List<Auction> notToBeGCd = new ArrayList<>();



    public static void main(String... args) throws Exception {
        Main main = new Main();
        XMPPAuctionHouse auctionHouse = XMPPAuctionHouse.connect(args[ARG_HOSTNAME], args[ARG_USERNAME], args[ARG_PASSWORD]);
        main.disconnectWhenUICloses(auctionHouse);
        main.addUserRequestListenerFor(auctionHouse);
//        for (int i = 3; i < args.length; i++) {
//            main.joinAuction(connection, args[i]);
//        }
    }

    private void addUserRequestListenerFor(final XMPPAuctionHouse auctionHouse) {
        ui.addUserRequestListener(new SniperLauncher(auctionHouse, portfolio));
    }
    private static XMPPConnection connection(String hostname, String username, String password)
            throws XMPPException {
        XMPPConnection connection = new XMPPConnection(hostname);
        connection.connect();
        connection.login(username, password, AUCTION_RESOURCE);
        return connection;
    }

    private static String auctionId(String itemId, XMPPConnection connection) {
        return String.format(AUCTION_ID_FORMAT, itemId,
                connection.getServiceName());
    }

    public Main() throws Exception {
        startUserInterface();
    }

    private void startUserInterface() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                ui = new MainWindow(portfolio);
            }
        });
    }

    private void joinAuction(XMPPConnection connection, String itemId)
            throws InterruptedException, InvocationTargetException {
        safelyAddItemToModel(itemId);
        final Chat chat =
                connection.getChatManager().createChat(auctionId(itemId, connection), null);
        Announcer<AuctionEventListener> auctionEventListener = Announcer.to(AuctionEventListener.class);
        chat.addMessageListener(
                new AuctionMessageTranslator(
                        connection.getUser(),
                        auctionEventListener.announce()));

        Auction auction = new XMPPAuction(chat);
        this.notToBeGCd.add(auction);
        auctionEventListener.addListener(
                new AuctionSniper(itemId, auction)
        );
        auction.join();
    }

    private void safelyAddItemToModel(final String itemId) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                snipers.addSniper(SniperSnapshot.joining(itemId));
            }
        });
    }

    private void disconnectWhenUICloses(final XMPPAuctionHouse connectionHouse) {
        ui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                connectionHouse.disconnect();
            }
        });
    }
}
