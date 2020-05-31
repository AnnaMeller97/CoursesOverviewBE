package org.tkit.event.overview;

import java.util.List;
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
import org.tkit.event.overview.domain.daos.CourseDao;
import org.tkit.event.overview.domain.daos.TopicDao;
import org.tkit.event.overview.domain.models.Topic;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/topic")
public class TopicController {

  @Inject
  private TopicDao topicDao;

  @POST
  @Path("/")
  @Transactional
  public Response saveTopic(Topic topic) {
    topicDao.save(topic);
    return Response.noContent().build();
  }

  @GET
  @Path("/")
  public List<Topic> getTopicsByCourseId(@QueryParam("courseId") Integer courseId) {
    return topicDao.getTopicsByCourseId(courseId);
  }
}