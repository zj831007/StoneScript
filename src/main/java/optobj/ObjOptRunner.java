package optobj;

import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class ObjOptRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ObjOptInterpreter.class, args, ObjOptimizer.class,
                NativeEvaluator.class);
    }
}
