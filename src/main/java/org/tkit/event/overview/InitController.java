package org.tkit.event.overview;

import java.math.BigDecimal;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.tkit.event.overview.domain.daos.CourseDao;
import org.tkit.event.overview.domain.daos.TopicDao;
import org.tkit.event.overview.domain.models.Course;
import org.tkit.event.overview.domain.models.Topic;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class InitController {

  @Inject
  private CourseDao courseDao;

  @Inject
  private TopicDao topicDao;

  @GET
  @Path("/init")
  @Transactional
  @Deprecated
  public Response init() {
    Course course = new Course("Java", BigDecimal.valueOf(599.99));
    Topic topic = new Topic(1, "Wstęp", "Jan Nowak");
    courseDao.save(course);
    topicDao.save(topic);
    return Response.noContent().build();
  }
}