package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class NumberCell implements Cell {

    private final CellState cellState = CellState.initialize();
    private final int nearbyLandMineCount;

    public NumberCell(int nearbyLandMineCount) {
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMineCount() {
        return true;
    }

    @Override
    public CellSnapshot getSnapshot() {
        if (cellState.isOpened()) {
            return CellSnapshot.ofNumber(nearbyLandMineCount);
        }
        if (cellState.isFlagged()) {
            return CellSnapshot.ofFlag();
        }
        return CellSnapshot.ofUnchecked();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isOpened();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }

}
