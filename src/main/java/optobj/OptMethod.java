package optobj;


import eval.Environment;
import optfunc.ArrayEnv;
import optfunc.OptFunction;
import stone.ast.BlockStmnt;
import stone.ast.ParameterList;

public class OptMethod extends OptFunction {
    OptStoneObject self;
    public OptMethod(ParameterList parameters, BlockStmnt body,
                     Environment env, int memorySize, OptStoneObject self)
    {
        super(parameters, body, env, memorySize);
        this.self = self;
    }
    @Override public Environment makeEnv() {
        ArrayEnv e = new ArrayEnv(size, env);
        e.put(0, 0, self);
        return e;
    }
}
