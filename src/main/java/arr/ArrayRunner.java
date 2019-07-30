package arr;

import cls.ClassEvaluator;
import cls.ClassInterpreter;
import func.ClosureEvaluator;
import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class ArrayRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClassInterpreter.class, args, ClassEvaluator.class,
                ArrayEvaluator.class, NativeEvaluator.class,
                ClosureEvaluator.class);
    }
}
