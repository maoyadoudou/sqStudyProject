package auctionsniper.xmpp;

import auctionsniper.AuctionEventListener;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

import java.util.HashMap;
import java.util.Map;

public class AuctionMessageTranslator implements MessageListener {
    private AuctionEventListener listener;

    public AuctionMessageTranslator(AuctionEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void processMessage(Chat chat, Message message) {
        AuctionEvent event = AuctionEvent.from(message.getBody());

        String type = event.type();
        if ("CLOSE".equals(type)) {
            listener.auctionClosed();
        } else if ("PRICE".equals(type)) {
            listener.currentPrice(event.currentPrice(), event.increment());
        }
    }

    private HashMap<String, String> unpackEventFrom(Message message) {
        HashMap<String, String> event = new HashMap<>();
        for (String item : message.getBody().split(";")) {
            String[] pair = item.split(":");
            event.put(pair[0].trim(), pair[1].trim());
        }
        return event;
    }

    private static class AuctionEvent {
        private static final Map<String, String> fields = new HashMap<>();
        public String type() {
            return get("Event");
        }
        public int currentPrice() {
            return getInt("CurrentPrice");
        }

        public int increment() {
            return getInt("Increment");
        }

        private int getInt(String fieldName) {
            return Integer.parseInt(get(fieldName));
        }

        private String get(String fieldName) {
            return fields.get(fieldName);
        }

        static void addFields(String field) {
            String[] pair = field.split(":");
            fields.put(pair[0].trim(), pair[1].trim());
        }
        static AuctionEvent from(String messageBody) {
            AuctionEvent event = new AuctionEvent();
            for (String item : fieldsIn(messageBody)) {
                addFields(item);
            }
            return event;
        }

        static String[] fieldsIn(String messageBody) {
            return messageBody.split(";");
        }
    }
}
