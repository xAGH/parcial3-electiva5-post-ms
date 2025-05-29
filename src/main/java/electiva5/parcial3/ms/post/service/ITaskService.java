package electiva5.parcial3.ms.post.service;

import electiva5.parcial3.ms.post.dto.TaskRequest;
import electiva5.parcial3.ms.post.model.Task;

public interface ITaskService {
    Task createTask(TaskRequest taskrequest);
}
