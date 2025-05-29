package electiva5.parcial3.ms.post.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import electiva5.parcial3.ms.post.dto.ApiResponse;
import electiva5.parcial3.ms.post.dto.TaskRequest;
import electiva5.parcial3.ms.post.model.Task;
import electiva5.parcial3.ms.post.service.TaskService;

@ActiveProfiles("test")
public class PostControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private PostController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("Nueva tarea");
        request.setDescription("Descripción");

        Task createdTask = new Task();
        createdTask.setTitle(request.getTitle());
        createdTask.setDescription(request.getDescription());

        when(taskService.createTask(request)).thenReturn(createdTask);

        ResponseEntity<ApiResponse<Task>> response = taskController.createTask(request);

        assertTrue(response.getBody().isSuccess());
        assertEquals("Task created", response.getBody().getMessage());
        assertEquals(request.getTitle(), response.getBody().getData().getTitle());
    }

}
