package io.javabrains.springbootstarter.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
		public List<Lesson> getAllLessons(String courseId){
			List<Lesson> lessons = new ArrayList<>();
			lessonRepository.findByCourseId(courseId)
			.forEach(lessons::add);
			System.out.println("All courses are"+lessons);
			return lessons;
		}
		
		public Lesson getCourse(String id) {
			Lesson lessonNew = new Lesson();
			Optional<Lesson> CourseVal = lessonRepository.findById(id);
			if(CourseVal.isPresent()) {
				lessonNew = CourseVal.get();
			} else {
				System.out.println("NO RECORDS FOUND");
			}
			return lessonNew;
		}

		public void addCourse(Lesson lesson) {
			lessonRepository.save(lesson);
		}

		public void updateCourse(Lesson lesson) {
			lessonRepository.save(lesson);
		}

		public void deleteCourse(String id) {
			lessonRepository.deleteById(id);
		}
}

