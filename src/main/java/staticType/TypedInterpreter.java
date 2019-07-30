package staticType;

import eval.BasicEvaluator;
import eval.Environment;
import optfunc.EnvOptimizer;
import optfunc.ResizableArrayEnv;
import stone.BasicParser;
import stone.Lexer;
import stone.Token;
import stone.TypedParser;
import stone.ParseException;
import stone.ast.ASTree;
import stone.ast.NullStmnt;
import testcase.LexerTest.CodeDialog;


public class TypedInterpreter {
    public static void main(String[] args) throws ParseException, TypeException {
        TypeEnv te = new TypeEnv();
        run(new TypedParser(),
                new TypedNatives(te).environment(new ResizableArrayEnv()),
                te);
    }
    public static void run(BasicParser bp, Environment env, TypeEnv typeEnv)
            throws ParseException, TypeException
    {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree tree = bp.parse(lexer);
            if (!(tree instanceof NullStmnt)) {
                ((EnvOptimizer.ASTreeOptEx)tree).lookup(
                        ((EnvOptimizer.EnvEx2)env).symbols());
                TypeInfo type
                        = ((TypeChecker.ASTreeTypeEx)tree).typeCheck(typeEnv);
                Object r = ((BasicEvaluator.ASTreeEx)tree).eval(env);
                System.out.println("=> " + r + " : " + type);
            }
        }
    }
}
