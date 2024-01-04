package hwdp;
import java.util.HashMap;

// TODO HWDP P3

public class SourceObserver implements Observer {
	private String name;
	private HashMap<Subject, String> subjectToPastStateName;
	private LibraryLogger logger;
	
	public SourceObserver(String n) {
		// TODO?
		name = n;
		subjectToPastStateName = new HashMap<Subject, String>();
		logger = LibraryLogger.getInstance();
	}

	@Override
	public void update(Subject o) {
		String oldState = subjectToPastStateName.get(o);
		if (oldState == null) {
			oldState = "UNOBSERVED";
		}
		logger.writeLine(name + " OBSERVED " + o.toString() + " LEAVING STATE: " + oldState);
		subjectToPastStateName.put(o, o.getState().toString());
	}

	@Override
	public String toString() {
		return name;
	}
}
