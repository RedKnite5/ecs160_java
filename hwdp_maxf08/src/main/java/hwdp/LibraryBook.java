package hwdp;

import java.util.ArrayList;

public class LibraryBook implements Subject {
    private String name;
    private LibraryLogger logger = LibraryLogger.getInstance();
    private LBState state;
    private ArrayList<Observer> observers;
    
    public LibraryBook(String name) {
        state = OnShelf.getInstance();
        this.name = name;
        observers = new ArrayList<Observer>();
    }

	public void attach(Observer observer) {
        if (observers.contains(observer)) {
            logger.writeLine(observer.toString() + " is already attached to " + this.toString());
            return;
        }
        observers.add(observer);
        logger.writeLine(observer.toString() + " is now watching " + name);
    }

	public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            logger.writeLine(observer.toString() + " is no longer watching " + name);
        }
    }

	public void notifyObservers() {
        observers.forEach((observer) -> observer.update(this));
    }
    
    public LBState getState() {
        return state;
    }

    public void shelf() {
        try {
            String oldstate = state.toString();
            state = state.shelf(this);
            logger.writeLine("Leaving State " + oldstate + " for State " + state.toString());
            notifyObservers();
        } catch(BadOperationException e) {
            logger.writeLine("BadOperationException - Can't use " +
                    "shelf in " + state.toString() + " state");
        }
    }

    public void issue() {
        try {
            String oldstate = state.toString();
            state = state.issue(this);
            logger.writeLine("Leaving State " + oldstate + " for State " + state.toString());
            notifyObservers();
        } catch(BadOperationException e) {
            logger.writeLine("BadOperationException - Can't use " +
                    "issue in " + state.toString() + " state");
        }
    }

    public void extend() {
        try {
            String oldstate = state.toString();
            state = state.extend(this);
            logger.writeLine("Leaving State " + oldstate + " for State " + state.toString());
            notifyObservers();
        } catch(BadOperationException e) {
            logger.writeLine("BadOperationException - Can't use " +
                    "extend in " + state.toString() + " state");
        }
    }

    public void returnIt() {
        try {
            String oldstate = state.toString();
            state = state.returnIt(this);
            logger.writeLine("Leaving State " + oldstate + " for State " + state.toString());
            notifyObservers();
        } catch(BadOperationException e) {
            logger.writeLine("BadOperationException - Can't use " +
                    "returnIt in " + state.toString() + " state");
        }
    }
    
    @Override
    public String toString() {
        return name;
    }
}