package auctionsniper.ui;

import auctionsniper.*;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;


public class SnipersTableModel extends AbstractTableModel implements PortfolioListener, SniperListener {
    private static String[] STATUS_TEXT = {"Joining", "Bidding", "Winning", "Losing", "Lost", "Won"};
    private ArrayList<SniperSnapshot> snapshots = new ArrayList<>();
    private final List<AuctionSniper> notToBeGCd = new ArrayList<>();

    public int getColumnCount() {
        return Column.values().length;
    }

    public int getRowCount() {
        return snapshots.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return Column.at(columnIndex).valueIn(snapshots.get(rowIndex));
    }

    @Override
    public String getColumnName(int column) {
        return Column.at(column).name;
    }

    public static String textFor(SniperState state) {
        return STATUS_TEXT[state.ordinal()];
    }

    public void addSniper(SniperSnapshot snapshot) {
        int row = snapshots.size();
        snapshots.add(snapshot);
        fireTableRowsInserted(row, row);
    }

    @Override
    public void sniperStateChanged(SniperSnapshot newSnapshot) {
        for (int i = 0; i < snapshots.size(); i++) {
            if (newSnapshot.isForSameItemAs(snapshots.get(i))) {
                snapshots.set(i, newSnapshot);
                fireTableRowsUpdated(i, i);
                return;
            }
        }
    }

    private void addSniperSnapshot(SniperSnapshot snapshot) {
        snapshots.add(snapshot);
        int row = snapshots.size() - 1;
        fireTableRowsInserted(row, row);
    }

    @Override
    public void sniperAdded(AuctionSniper sniper) {
        addSniperSnapshot(sniper.getSnapshot());
        sniper.addSniperListener(new SwingThreadSniperListener(this));
    }
}
