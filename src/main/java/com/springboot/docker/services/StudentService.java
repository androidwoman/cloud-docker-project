package com.springboot.docker.services;

import com.springboot.docker.dto.StudentDTO;
import com.springboot.docker.models.Student;
import com.springboot.docker.repositories.studentRepo;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Description(value = "Example service that is responsible for business logic.")
@Service
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    private studentRepo studentRepo;

    /**
     * Constructor dependency injection.
     * @param studentRepo - example repository layer.
     */
    public StudentService(studentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * Method for getting example entity by id.
     *
     * @return Optional of ExampleEntity
     */
    public Optional<Student> getOneExampleEntity(Integer id) {
        return studentRepo.findById(id);
    }


    /**
     * Method for getting example by JPA typed query
     *
     * @param id - example identifier
     * @return Optional of Example Entity
     */
    public Optional<Student> getExampleByTypedQuery(Integer id)
    {
        String query = "SELECT e FROM Student e WHERE id = :id";
        TypedQuery<Student> entityTypedQuery = entityManager.createQuery(query, Student.class);
        entityTypedQuery.setParameter("id", id);

        return Optional.ofNullable(entityTypedQuery.getSingleResult());
    }

    /**
     * Method for getting list of examples with JPA native query
     *
     * @return List of Example Entity
     */
    @SuppressWarnings("unchecked")
    public List<Student> getAllNative()
    {
        String nativeQuery = "SELECT id, property_one, property_two FROM example";
        Query query = entityManager.createNativeQuery(nativeQuery, Student.class);

        return (List<Student>) query.getResultList();
    }

    /**
     * Mapping native query to custom DTO class
     *
     * @return List of Example DTO
     */
    @SuppressWarnings("unchecked")
    public List<StudentDTO> getAllDTO()
    {
        return entityManager.createNativeQuery("SELECT property_one as propOne, property_two as propTwo FROM example")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(StudentDTO.class))
                .getResultList();
    }
}
