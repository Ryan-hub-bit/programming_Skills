package dao;

import model.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryReviewDao implements ReviewDao {

    private Map<Integer, List<Review>> reviewMap;
    private static int id = 1;

    public InMemoryReviewDao() {
        reviewMap = new HashMap<>();
    }

    @Override
    public void add(Review review) {
        List<Review> reviews = reviewMap.get(review.getCourseId());
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
        review.setId(id++);
        reviewMap.put(review.getCourseId(), reviews);
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        reviewMap.values().forEach(reviews::addAll);
        return Collections.unmodifiableList(reviews);
    }

    @Override
    public List<Review> findByCourseId(int courseId) {
        List<Review> reviews = reviewMap.get(courseId);
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        return Collections.unmodifiableList(reviews);
    }
}
