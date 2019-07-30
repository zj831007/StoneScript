package testcase.LexerTest;

import stone.BasicParser;
import stone.Lexer;
import stone.ParseException;
import stone.Token;
import stone.ast.ASTree;

public class ParseRunner {
    public static void main(String[] args) throws ParseException{
        Lexer l = new Lexer(new CodeDialog());

        BasicParser bp = new BasicParser();
        while (l.peek(0) != Token.EOF){
            ASTree ast = bp.parse(l);
            System.out.println("=>" + ast.toString());
        }
    }
}
