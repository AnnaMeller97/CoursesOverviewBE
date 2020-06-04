package org.tkit.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tkit.event.overview.domain.daos.CourseDao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CourseControllerTest {

    @Inject
    private CourseDao courseDao;

    @Test
    public void testSaveCourse() {
        Assertions.assertTrue(courseDao.getAllCourses().isEmpty());
        given()
            .contentType(ContentType.JSON)
            .body("{"
                + "\"subject\": \"Test\","
                + "\"price\": 12.69"
                + "}")
            .post("/course");

        Assertions.assertEquals(1, courseDao.getAllCourses().size());
        Assertions.assertTrue(courseDao.getAllCourses().stream()
            .anyMatch(saved -> saved.getSubject().equals("Test")));
    }
}