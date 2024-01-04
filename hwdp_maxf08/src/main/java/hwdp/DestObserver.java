package hwdp;


public class DestObserver implements Observer {
    private String name;
    private LibraryLogger logger;

    public DestObserver(String n) {
        name = n;
        logger = LibraryLogger.getInstance();
	}


	@Override
	public void update(Subject o) {
        logger.writeLine(
            name + " OBSERVED " + o.toString()
            + " REACHING STATE: " + o.getState().toString()
        );
	}

    @Override
	public String toString() {
		return name;
	}
}