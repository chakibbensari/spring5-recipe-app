package guru.springframework.services;

import java.util.Set;

public interface CRUDService<T, ID> {

    public T findById(ID id);

    public Set<T> findAll();

    public T save(T t);

    public void delete(T t);

    public void deleteById(ID id);
}
