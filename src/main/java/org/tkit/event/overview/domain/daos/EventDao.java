package org.tkit.event.overview.domain.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.tkit.event.overview.domain.models.Event;

@ApplicationScoped
public class EventDao {

  private List<Event> eventList;

  public EventDao() {
    eventList = new ArrayList<>();
    eventList.add(new Event(12, "Java", new Timestamp(15)));
  }

  public List<Event> getAllEvents() {
    return eventList;
  }
}
