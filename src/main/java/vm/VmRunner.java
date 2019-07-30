package vm;


import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class VmRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(VmInterpreter.class, args, VmEvaluator.class,
                NativeEvaluator.class);
    }
}
