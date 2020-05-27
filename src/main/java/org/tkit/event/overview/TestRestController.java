package org.tkit.event.overview;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.tkit.event.overview.domain.daos.EventDao;
import org.tkit.event.overview.domain.daos.TopicDao;
import org.tkit.event.overview.domain.models.Event;
import org.tkit.event.overview.domain.models.Topic;
import org.tkit.event.overview.rs.internal.dtos.TopicDTO;
import org.tkit.event.overview.rs.internal.mappers.TopicMapper;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class TestRestController {

  @Inject
  private EventDao eventDao;

  @Inject
  private TopicDao topicDao;

  @Inject
  private TopicMapper topicMapper;

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
  public List<TopicDTO> getTopicsByEventId(@QueryParam("eventId") Integer eventId) {
    return topicDao.getAllTopics().stream()
        .map(topic -> topicMapper.map(topic))
        .collect(Collectors.toList());
  }

  @GET
  @Path("/topics-all")
  public List<Topic> getAllTopics() {
    return topicDao.getAllTopics();
  }

  @GET
  @Path("/init")
  @Transactional
  public Response init() {
    TopicDTO topic = new TopicDTO(1,"java", "Speaker", new Timestamp(123123), new Time(123));
    topicDao.save(topicMapper.map(topic));
    Event event = new Event();
    event.setDate(new Timestamp(1231231));
    event.setSubject("XDDDD test");
    eventDao.save(event);
    return Response.noContent().build();
  }

  @POST
  @Path("/topics")
  @Transactional
  public Response saveTopic(TopicDTO topic) {
    topicDao.save(topicMapper.map(topic));
    return Response.noContent().build();
  }
}