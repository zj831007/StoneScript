package optfunc;

import javassist.gluonj.util.Loader;
import natives.NativeEvaluator;

public class EnvOptRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(EnvOptInterpreter.class, args, EnvOptimizer.class,
                NativeEvaluator.class);
    }
}
