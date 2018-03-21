package com.moler.task.repository;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public List<Vehicle> getAllVehicles(Optional<Integer> offset, Optional<String> text, Optional<List<Integer>> points) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root);
        TypedQuery<Vehicle> q = em.createQuery(query);
        List<Vehicle> vehicles = q.getResultList();

        text.ifPresent(e -> filterByTitleOrDescription(e, vehicles));
        //Przetestowac to jak bedzie inne dzialac
        //offset.ifPresent(e -> filterPages(e, vehicles));
        //points.ifPresent(e -> filterByPoints(e, vehicles));



        return vehicles;
    }

    @Transactional
    @Override
    public List<Vehicle> getAllVehicles(VehicleQueryParameter parameter) {
        Integer offset = parameter.getOffset().orElse(1);
        String text = parameter.getText().orElse("");
        List<Integer> points = parameter.getPoints().orElse(null);



        //List<Vehicle> filteredVehiclesByTitleOrDescription = filterByTitleOrDescription(text);
        //return filteredVehiclesByTitleOrDescription;
        return null;
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
//        Root<Vehicle> root = query.from(Vehicle.class);
//        query.select(root);
//        TypedQuery<Vehicle> q = em.createQuery(query);
//        query.groupBy(root.get("id"));
//        List<Vehicle> result =  q.getResultList();
//        return result;

    }

    private List<Vehicle> filterPages(Integer offset, List<Vehicle> vehicles){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        CriteriaQuery<Vehicle> select = query.select(root);
        TypedQuery<Vehicle> typedQuery = em.createQuery(select);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(offset);

        vehicles.clear();
        vehicles = typedQuery.getResultList();


        return vehicles;
    }

    private List<Vehicle> filterByPoints(List<Integer> points, List<Vehicle> vehicles){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        CriteriaQuery<Vehicle> select = query.select(root);



        List<Predicate> conditions = new ArrayList<>();

        for (Integer point : points) {
            conditions.add(builder.equal(root.get("point_id"), point));
        }

        query.where(conditions.toArray(new Predicate[0]));
        TypedQuery<Vehicle> q = em.createQuery(query);

        vehicles.clear();
        vehicles = q.getResultList();


        return vehicles;
    }





    private List<Vehicle> filterByTitleOrDescription(String text, List<Vehicle> vehicles) {
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

        vehicles =  q.getResultList();
        return vehicles;
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
    public void save(VehicleParameter vehicle) {
        em.merge(vehicle);
    }


}
