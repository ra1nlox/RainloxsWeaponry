package md.rainlox.weaponryPlugin.types;

public class Status {

    public String status;

    public Status(boolean status) {
        if (status) {
            this.status = "LOADED";
        } else {
            this.status = "UNLOADED";
        }
    }

    public String getStatusString() {
        return status;
    }

    public boolean getStatusBoolean() {
        if (status.equals("LOADED")) {
            return true;
        } else if (status.equals("UNLOADED")) {
            return false;
        }
        return false;
    }

    public void setStatus(boolean status) {
        if (status) {
            this.status = "LOADED";
        } else {
            this.status = "UNLOADED";
        }
    }
}

