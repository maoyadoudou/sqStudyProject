package unit.test.auctionsniper.ui;

import auctionsniper.AuctionSniper;
import auctionsniper.Item;
import auctionsniper.SniperSnapshot;
import auctionsniper.ui.Column;
import auctionsniper.ui.SnipersTableModel;
import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import static auctionsniper.SniperState.BIDDING;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

@RunWith(JMock.class)
public class SnipersTableModelTest {
    private static final String ITEM_ID = "item 0";
    private final Mockery context = new Mockery();
    private TableModelListener listener = context.mock(TableModelListener.class);
    private final SnipersTableModel model = new SnipersTableModel();
    private final AuctionSniper sniper = new AuctionSniper(new Item(ITEM_ID, 234), null);

    @Before
    public void attachModelListener() {
        model.addTableModelListener(listener);
    }

    @Test
    public void hasEnoughColumns() {
        assertThat(model.getColumnCount(), equalTo(Column.values().length));
    }

    @Test
    public void setsSniperValuesInColumns() {
        context.checking(new Expectations() {{
            one(listener).tableChanged(with(aRowChangedEvent()));
        }});

        model.sniperStateChanged(new SniperSnapshot("item id", 555, 666, BIDDING));

        assertColumnEquals(Column.ITEM_IDENTIFIER, "item id");
        assertColumnEquals(Column.LAST_PRICE, 555);
        assertColumnEquals(Column.LAST_BID, 666);
        assertColumnEquals(Column.SNIPER_STATE, SnipersTableModel.textFor(BIDDING));
    }

    @Test
    public void setsUpColumnHeadings() {
        for (Column column: Column.values()) {
            assertEquals(column.name, model.getColumnName(column.ordinal()));
        }
    }

    private void assertColumnEquals(Column column, Object expected) {
        final int rowIndex = 0;
        final int columnIndex = column.ordinal();
        assertEquals(expected, model.getValueAt(rowIndex, columnIndex));
    }

    private Matcher<TableModelEvent> aRowChangedEvent() {
        return samePropertyValuesAs(new TableModelEvent(model, 0));
    }

    @Test
    public void notifiesListenersWhenAddingASniper() {
        context.checking(new Expectations() {{
            oneOf(listener).tableChanged(with(anInsertionAtRow(0)));
        }});

        assertEquals(0, model.getRowCount());

        model.sniperAdded(sniper);
        assertEquals(1, model.getRowCount());
        assertRowMatchesSnapshot(0, SniperSnapshot.joining(ITEM_ID));
    }

    Matcher<TableModelEvent> anInsertionAtRow(final int row) {
        return samePropertyValuesAs(new TableModelEvent(model, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
    }

    private void assertRowMatchesSnapshot(int row, SniperSnapshot snapshot) {
        assertEquals(snapshot.itemId, cellValue(row, Column.ITEM_IDENTIFIER));
        assertEquals(snapshot.lastPrice, cellValue(row, Column.LAST_PRICE));
        assertEquals(snapshot.lastBid, cellValue(row, Column.LAST_BID));
        assertEquals(SnipersTableModel.textFor(snapshot.state), cellValue(row, Column.SNIPER_STATE));
    }

    private Object cellValue(int rowIndex, Column column) {
        return model.getValueAt(rowIndex, column.ordinal());
    }

    @Test
    public void setsSniperValueInColumns() {
        SniperSnapshot joining = SniperSnapshot.joining(ITEM_ID);
        SniperSnapshot bidding = joining.bidding(555, 666);
        context.checking(new Expectations() {{
            allowing(listener).tableChanged(with(anyInsertionEvent()));
            oneOf(listener).tableChanged(with(aChangeInRow(0)));
        }});

        model.sniperAdded(sniper);
        model.sniperStateChanged(bidding);

        assertRowMatchesSnapshot(0, bidding);
    }

    Matcher<TableModelEvent> anyInsertionEvent() {
        return hasProperty("type", equalTo(TableModelEvent.INSERT));
    }

    private Matcher<TableModelEvent> aChangeInRow(int row) {
        return samePropertyValuesAs(new TableModelEvent(model, row));
    }

//    @Test
//    public void holdsSniperInAdditionOrder() {
//        context.checking(new Expectations() {{
//            ignoring(listener);
//        }});
//
//        com.mydd.model.addSniper(SniperSnapshot.joining("item 0"));
//        com.mydd.model.addSniper(SniperSnapshot.joining("item 1"));
//
//        assertEquals("item 0", cellValue(0, Column.ITEM_IDENTIFIER));
//        assertEquals("item 1", cellValue(1, Column.ITEM_IDENTIFIER));
//
//    }
}
