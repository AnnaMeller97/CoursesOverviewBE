package org.tkit.event.overview;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.tkit.event.overview.domain.daos.CourseDao;
import org.tkit.event.overview.domain.daos.TopicDao;
import org.tkit.event.overview.domain.models.Course;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/course")
public class CourseController {

  @Inject
  private CourseDao courseDao;

  @GET
  @Path("/")
  public List<Course> getAllCourses() {
    return courseDao.getAllCourses();
  }

  @POST
  @Path("/")
  @Transactional
  public Response saveCourse(Course course) {
    courseDao.save(course);
    return Response.noContent().build();
  }
}