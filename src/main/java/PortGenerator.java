/**
 * Created by pavilion 15 on 09/01/2017.
 */
public class PortGenerator {

    static int Min = 1050;
    static int Max = 15000;
    public static int generatePort(){
        int  port = Min + (int)(Math.random() * ((Max - Min) + 1));
        return port;
    }

}
