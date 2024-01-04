package hwdp;

class Borrowed implements LBState {
    private static Borrowed instance = null;
    private Borrowed() {}

    public static Borrowed getInstance() {
        if (instance == null) {
            instance = new Borrowed();
        }
        return instance;
    }

    public String toString() {
        return "Borrowed";
    }

    public LBState shelf(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState issue(LibraryBook context) throws BadOperationException {
        throw new BadOperationException();
    }

    public LBState extend(LibraryBook context) throws BadOperationException {
        return Borrowed.getInstance();
    }

    public LBState returnIt(LibraryBook context) throws BadOperationException {
        return GotBack.getInstance();
    }
}