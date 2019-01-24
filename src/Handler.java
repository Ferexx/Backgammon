import java.util.LinkedList;

public class Handler {
    LinkedList<Checker> checker = new LinkedList<Checker>();

    public void addChecker(Checker checker) {
        this.checker.add(checker);
    }
    public void removeChecker(Checker checker) {
        this.checker.remove(checker);
    }
}
