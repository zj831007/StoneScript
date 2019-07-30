package staticType;

import eval.Environment;
import natives.Natives;
import optfunc.EnvOptimizer;

public class TypedNatives extends Natives {
    protected TypeEnv typeEnv;
    public TypedNatives(TypeEnv te) { typeEnv = te; }
    protected void append(Environment env, String name, Class<?> clazz,
                          String methodName, TypeInfo type, Class<?> ... params)
    {
        append(env, name, clazz, methodName, params);
        int index = ((EnvOptimizer.EnvEx2)env).symbols().find(name);
        typeEnv.put(0, index, type);
    }
    protected void appendNatives(Environment env) {
        append(env, "print", staticType.java.print.class, "m",
                TypeInfo.function(TypeInfo.INT, TypeInfo.ANY),
                Object.class);
        append(env, "read", staticType.java.read.class, "m",
                TypeInfo.function(TypeInfo.STRING));
        append(env, "length", staticType.java.length.class, "m",
                TypeInfo.function(TypeInfo.INT, TypeInfo.STRING),
                String.class);
        append(env, "toInt", staticType.java.toInt.class, "m",
                TypeInfo.function(TypeInfo.INT, TypeInfo.ANY),
                Object.class);
        append(env, "currentTime", staticType.java.currentTime.class, "m",
                TypeInfo.function(TypeInfo.INT));
    }
}
