package com.moler.task.repository;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public List<Vehicle> getAll(VehicleQueryParameter parameter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root);
        TypedQuery<Vehicle> q = em.createQuery(query);
        List<Vehicle> vehicles = q.getResultList();

        if(parameter.getOffset() == null && parameter.getPoints() == null && parameter.getText() == null){
            filterPages(5, vehicles);
            return vehicles;
        }
        Integer offset = parameter.getOffset().orElse(5);
        Optional<String> text = parameter.getText();
        Optional<List<Integer>> points = parameter.getPoints();

        text.ifPresent(e -> filterByTitleOrDescription(e, vehicles));
        filterPages(offset, vehicles);
        points.ifPresent(e -> filterByPoints(e, vehicles));
        return vehicles;
    }

    private void filterPages(Integer offset, List<Vehicle> vehicles){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        CriteriaQuery<Vehicle> select = query.select(root);
        TypedQuery<Vehicle> typedQuery = em.createQuery(select);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(offset);

        vehicles.clear();
        vehicles.addAll(typedQuery.getResultList());
    }

    private void filterByPoints(List<Integer> points, List<Vehicle> vehicles){
        if(points.size() < 1)return;

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> vehicleRoot = query.from(Vehicle.class);

        List<Vehicle> vehiclesAtSamePoint = new ArrayList<>();
        for (Integer point : points) {
            query.where(builder.equal(vehicleRoot.get("point"),point));
            TypedQuery<Vehicle> qs = em.createQuery(query);
            vehiclesAtSamePoint.addAll(qs.getResultList());
        }

        vehicles.clear();
        vehicles.addAll(vehiclesAtSamePoint);
    }





    private void filterByTitleOrDescription(String text, List<Vehicle> vehicles) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root);

        Predicate likeTitle = builder.like(builder.upper(root.get("title")), "%" + text.toUpperCase() + "%");
        Predicate likeDescription = builder.like(builder.upper(root.get("description")), "%" + text.toUpperCase() + "%");
        Predicate isTextInTitleOrDescription = builder.or(likeTitle, likeDescription);

        query.where(isTextInTitleOrDescription);
        TypedQuery<Vehicle> q = em.createQuery(query);

        vehicles.clear();
        vehicles.addAll(q.getResultList());
    }




    @Transactional
    @Override
    public Vehicle save(Vehicle vehicle) {
         return em.merge(vehicle);
    }


}
