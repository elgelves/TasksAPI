package elgelves.tasks.controller;

import elgelves.tasks.model.Task;
import elgelves.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    List<Task> index(){
        return taskRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Task create(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("{id}")
    Task update(@PathVariable String id, @RequestBody Task task){
        Task taskDB = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        taskDB.setName(task.getName());
        taskDB.setFinished(task.isFinished());
        return taskRepository.save(taskDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        taskRepository.delete(task);
    }

}
