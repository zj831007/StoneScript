package cls;

import func.ClosureEvaluator;
import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;


public class ClassRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClassInterpreter.class, args, ClassEvaluator.class,
                NativeEvaluator.class, ClosureEvaluator.class);
    }
}
