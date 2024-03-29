package optobj;

import cls.ClassInfo;
import eval.Environment;
import optfunc.Symbols;
import stone.ast.ClassStmnt;
import stone.ast.DefStmnt;

import java.util.ArrayList;

public class OptClassInfo extends ClassInfo {
    protected Symbols methods, fields;
    protected DefStmnt[] methodDefs;
    public OptClassInfo(ClassStmnt cs, Environment env, Symbols methods,
                        Symbols fields)
    {
        super(cs, env);
        this.methods = methods;
        this.fields = fields;
        this.methodDefs = null;
    }
    public int size() { return fields.size(); }
    @Override public OptClassInfo superClass() {
        return (OptClassInfo)superClass;
    }
    public void copyTo(Symbols f, Symbols m, ArrayList<DefStmnt> mlist) {
        f.append(fields);
        m.append(methods);
        for (DefStmnt def: methodDefs)
            mlist.add(def);
    }
    public Integer fieldIndex(String name) { return fields.find(name); }
    public Integer methodIndex(String name) { return methods.find(name); }
    public Object method(OptStoneObject self, int index) {
        DefStmnt def = methodDefs[index];
        return new OptMethod(def.parameters(), def.body(), environment(),
                ((ObjOptimizer.DefStmntEx2)def).locals(), self);
    }
    public void setMethods(ArrayList<DefStmnt> methods) {
        methodDefs = methods.toArray(new DefStmnt[methods.size()]);
    }
}