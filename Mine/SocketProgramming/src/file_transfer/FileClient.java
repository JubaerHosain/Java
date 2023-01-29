package file_transfer;

import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 22222);

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        int fileSize = (int) objectInputStream.readObject();
        byte[] bytes = new byte[fileSize];

        System.out.println("Client file size: " + fileSize);

        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes, 0, bytes.length);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\BySocket\\receivedBySocket.txt");
        fileOutputStream.write(bytes, 0, bytes.length);
    }
}
