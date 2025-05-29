package electiva5.parcial3.ms.post.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.context.ActiveProfiles;

import electiva5.parcial3.ms.post.dto.TaskRequest;
import electiva5.parcial3.ms.post.model.Task;
import electiva5.parcial3.ms.post.model.TaskStatus;
import electiva5.parcial3.ms.post.repository.TaskRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTask_shouldReturnSavedTask() {
        TaskRequest request = new TaskRequest("New Task", "Description", TaskStatus.PENDING);
        Task task = Task.builder().title("New Task").description("Description").status(TaskStatus.PENDING).build();

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.createTask(request);

        assertEquals("New Task", result.getTitle());
        verify(taskRepository).save(any(Task.class));
    }

}
