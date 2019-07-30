package cls;

import eval.BasicInterpreter;
import func.NestedEnv;
import natives.Natives;
import stone.ClassParser;
import stone.ParseException;


public class ClassInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClassParser(), new Natives().environment(new NestedEnv()));
    }
}
