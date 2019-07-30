package staticType;

import java.util.List;

import eval.BasicEvaluator;
import eval.Environment;
import javassist.gluonj.*;
import optfunc.EnvOptimizer;
import optfunc.Symbols;
import stone.ast.*;


@Require(EnvOptimizer.class)
@Reviser public class TypedEvaluator {
    @Reviser public static class DefStmntEx extends EnvOptimizer.DefStmntEx {
        public DefStmntEx(List<ASTree> c) { super(c); }
        public TypeTag type() { return (TypeTag)child(2); }
        @Override public BlockStmnt body() { return (BlockStmnt)child(3); }
        @Override public String toString() {
            return "(def " + name() + " " + parameters() + " " + type() + " "
                    + body() + ")";
        }
    }
    @Reviser public static class ParamListEx extends EnvOptimizer.ParamsEx {
        public ParamListEx(List<ASTree> c) { super(c); }
        @Override public String name(int i) {
            return ((ASTLeaf)child(i).child(0)).token().getText();
        }
        public TypeTag typeTag(int i) {
            return (TypeTag)child(i).child(1);
        }
    }
    @Reviser public static class VarStmntEx extends VarStmnt {
        protected int index;
        public VarStmntEx(List<ASTree> c) { super(c); }
        public void lookup(Symbols syms) {
            index = syms.putNew(name());
            ((EnvOptimizer.ASTreeOptEx)initializer()).lookup(syms);
        }
        public Object eval(Environment env) {
            Object value = ((BasicEvaluator.ASTreeEx)initializer()).eval(env);
            ((EnvOptimizer.EnvEx2)env).put(0, index, value);
            return value;
        }
    }
}