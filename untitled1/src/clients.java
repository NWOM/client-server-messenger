import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class clients {
    public static void main(String args[])
    {
        //a socket is an endpoint of communication between two computers.An endpoint is a combination of an IP address
        //and a port number .Socket are used to send and receive Data using TCP
        //TCP stands for Transmission Control Protocol.It is a connection oriented protocol meaning two computers
        //from a connection before sending datacEvery TCP connection can be identified by wo endpoints
        Socket socket=null;//to commmunicate over socket streams are used I/O stream
        //streams is a sequence of datas.There are two types of Streams a character stream(usually with text files)
        //and a byte stream (usually with images)
        InputStreamReader inputStreamReader=null;
        //OutputStreamWriter and InputStreamReaderare both bridges from bytestreams to character Streams
        //The Underlying byte Streams are the OutputStream and InputStream from the socket respectively
        OutputStreamWriter outputStreamWriter=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try{
            socket=new Socket("localhost",6798);//localhost is a domain name like google.com or wikipedia
            //local host takes to your computer.localhost is resolved to Ip address 127.0.0.1
            inputStreamReader=new InputStreamReader(socket.getInputStream());
            outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
            bufferedReader=new BufferedReader(inputStreamReader);
            bufferedWriter=new BufferedWriter(outputStreamWriter);
            Scanner scanner=new Scanner(System.in);
            while(true){
                String mssgtohood=scanner.nextLine();//mssg send to server
                bufferedWriter.write(mssgtohood);
                bufferedWriter.newLine();
                bufferedWriter.flush();//send the mssg to the server

                //response from the server
                System.out.println("SErver" + bufferedReader.readLine());
                if(mssgtohood.equalsIgnoreCase("BYE"));
                break;}


            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        }
    }


