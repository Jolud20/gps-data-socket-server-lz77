package com.example.kafka.demo.gpsmonitoring.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class DataReceiver {
    public InetSocketAddress inetSocketAddress;
    public InetAddress inetAddress;

    public DataReceiver(String hostName,int port) throws UnknownHostException {
        this.inetAddress = InetAddress.getByName(hostName);
        this.inetSocketAddress=new InetSocketAddress(inetAddress,port);
    }

    public byte[] receiveData() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(inetSocketAddress);
        System.out.println("Server is running");
        try (
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead != -1) {
                byte[] receivedData = new byte[bytesRead];
                System.arraycopy(buffer, 0, receivedData, 0, bytesRead);
                return receivedData;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket.close();
        return new byte[0];
    }
}
