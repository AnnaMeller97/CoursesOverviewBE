package org.tkit.event.overview.rs.internal.controllers;

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
import org.tkit.event.overview.domain.models.Course;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/course")
public class CourseController {

  @Inject
  private CourseDao courseDao;

  @GET
  public List<Course> getAllCourses() {
    return courseDao.getAllCourses();
  }

  @POST
  @Transactional
  public Response saveCourse(Course course) {
    courseDao.save(course);
    return Response.noContent().build();
  }
}