package dao;

import model.Course;

import java.util.List;

public interface CourseDao {
  void add(Course course);
  List<Course> findAll();
}
