package com.moler.task.repository;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    @Override
    public List<Vehicle> getAllVehicles(VehicleQueryParameter parameter) {
        Integer offset = parameter.getOffset();
        String text = parameter.getText();
        List<Integer> points = parameter.getPoints();

        List<Vehicle> filteredVehiclesByTitleOrDescription = filterByTitleOrDescription(text);
        return filteredVehiclesByTitleOrDescription;
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
//        Root<Vehicle> root = query.from(Vehicle.class);
//        query.select(root);
//        TypedQuery<Vehicle> q = em.createQuery(query);
//        query.groupBy(root.get("id"));
//        List<Vehicle> result =  q.getResultList();
//        return result;

    }

    private List<Vehicle> filterByTitleOrDescription(String text) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root);

        Predicate likeTitle = builder.like(builder.upper(root.get("title")), "%" + text.toUpperCase() + "%");
        Predicate likeDescription = builder.like(builder.upper(root.get("description")), "%" + text.toUpperCase() + "%");
        Predicate isTextInTitleOrDescription = builder.or(likeTitle, likeDescription);

        query.where(isTextInTitleOrDescription);
        TypedQuery<Vehicle> q = em.createQuery(query);

        return q.getResultList();
    }

    @Transactional
    @Override
    public Vehicle getVehicleByTitle(String title) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root).where(builder.equal(root.get("title"), title));
        TypedQuery<Vehicle> q = em.createQuery(query);
        Vehicle vehicle = q.getSingleResult();
        return vehicle;
    }

    @Override
    public Vehicle getVehicleByDescription(String description) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root).where(builder.equal(root.get("description"), description));
        TypedQuery<Vehicle> q = em.createQuery(query);
        Vehicle vehicle = q.getSingleResult();
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicleAtPoint(Point point) {
        return null;
    }

    @Transactional
    @Override
    public void save(Vehicle vehicle) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(vehicle);
        //em.merge(vehicle);
    }
}
