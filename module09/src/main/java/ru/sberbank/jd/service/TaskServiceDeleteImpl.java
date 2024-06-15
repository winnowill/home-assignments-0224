package ru.sberbank.jd.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.InMemoryTaskRepository;

/**
 * This class is responsible for deleting task.
 */
@AllArgsConstructor
public class TaskServiceDeleteImpl implements TaskService {

    private HttpServletRequest request;
    private InMemoryTaskRepository repository;

    @Override
    public Task doWork() {
        Task task = null;
        String id = request.getParameter("id");
        if (id != null) {
            task = repository.deleteTaskById(id);
        }
        return task;
    }
}
