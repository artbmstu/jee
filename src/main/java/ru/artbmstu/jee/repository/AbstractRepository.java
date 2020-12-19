package ru.artbmstu.jee.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

abstract class AbstractRepository {

    @PersistenceContext
    EntityManager em;

    <T> T getEntity(final TypedQuery<T> query){
        final List<T> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }
}