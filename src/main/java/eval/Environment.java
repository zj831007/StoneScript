package eval;

public interface Environment {

    void put(String name, Object value);
    Object get(String name);

}
