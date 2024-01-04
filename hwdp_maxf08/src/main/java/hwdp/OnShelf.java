package hwdp;

class OnShelf implements LBState {
    private static OnShelf instance = null;
    private OnShelf() {}

    public static OnShelf getInstance() {
        if (instance == null) {
            instance = new OnShelf();
        }
        return instance;
    }

    public String toString() {
        return "OnShelf";
    }

    public LBState shelf(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState issue(LibraryBook context) {
        return Borrowed.getInstance();
    }

    public LBState extend(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState returnIt(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }
}