package natives;

import eval.BasicInterpreter;
import func.NestedEnv;
import stone.ClosureParser;
import stone.ParseException;


public class NativeInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(),
                new Natives().environment(new NestedEnv()));
    }
}
