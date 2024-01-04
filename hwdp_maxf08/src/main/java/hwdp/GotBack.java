package hwdp;

class GotBack implements LBState {
    private static GotBack instance = null;
    private GotBack() {}

    public static GotBack getInstance() {
        if (instance == null) {
            instance = new GotBack();
        }
        return instance;
    }

    public String toString() {
        return "GotBack";
    }

    public LBState shelf(LibraryBook context) {
        return OnShelf.getInstance();
    }

    public LBState issue(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState extend(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState returnIt(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }
}
