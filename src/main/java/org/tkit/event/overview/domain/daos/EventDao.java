package org.tkit.event.overview.domain.daos;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.tkit.event.overview.domain.models.Event;

@ApplicationScoped
public class EventDao {

  @Inject
  EntityManager manager;

  public List<Event> getAllEvents() {
    TypedQuery<Event> query = manager.createQuery("SELECT e FROM Event e", Event.class);
    return query.getResultList();
  }

  public void save(Event event) {
    manager.persist(event);
  }
}
