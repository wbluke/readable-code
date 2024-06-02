package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class Middle implements GameLevel {

    @Override
    public int getRowSize() {
        return 14;
    }

    @Override
    public int getColSize() {
        return 18;
    }

    @Override
    public int getLandMineCount() {
        return 40;
    }

}
