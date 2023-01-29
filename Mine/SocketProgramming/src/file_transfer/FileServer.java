package file_transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        Socket clientSocket = serverSocket.accept();

        File file = new File("C:\\BySocket\\sendBySocket.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        int fileSize = (int) file.length();
        byte[] bytes = new byte[fileSize];
        fileInputStream.read(bytes, 0, bytes.length);

        // send file size
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutputStream.writeObject(fileSize);

        System.out.println("Server file size: " + fileSize);

        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);
    }
}
