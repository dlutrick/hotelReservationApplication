package application.models.freeRoom;

public class FreeRoom {
    private int id;
    private boolean isFree;
    public FreeRoom(int id, boolean isFree) {
        this.id = id;
        this.isFree = isFree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean getIsFree() {
        return isFree;
    }
}
