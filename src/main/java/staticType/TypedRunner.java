package staticType;

import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class TypedRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(TypedInterpreter.class, args, TypeChecker.class,
                NativeEvaluator.class);
    }
}
