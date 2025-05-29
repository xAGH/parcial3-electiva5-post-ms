package electiva5.parcial3.ms.post.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import electiva5.parcial3.ms.post.dto.ApiResponse;
import electiva5.parcial3.ms.post.dto.TaskRequest;
import electiva5.parcial3.ms.post.model.Task;
import electiva5.parcial3.ms.post.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class PostController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<ApiResponse<Task>> createTask(@RequestBody @Valid TaskRequest task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.ok(new ApiResponse<>(true, "Task created", created));
    }
}
