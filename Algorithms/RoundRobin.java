import java.util.ArrayList;
import java.util.List;

class LoadBalancer{
    private List<String> servers;
    private int currentIndex;
    public LoadBalancer(List<String> servers){
        this.servers = servers;
        this.currentIndex = 0;
    }

    public String nextServer(){
        String nextServer = servers.get(currentIndex);
        currentIndex = (currentIndex+1)%servers.size();
        return nextServer;
    }
}

public class RoundRobin{
    public static void main(String[] args){
        List<String> serverList = new ArrayList<>();
        serverList.add("Server 1");
        serverList.add("Server 2");
        serverList.add("Server 3");
        serverList.add("Server 4");
        serverList.add("Server 5");
        serverList.add("Server 6");
        serverList.add("Server 7");
        serverList.add("Server 8");

        LoadBalancer lb = new LoadBalancer(serverList);
        for(int i=0;i<15;i++){
            String server = lb.nextServer();
            System.out.println("Request " + (i + 1) + ": Routed to " + server);
        }
    }
}