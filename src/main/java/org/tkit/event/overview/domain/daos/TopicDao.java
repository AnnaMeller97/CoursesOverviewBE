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

  public TopicDao(EntityManager manager) {
    this.manager = manager;
  }

  public List<Topic> getAllTopics() {
    TypedQuery<Topic> query = manager.createQuery("SELECT t FROM Topic t", Topic.class);
    return query.getResultList();
  }

  public List<Topic> getTopicsByEventId(Integer eventId) {
    return List.of();
  }
}
