package dao;

import model.Review;

import java.util.List;

public interface ReviewDao {
  void add(Review review);
  List<Review> findAll();
  List<Review> findByCourseId(int courseId);
}
