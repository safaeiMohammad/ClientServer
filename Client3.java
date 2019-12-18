package practeceThread.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
        public static void main(String[] args) throws Exception {
            try{
                InetAddress ip = InetAddress.getByName("localhost");

                Socket socket=new Socket(ip,8888);

                DataInputStream inStream=new DataInputStream(socket.getInputStream());
                DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String clientMessage="",serverMessage="";
                while(!clientMessage.equals("bye")){
                    System.out.println("Enter number :");
                    clientMessage=br.readLine();
                    outStream.writeUTF(clientMessage);
                    outStream.flush();
                    serverMessage=inStream.readUTF();
                    System.out.println(serverMessage);
                }
                outStream.close();
                outStream.close();
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
}
