package com.in28minutes.database.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.jpa.model.PersonEntity;

@Repository
@Transactional // para insert updates e removes ACID
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public PersonEntity findById(Integer id) {
		return this.entityManager.find(PersonEntity.class, id);
	}

	public List<PersonEntity> findAll() {
		return this.entityManager.createQuery("select p from PersonEntity p", PersonEntity.class).getResultList();
	}

	public Integer count() {
		return this.findAll().size();
	}

	public void deleteById(Integer id) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaDelete<PersonEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(PersonEntity.class);
		Root<PersonEntity> root = criteriaDelete.from(PersonEntity.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));

		this.entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	public List<PersonEntity> findByName(String name) {
		TypedQuery<PersonEntity> query = this.entityManager.createQuery("select p from PersonEntity p where name like :name ",
				PersonEntity.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	public List<PersonEntity> findByLocation(String location) {
		TypedQuery<PersonEntity> query = this.entityManager.createQuery("select p from PersonEntity p where location like :location ",
				PersonEntity.class);
		query.setParameter("location", "%" + location + "%");
		return query.getResultList();
	}

	public void insert(PersonEntity person) {
		this.entityManager.persist(person);
	}

	public void update(PersonEntity person) {
		this.entityManager.merge(person);
	}
}