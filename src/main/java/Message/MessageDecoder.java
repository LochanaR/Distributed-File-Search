package Message;

import java.util.StringTokenizer;


/**
 * Created by Chamil Prabodha on 08/01/2017.
 */
public class MessageDecoder {
    public static AbstractMessage decodeMessage(String response){
        StringTokenizer st = new StringTokenizer(response," ");

        AbstractMessage res = null;

        String length = st.nextToken();
        String type = st.nextToken();


        MessageType t = MessageType.valueOf(type);

        switch (t){

            case JOIN:
                String ip = st.nextToken();
                String port = st.nextToken();
                res = new JOINMessage(Integer.parseInt(length),t,ip,Integer.parseInt(port));
                return res;

            case REGOK:
                String no_nodes = st.nextToken();
                res = new REGOKMessage(Integer.parseInt(length),t,Integer.parseInt(no_nodes));
                for(int i = 0;i<Integer.parseInt(no_nodes);i++){
                    String neighbour_ip = st.nextToken();
                    int neighbour_port = Integer.parseInt(st.nextToken());
                    ((REGOKMessage)res).addNeighbour(neighbour_ip,neighbour_port);

                }
                return res;

            case JOINOK:
                String value = st.nextToken();
                res = new JOINOKMessage(Integer.parseInt(length),t,Integer.parseInt(value));
                return res;
            default:
                return null;


        }

    }
}
