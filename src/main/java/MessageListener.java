import Message.AbstractMessage;

/**
 * Created by Chamil Prabodha on 08/01/2017.
 */
public interface MessageListener {
    public void messageReceived(AbstractMessage res);
}
