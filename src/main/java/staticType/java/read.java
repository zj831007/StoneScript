package staticType.java;

import optfunc.ArrayEnv;

import javax.swing.*;

public class read {
    public static String m(ArrayEnv env) { return m(); }
    public static String m() {
        return JOptionPane.showInputDialog(null);
    }
}