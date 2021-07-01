package test.endtoend.auctionsniper;


import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Simulate functions of a real auction server, use to check "how the Auction Sniper interacts with an auction using XMPP messages"
 * Responsibilities:
 * 1 This server must connect to the XMPP broker, so that receive the sniper's request of joining the chat;
 * 2 Receive Sniper's chat message, fail if there is no any Sniper's chat message, and waiting time is equal to timeout.
 * 3 Permit the test send messages back to Sniper.
 */
public class FakeAuctionServer {
    public static final String ITEM_ID_AS_LOGIN = "auction-%s";
    public static final String AUCTION_PASSWORD = "auction";
    public static final String AUCTION_RESOURCE = "Auction";
    public static final String XMPP_HOSTNAME = "localhost";

    private final String itemId;
    private final XMPPConnection connection;
    private Chat currentChat;
    private final SingleMessageListener messageListener = new SingleMessageListener();

    public FakeAuctionServer(String itemId) {
        this.itemId = itemId;
        this.connection = new XMPPConnection(XMPP_HOSTNAME);
    }

    /**
     * Firstly, we should download, install and boot the OpenFire;
     * Secondly, create three user accounts (username and password are given in the book);
     * Thirdly, use the following method (connect and login) to connect OpenFire server.
     * @throws XMPPException
     */
    public void startSellingItem() throws XMPPException {
        connection.connect();
        connection.login(String.format(ITEM_ID_AS_LOGIN, itemId), AUCTION_PASSWORD, AUCTION_RESOURCE);
        connection.getChatManager().addChatListener(new ChatManagerListener() {
            public void chatCreated(Chat chat, boolean createdLocally) {
                currentChat = chat;
                chat.addMessageListener(messageListener);
            }
        });
    }

    public void hasReceivedJoinRequestFromSniper() throws InterruptedException {
        messageListener.receiveAMessage();
    }

    public void announceClosed() throws XMPPException {
        currentChat.sendMessage(new Message());
    }

    public void stop() {
        connection.disconnect();
    }

    public String getItemId() {
        return itemId;
    }

    public class SingleMessageListener implements MessageListener {
        private final ArrayBlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(1);

        @Override
        public void processMessage(Chat chat, Message message) {
            messages.add(message);
        }

        public void receiveAMessage() throws InterruptedException {
            assertThat("Message", messages.poll(5, TimeUnit.SECONDS), is(notNullValue()));
        }
    }
}
