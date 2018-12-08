package io.javabrains.springbootstarter.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LessonRepository extends CrudRepository<Lesson, String> {
	
//	public List<Course> findByName(String name);
//	public List<Course> findByDescription(String name);
	public List<Lesson> findByCourseId(String courseId);
}
