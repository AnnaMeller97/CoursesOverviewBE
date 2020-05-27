package org.tkit.event.overview;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.tkit.event.overview.domain.daos.EventDao;
import org.tkit.event.overview.domain.daos.TopicDao;
import org.tkit.event.overview.domain.models.Event;
import org.tkit.event.overview.domain.models.Topic;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Path("/")
public class TestRestController {

  @Inject
  private EventDao eventDao;

  @Inject
  private TopicDao topicDao;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/hello")
  public String hello() {
    return "hello";
  }

  @GET
  @Path("/events")
  public List<Event> getAllEvents() {
    return eventDao.getAllEvents();
  }

  @GET
  @Path("/topics")
  public List<Topic> getTopicsByEventId(@QueryParam("eventId") Integer eventId) {
    return topicDao.getTopicsByEventId(eventId);
  }

  @GET
  @Path("/topics-all")
  public List<Topic> getAllTopics() {
    return topicDao.getAllTopics();
  }
//return Response.ok(entities).build();
//return Response.noContent().build();
}