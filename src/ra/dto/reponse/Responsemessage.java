package ra.dto.reponse;

public class Responsemessage {
    private  String message;

    public Responsemessage() {
    }

    public Responsemessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
