package elgelves.tasks.repository;

import elgelves.tasks.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository <Task, String> {
}
