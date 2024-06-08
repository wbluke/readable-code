package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.order.StudyCafePassOrder;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;

import java.util.List;

public class StudyCafeIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void showWelcomeMessage() {
        outputHandler.showWelcomeMessage();
    }

    public void showAnnouncement() {
        outputHandler.showAnnouncement();
    }

    public void showPassOrderSummary(StudyCafePassOrder passOrder) {
        outputHandler.showPassOrderSummary(passOrder);
    }

    public void showSimpleMessage(String message) {
        outputHandler.showSimpleMessage(message);
    }

    public StudyCafePassType askPassTypeSelecting() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    public StudyCafeSeatPass askPassSelecting(List<StudyCafeSeatPass> passCandidates) {
        outputHandler.showPassListForSelection(passCandidates);
        return inputHandler.getSelectPass(passCandidates);
    }

    public boolean askLockerPass(StudyCafeLockerPass lockerPassCandidate) {
        outputHandler.askLockerPass(lockerPassCandidate);
        return inputHandler.getLockerSelection();
    }

}
