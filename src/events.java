import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class events implements ActionListener {

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == GUI.deleteButton) {
            GUI.openDeleteFrame();
        }//end if --- opens a frame for deleting a user

        if (e.getSource() == GUI.deleteUserButton) {
            queries.deleteUser();
        }//end if --- deletes a user

        if (e.getSource() == GUI.addButton) {
            GUI.addFrame();
        }//end if --- opens a frame for adding a new user
        if (e.getSource() == GUI.addUserButton) {
            queries.insertUser();
        }//end if --- inserts a new user
    }
}