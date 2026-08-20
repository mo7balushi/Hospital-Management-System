package interfaces;

public interface Manageable {

    void add(Object entity);

    boolean removeById(String id);

    Object[] getAll();
}