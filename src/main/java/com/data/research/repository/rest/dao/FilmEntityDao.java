package com.data.research.repository.rest.dao;

import com.data.research.model.rest.FIlmEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FilmEntityDao{
    private EntityManager entityManager;

    public List<FIlmEntity> findByCriteria(String filmName){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FIlmEntity> query = builder.createQuery(FIlmEntity.class);
        Root<FIlmEntity> root = query.from(FIlmEntity.class);

        Predicate hasFilmName =
            builder.or(
                builder.like(builder.lower(root.get("name")),"%" + filmName + "%" ),
                    builder.like(root.get("name"), "%" + filmName + "%")
            );
        query
                .where(builder.and(hasFilmName));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
