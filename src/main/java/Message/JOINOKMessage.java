package Message;

/**
 * Created by Chamil Prabodha on 08/01/2017.
 */
public class JOINOKMessage extends AbstractMessage {

    private int length = 0;
    private MessageType type = null;
    private int value = 9999;

    public JOINOKMessage(int length, MessageType type, int value){
        this.length = length;
        this.type = type;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public MessageType getType() {
        return type;
    }
}
