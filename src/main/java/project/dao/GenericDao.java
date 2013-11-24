package project.dao;

import project.model.EntityBase;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenericDao {

    @PersistenceContext(name = "persistenceUnit")
    protected EntityManager entityManager;

    public <T extends EntityBase> List<T> findAll(Class<T> entityClass) {
        return entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
    }

    public <T extends EntityBase> T saveOrUpdate(T entity) {
        T savedEntity = entityManager.merge(entity);
        entityManager.flush();
        return savedEntity;
    }

    public <T extends EntityBase> T findById(Class<T> entityClass, Object entity) {
        return (T)entityManager.find(entityClass, entity);
    }

    public <T extends EntityBase> void delete(Object entity) {
        entityManager.remove(entity);
    }
}