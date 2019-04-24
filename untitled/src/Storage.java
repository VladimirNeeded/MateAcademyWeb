import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static List<Client> storageOfClients = new ArrayList<>();

    public static List<Client> getStorageOfClients() {
        return storageOfClients;
    }
    public static Client getClient(int index) {
        return storageOfClients.get(index);
    }

    public static List<String> logins (){
        List<String> logins = new ArrayList<>();
        for (int i = 0; i < storageOfClients.size(); i++){
            logins.add(storageOfClients.get(i).getLogin());
        }
        return logins;
    }

        public static void addClient(String log, String pass) {
            storageOfClients.add(new Client(log, pass));
    }

    public static int getSize(){
        return storageOfClients.size();
    }
}