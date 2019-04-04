/*
 */
package util;

import java.awt.Font;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * Zach Tarell - public class IO for Project4a and Project5
 */
public class IO {

    public static Scanner getInput(String prompt) { // A method asking for GUI input that will return a scanner object. The prompt is sent as the parameter.
        String s = JOptionPane.showInputDialog(prompt);
        return new Scanner(s);
    }

    public static Scanner getConsoleInput(String prompt) { // A method asking for console input that will return a scanner object. The prompt is sent as the parameter.
        System.out.println(prompt);
        return new Scanner(System.in);
    }

    public static void showMessage(String s) { // A method taking a string as the parameter which displays the message in a dialog and on the console (with setFont).
        System.out.println(s);
        JTextArea jta = new JTextArea(s);
        jta.setFont(new Font("Consolas", Font.ITALIC, 72));
        JOptionPane.showMessageDialog(null, jta);
    }

    public static void showMessage(String output, String result) {
        System.out.printf(result + "\n" + output); // without font this line stays the same
        JTextArea jta = new JTextArea(result + "\n" + output); // without font this line is not here
        jta.setFont(new Font("Consolas", Font.ITALIC, 72)); // without font this line is not here
        JOptionPane.showMessageDialog(null, jta, result, JOptionPane.PLAIN_MESSAGE); // without font, this line is JOptionPane.showMessageDialog(null, output, title, JOptionPane.PLAIN_MESSAGE);
    }
}
