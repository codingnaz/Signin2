package Model;

import java.io.*;
import java.nio.file.*;
/**
 * I just use it
 * Professor Kanchanawanchai in the videos below:
 *      video 1:
 *          https://youtu.be/hZeB8NArL2k
 *      video 2:
 *          https://youtu.be/x9g-vXuHNkA
 *
 * A function checkForDatFile was added to create a .dat file when this program is first run without one.
 */
public class UserIO {

    public static void writeUsers(Object data) throws IOException {

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("userss.dat"));
        output.writeObject(data);

    }

    public static Object readUsers() throws IOException, ClassNotFoundException {

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("userss.dat"));
        return input.readObject();
    }

}