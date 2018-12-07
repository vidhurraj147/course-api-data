package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicrepository;
	
	List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("1spring", "1 java", "1 some"),
			new Topic("2spring", "2 java", "2 some"),
			new Topic("3spring", "3 java", "3 some"),
			new Topic("4spring", "4 java", "4 some"),
			new Topic("5spring", "5 java", "5 some"),
			new Topic("6spring", "6 java", "6 some")
			));

		public List<Topic> getAllTopics(){
			// return topics;
//			List<Topic> topics = new ArrayList<>();
//			topicrepository.findAll()
//			.forEach(topics::add);
//			return topics;
			List<Topic> topics = new ArrayList<>();
			topicrepository.findAll()
			.forEach(topics::add);
			return topics;
		}
		
		public Topic getTopic(String id) {
			// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			Topic topicNew = new Topic();
			Optional<Topic> topicVal = topicrepository.findById(id);
			if(topicVal.isPresent()) {
				topicNew = topicVal.get();
			} else {
				System.out.println("NO RECORDS FOUND");
			}
			
			return topicNew;
		}

		public void addTopic(Topic topic) {
			// topics.add(topic);
			topicrepository.save(topic);
		}

		public void updateTopic(String id, Topic topic) {
			topicrepository.save(topic);
//			int count = 0;
//			for(Topic t : topics) {
//				if(t.getId().equals(id)){
//					topics.set(count, topic);
//					return;
//				}
//				count++;
//			}
			
		}

		public void deleteTopic(String id) {
			topicrepository.deleteById(id);
			// topics.removeIf(t -> t.getId().equals(id));
		}
//			int count = 0;
//			for(Topic t : topics) {
//				if(t.getId().equals(id)){
//					// topics.set(count, topic);
//					topics.remove(t);
//					return;
//				}
//				count++;
//			}
//		}
}

