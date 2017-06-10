package Model;

import java.util.ArrayList;

/**
 * I just use Professor's code here and here is the like for video
 *
 *          https://youtu.be/hZeB8NArL2k
 *
 *          https://youtu.be/x9g-vXuHNkA
 *
 * A function checkForDatFile was added to create a .dat file when this program is first run without one.
 */

public class UserDB {

    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsersArrayList() {
        return users;
    }

    public static void setUsersArrayList(ArrayList<User> users) {
        UserDB.users = users;
    }


}