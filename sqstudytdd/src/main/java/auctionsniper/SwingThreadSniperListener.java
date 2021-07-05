package auctionsniper;

import javax.swing.*;

public class SwingThreadSniperListener implements SniperListener {
    private final SniperListener sniperListener;

    public SwingThreadSniperListener(SniperListener sniperListener) {
        this.sniperListener = sniperListener;
    }

    @Override
    public void sniperStateChanged(final SniperSnapshot snapshot) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sniperListener.sniperStateChanged(snapshot);
            }
        });
    }
}
