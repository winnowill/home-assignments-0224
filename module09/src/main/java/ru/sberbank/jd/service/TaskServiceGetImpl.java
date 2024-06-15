package ru.sberbank.jd.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.InMemoryTaskRepository;

/**
 *Implementation of TaskService. It is responsible for getting tasks from repository.
 */
@AllArgsConstructor
public class TaskServiceGetImpl implements TaskService {

    private HttpServletRequest request;
    private InMemoryTaskRepository repository;

    @Override
    public Task doWork() {

        Task task = null;
        String id = request.getParameter("id");
        if (id != null) {
            task = repository.getTaskById(id);
        }
        return task;
    }
}