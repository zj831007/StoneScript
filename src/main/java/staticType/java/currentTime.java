package staticType.java;

import optfunc.ArrayEnv;

public class currentTime {
    private static long startTime = System.currentTimeMillis();
    public static int m(ArrayEnv env) { return m(); }
    public static int m() {
        return (int)(System.currentTimeMillis() - startTime);
    }
}
