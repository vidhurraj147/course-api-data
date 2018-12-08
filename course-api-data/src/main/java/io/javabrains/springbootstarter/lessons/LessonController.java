package io.javabrains.springbootstarter.lessons;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.courses.Course;
import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		System.out.println("lesson is "+lesson);
		lesson.setTopic(new Topic(topicId,"",""));
		lesson.setCourse(new Course(courseId,"","",topicId));
		lessonService.addCourse(lesson);
	}
	
	@RequestMapping("/topics/{id}/courses/{cid}/lessons/id")
	public List<Lesson> getAllCourses(@PathVariable String cid) {
		System.out.println("recevied id "+cid);
		return lessonService.getAllLessons(cid);
	}
	
//	@RequestMapping("/topics/{topicId}/courses/{id}")
//	public Lesson getCourse(@PathVariable String id) {
//		return lessonService.getCourse(id);
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
//	public void updateCourse(@RequestBody Lesson course, @PathVariable String topicId, @PathVariable String id) {
//		System.out.println("Course is "+course);
//		course.setTopic(new Topic(topicId,"",""));
//		lessonService.updateCourse(course);
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
//	public void deleteTopic(@PathVariable String id) {
//		lessonService.deleteCourse(id);
//	}
	
}
