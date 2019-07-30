package vm;

import natives.Natives;
import optfunc.EnvOptInterpreter;
import stone.FuncParser;
import stone.ParseException;


public class VmInterpreter extends EnvOptInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new FuncParser(),
                new Natives().environment(new StoneVMEnv(100000, 100000, 1000)));
    }
}
