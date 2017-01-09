package Message;

import java.util.ArrayList;
import java.util.List;
import Util.Neighbour;

/**
 * Created by Chamil Prabodha on 08/01/2017.
 */
public class REGOKMessage extends AbstractMessage {

    private int length = 0;
    private MessageType type = null;
    private int no_nodes = 0;
    private List<Neighbour> neighbours = null;

    public REGOKMessage(int length, MessageType type, int no_nodes){
        this.length = length;
        this.type = type;
        this.no_nodes = no_nodes;
        neighbours = new ArrayList<Neighbour>();
    }

    public void addNeighbour(String ip, int port){
        Neighbour neighbour = new Neighbour(ip,port);
        neighbours.add(neighbour);
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public MessageType getType() {
        return type;
    }

    public int getNo_nodes(){
        return no_nodes;
    }

    public List<Neighbour> getNeighbours(){
        return neighbours;
    }
}
