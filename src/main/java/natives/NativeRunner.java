package natives;
import func.ClosureEvaluator;
import javassist.gluonj.util.Loader;


public class NativeRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(NativeInterpreter.class, args, NativeEvaluator.class,
                ClosureEvaluator.class);
    }
}
