package dao;

import model.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryCourseDao implements CourseDao {
  private List<Course> courseList;
  private static int id = 1;

  public InMemoryCourseDao() {
    courseList = new ArrayList<>();
  }

  @Override
  public void add(Course course) {
    courseList.add(course);
    course.setId(id++);
  }

  @Override
  public List<Course> findAll() {
    return Collections.unmodifiableList(courseList);
  }
}
