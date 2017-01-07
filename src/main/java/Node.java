import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Chamil Prabodha on 03/01/2017.
 */
public class Node {

    private List<Neighbour> neighbours = null;

//    public static void main(String args[]){
//        boolean status = registerNode("127.0.0.1", 8084, "node4");
//        if(status)
//            System.out.println("Node Successfully Registered");
//    }

    public Node(String ip,int port){
        DSConnection.init(ip,port);
        neighbours = new ArrayList<Neighbour>();

    }

    public boolean registerNode(String username){

        String ip = DSConnection.getConnection().getRawIp();
        int port = DSConnection.getConnection().getPort();

        String command = "REG "+ip+" "+port+" "+username;

        String response = DSConnection.getConnection().connectToBootstrap(command,port);

        if(response !=null) {
            StringTokenizer st = new StringTokenizer(response, " ");

            String length = st.nextToken();
            String rescode = st.nextToken();

            String count = st.nextToken();

//            System.out.println(Integer.parseInt(count));

            if (count.equals("9999")) {
                System.out.println("BOOTSTRAP: failed, there is some error in the command");
                return false;
            } else if (count.equals("9998")) {
                System.out.println("BOOTSTRAP: failed, already registered to you, unregister first");
                return false;
            } else if (count.equals("9997")) {
                System.out.println("BOOTSTRAP: failed, registered to another user, try a different IP and port");
                return false;
            } else if (count.equals("9996")) {
                System.out.println("BOOTSTRAP: failed, can’t register. BS full");
                return false;
            } else {
                for(int i=0;i<Integer.parseInt(count);i++){
                    String neighbour_ip = st.nextToken();
                    int neighbour_port = Integer.parseInt(st.nextToken());
                    neighbours.add(new Neighbour(neighbour_ip,neighbour_port));
                    join(neighbour_ip,neighbour_port);
                }

//                for(int i=0;i<neighbours.size();i++){
//                    System.out.println(neighbours.get(i).getIp()+" - "+neighbours.get(i).getPort());
//                }

                listen();
                return true;
            }
        }

        return false;

    }

    private boolean unregisterNode(String username){

        String ip = DSConnection.getConnection().getRawIp();
        int port = DSConnection.getConnection().getPort();

        String command = "UNREG "+ip+" "+port+" "+username;
        DSConnection.getConnection().connectToBootstrap(command,port);
        return false;
    }

    private void join(String ip, int port){

        String command = "JOIN "+DSConnection.getConnection().getRawIp()+" "+DSConnection.getConnection().getPort();
        DSConnection.getConnection().Send(command,ip,port);
    }

    private void listen(){
        String ip = DSConnection.getConnection().getRawIp();
        int port = DSConnection.getConnection().getPort();

        DSConnection.getConnection().listen(ip,port);
    }

}