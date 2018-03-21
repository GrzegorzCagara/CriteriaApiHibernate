package com.moler.task.repository;

import com.moler.task.entity.Point;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PointRepositoryImpl implements PointRepository{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<Point> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Point> query = builder.createQuery(Point.class);
        Root<Point> root = query.from(Point.class);
        query.select(root);
        TypedQuery<Point> q = em.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void save(Point point) {
        em.merge(point);
    }

    @Override
    @Transactional
    public Point getPointById(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Point> query = builder.createQuery(Point.class);
        Root<Point> root = query.from(Point.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Point> q = em.createQuery(query);
        return q.getSingleResult();
    }
}
