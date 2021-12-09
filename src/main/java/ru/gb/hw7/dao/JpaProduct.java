package ru.gb.hw7.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.hw7.entity.Manufacturer;
import ru.gb.hw7.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
@Transactional
public class JpaProduct implements ProductDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public void deleteAll(Collection<Product> products) {

    }

    @Override
    public void deleteById(Long id) {
        Product product = findById(id);
//        product.setId(id);
//        product = entityManager.merge(product);
        System.out.println(product);
        entityManager.remove(product);
    }

    @Override
    public void delete(Product product) {
        product = entityManager.merge(product);
        entityManager.remove(product);
    }

    @Override
    public Iterable<Product> sort(String sortOrder) {
        String query;
        switch (sortOrder){
            case "max":
                query = "select p from Product p ORDER BY p.cost";
                break;
            case "min":
                query = "select p from Product p ORDER BY p.cost DESC";
                break;
            default:
                query = "select p from Product p";
                break;
        }
        return entityManager.createQuery(query).getResultList();
    }
}
