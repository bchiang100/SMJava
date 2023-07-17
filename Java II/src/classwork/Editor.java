package classwork;

public class Editor {
    String s;
    String undo = null;
    String method = null;
    private Editor(String s) {
        this.s = s;
    }
    public void change(String n) {
        s = n;
        undo = s;
        method = "change";
    }
    public void delete() {
        s = s.substring(0, s.length() - 1);
        undo = s.substring(s.length() - 1, s.length());
        method = "delete";
    }
    public void undo() {
        if (method == "delete") {
            s += undo;
        }
        if (method == "change") {
            String n = s;
            s = undo;
            undo = n;
        }
    }
    public void redo() {
        if (method == "delete") {
            s = s.substring(0, s.length() - 1);
        }
        if (method == "change") {
            s = undo;
        }
    }
}
