package org.tkit.event.overview.domain.daos;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.tkit.event.overview.domain.models.Topic;

@ApplicationScoped
public class TopicDao {

  @Inject
  EntityManager manager;

  public List<Topic> getTopicsByCourseId(Integer id) {
    TypedQuery<Topic> query = manager
        .createQuery("SELECT t FROM Topic t WHERE t.courseId = :courseId", Topic.class);
    query.setParameter("courseId", id);
    return query.getResultList();
  }

  public void save(Topic topic) {
    manager.persist(topic);
  }
}
