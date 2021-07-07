package unit.test.auctionsniper.ui;

import auctionsniper.SniperPortfolio;
import auctionsniper.UserRequestListener;
import auctionsniper.ui.MainWindow;
import com.objogate.wl.swing.probe.ValueMatcherProbe;
import endtoend.test.endtoend.auctionsniper.AuctionSniperDriver;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class MainWindowTest {
    private final MainWindow mainWindow = new MainWindow(new SniperPortfolio());
    private final AuctionSniperDriver driver = new AuctionSniperDriver(100);

    @Test
    public void makeUserRequestWhenJoinButtonClicked() {
        final ValueMatcherProbe<UserRequestListener.Item> itemProbe = new ValueMatcherProbe<>(equalTo(new UserRequestListener.Item("an item-id", 789)), "item request");
        mainWindow.addUserRequestListener(
                new UserRequestListener() {
                    @Override
                    public void joinAuction(Item item) {
                        itemProbe.setReceivedValue(item);
                    }
                });
        driver.startBiddingForStopPrice("an item-id", 789);
        driver.check(itemProbe);
    }
}
