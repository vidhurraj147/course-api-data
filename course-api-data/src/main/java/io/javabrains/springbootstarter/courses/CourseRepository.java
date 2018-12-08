package io.javabrains.springbootstarter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseRepository extends CrudRepository<Course, String> {
	
//	public List<Course> findByName(String name);
//	public List<Course> findByDescription(String name);
	public List<Course> findByTopicId(String topicId);
}
