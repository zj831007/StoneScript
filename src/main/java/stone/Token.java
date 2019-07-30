package stone;

public abstract class Token {
    public static final Token EOF = new Token(-1) { };
    public static final  String EOL = "\\n";
    private int lineNumber;

    protected Token(int line){
        lineNumber = line;
    }

    public int getLineNumber(){return lineNumber;}
    public boolean isIdentifier(){return false;}  //标识符，变量名，函数名，类名，运算符，括号
    public boolean isNumber(){return false;} //数字
    public boolean isString(){return false;}  //字符串
    public int getNumber(){throw new StoneException("not number token");}
    public String getText(){return "";}
}
