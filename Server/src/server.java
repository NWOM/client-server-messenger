import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) throws IOException {
        Socket socket=null;
        InputStreamReader inputStreamReader=null;
        OutputStreamWriter outputStreamWriter=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        //A server socket wait for requests to come in over the network.Our client we made is trying to connect port-
        //port 6798.Then we want our server socket  to be waiting for connection on port 6798
        ServerSocket serverSocket=null;
        serverSocket=new ServerSocket(6798);
        while(true){ //the first while  loop  to ensure the server is constantly running
            try {  //accept() waits for client connection.Once connected a socket object is returned that can be used-
                //to communicate to the client
              socket=serverSocket.accept();
              inputStreamReader=new InputStreamReader(socket.getInputStream());
              outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());

              bufferedReader=new BufferedReader(inputStreamReader);
              bufferedWriter=new BufferedWriter(outputStreamWriter);
              while(true)//to ensure that once the client is connected the server is constantly interacting with the-
                    //client until  the client disconnects
                   {
                  String mssgfromclient= bufferedReader.readLine();
                  System.out.println("Client"+ mssgfromclient);
                  bufferedWriter.write("RECEIVED");
                  bufferedWriter.newLine();
                  bufferedWriter.flush();

                  if(mssgfromclient.equalsIgnoreCase("BYE"))
                      break;
              }
              socket.close();
              inputStreamReader.close();
              bufferedReader.close();
              bufferedWriter.close();
              outputStreamWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

