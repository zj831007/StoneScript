package optobj;


import natives.Natives;
import optfunc.EnvOptInterpreter;
import optfunc.ResizableArrayEnv;
import stone.ClassParser;
import stone.ParseException;

public class ObjOptInterpreter extends EnvOptInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClassParser(),
                new Natives().environment(new ResizableArrayEnv()));
    }
}
