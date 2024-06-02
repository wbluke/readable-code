package cleancode.minesweeper.tobe.minesweeper.board.cell;

public enum CellSnapshotStatus {

    EMPTY("빈 셀"),
    FLAG("깃발"),
    LAND_MINE("지뢰"),
    NUMBER("숫자"),
    UNCHECKED("확인 전"),
    ;

    private final String description;

    CellSnapshotStatus(String description) {
        this.description = description;
    }

}
