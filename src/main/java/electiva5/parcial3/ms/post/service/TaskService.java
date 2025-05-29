package electiva5.parcial3.ms.post.service;

import org.springframework.stereotype.Service;

import electiva5.parcial3.ms.post.dto.TaskRequest;
import electiva5.parcial3.ms.post.model.Task;
import electiva5.parcial3.ms.post.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task createTask(TaskRequest taskRequest) {
        Task task = Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .status(taskRequest.getStatus())
                .build();
        return taskRepository.save(task);
    }
}
