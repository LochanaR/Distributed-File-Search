package Message;

/**
 * Created by Chamil Prabodha on 09/01/2017.
 */
public class JOINMessage extends AbstractMessage {

    private int length = 0;
    private MessageType type = null;
    private String ip = null;
    private int port = 0;

    public JOINMessage(int length, MessageType type, String ip, int port){
        this.length = length;
        this.type = type;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public MessageType getType() {
        return this.type;
    }

    public String getIp(){
        return this.ip;
    }

    public int getPort(){
        return this.port;
    }
}
