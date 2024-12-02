import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        Server.StartServer();
    }
}

/*public class Server {
    private static final int PORT = 2546;
    public static ServerSocket serverSocket;

    private ArrayList<Socket> connectedClients = new ArrayList<>();
    private ArrayList<String> clientNames = new ArrayList<>();

    public static void StartServer()
    {

        try {
            serverSocket = new ServerSocket(PORT);
            while (true)
            {
                Socket clientSocket = serverSocket.accept();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int ConnectClient(Socket clientSocket)
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String name = reader.readLine();
            connectedClients.add(clientSocket);
            clientNames.add(name);
            return clientNames.indexOf(name);
        } catch (IOException e) {
            System.out.println("[ERROR] connecting client");
            return -1;
        }
    }

    private void HandleGroup(Socket clientSocket)
    {
        int clientID = ConnectClient(clientSocket);
        if (clientID!=-1)
        {
            String joinMessage = ">"+clientNames.get(clientID)+" Has Joined The Chat!";
            SendToEveryone(joinMessage);
        }
        //manage group after client connection
        // for reading
            try
            {
                while (true)
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String input = reader.readLine();
                    String message = clientNames.get(clientID)+": "+input;
                    SendToEveryoneBut(clientID,message);
                }

            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
    }

    private void SendToEveryone(String data)
    {
        for (Socket clientSocket: connectedClients)
        {
            try {
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
                writer.println(data);
            } catch (IOException e) {
                System.out.println("Error sending message to all clients -> ClientID: " + connectedClients.indexOf(clientSocket));;
            }

        }
    }

    private void SendToEveryoneBut(int ID, String data)
    {
        for (Socket clientSocket: connectedClients)
        {
            if (connectedClients.indexOf(clientSocket) != ID)
            {
                try {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
                    writer.println(data);
                } catch (IOException e) {
                    System.out.println("Error sending message to all clients but ["+ID+"] -> ClientID: " + connectedClients.indexOf(clientSocket));;
                }
            }


        }
    }

}*/
