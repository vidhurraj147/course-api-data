package io.javabrains.springbootstarter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
		public List<Course> getAllCourses(String topicId){
			List<Course> courses = new ArrayList<>();
			courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
			System.out.println("All courses are"+courses);
			return courses;
		}
		
		public Course getCourse(String id) {
			Course CourseNew = new Course();
			Optional<Course> CourseVal = courseRepository.findById(id);
			if(CourseVal.isPresent()) {
				CourseNew = CourseVal.get();
			} else {
				System.out.println("NO RECORDS FOUND");
			}
			return CourseNew;
		}

		public void addCourse(Course course) {
			courseRepository.save(course);
		}

		public void updateCourse(Course course) {
			courseRepository.save(course);
		}

		public void deleteCourse(String id) {
			courseRepository.deleteById(id);
		}
}

