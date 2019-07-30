package func;
import eval.BasicInterpreter;
import stone.FuncParser;
import stone.ParseException;


public class FuncInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new FuncParser(), new NestedEnv());
    }
}
