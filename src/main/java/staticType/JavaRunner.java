package staticType;

import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class JavaRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(TypedInterpreter.class, args, ToJava.class,
                InferFuncTypes.class, NativeEvaluator.class);
    }
}
