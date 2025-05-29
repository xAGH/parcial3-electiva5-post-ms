package electiva5.parcial3.ms.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import electiva5.parcial3.ms.post.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
