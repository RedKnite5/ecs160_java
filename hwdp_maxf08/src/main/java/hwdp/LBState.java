package hwdp;

interface LBState {
    public LBState shelf(LibraryBook context) throws BadOperationException;
    public LBState issue(LibraryBook context) throws BadOperationException;
    public LBState extend(LibraryBook context) throws BadOperationException;
    public LBState returnIt(LibraryBook context) throws BadOperationException;
}


