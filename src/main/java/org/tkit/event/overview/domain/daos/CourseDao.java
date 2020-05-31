package org.tkit.event.overview.domain.daos;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.tkit.event.overview.domain.models.Course;

@ApplicationScoped
public class CourseDao {

  @Inject
  EntityManager manager;

  public List<Course> getAllCourses() {
    TypedQuery<Course> query = manager.createQuery("SELECT c FROM Course c", Course.class);
    return query.getResultList();
  }

  public void save(Course course) {
    manager.persist(course);
  }
}
