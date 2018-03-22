package com.moler.task.repository;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private static final int RESULTS_ON_PAGE = 5;
    @PersistenceContext private EntityManager em;

    @Transactional
    @Override
    public List<Vehicle> getAll(VehicleQueryParameter parameter) {
        int offset = parameter.getOffset().orElse(0);
        Optional<List<Integer>> points = parameter.getPoints();
        Optional<String> text = parameter.getText();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> q = cb.createQuery(Vehicle.class);
        Root<Vehicle> vehicle = q.from(Vehicle.class);
        List<Predicate> predicates = new ArrayList<>();

        if (text.isPresent()) {
            Predicate titleLike = cb.like(cb.upper(vehicle.get("title")), "%" + text.get().toUpperCase() + "%");
            Predicate descriptionLike = cb.like(cb.upper(vehicle.get("description")), "%" + text.get().toUpperCase() + "%");
            predicates.add(cb.or(titleLike, descriptionLike));
        }

        if (points.isPresent() && !points.get().isEmpty()) {
            Join<Vehicle, Point> point = vehicle.join("point");
            Predicate pointIdIn = point.get("id").in(points.get());
            predicates.add(pointIdIn);
        }

        q.select(vehicle);
        q.where(predicates.toArray(new Predicate[predicates.size()]));
        return em.createQuery(q).setMaxResults(RESULTS_ON_PAGE).setFirstResult(offset).getResultList();
    }


    @Transactional
    @Override
    public Vehicle save(Vehicle vehicle) {
        return em.merge(vehicle);
    }
}

