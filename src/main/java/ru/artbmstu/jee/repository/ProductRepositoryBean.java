package ru.artbmstu.jee.repository;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.ProductEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class ProductRepositoryBean extends AbstractRepository implements ProductRepository {


    @Override
    public List<ProductEntity> findAll() {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<ProductEntity> criteriaQuery = criteriaBuilder.createQuery(ProductEntity.class);
        final TypedQuery<ProductEntity> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }


    @Override
    public ProductEntity getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return getEntity(em.createQuery("select e from ProductEntity e where e.idproduct = :id", ProductEntity.class)
                .setParameter("id", id)
                .setMaxResults(1));
    }

    @Override
    public ProductEntity findById(String id) {
        return em.find(ProductEntity.class, id);
    }

    @Override
    public ProductEntity persist(ProductEntity productEntity) {
        if (productEntity == null) return null;
        em.persist(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity merge(ProductEntity productEntity) {
        if (productEntity == null) return null;
        return em.merge(productEntity);
    }

    @Override
    public void removeProductEntity(ProductEntity productEntity) {
        if (productEntity != null) em.remove(productEntity);
    }

    @Override
    public void removeById(String id) {
        if (id != null && !id.isEmpty()) em.createQuery("delete from ProductEntity e where e.idproduct = :id");
    }

    @Override
    public void removeAll() {
        em.createQuery("delete from ProductEntity").executeUpdate();
    }
}