package ru.sberbank.jd.repository;

import java.util.HashMap;
import java.util.Map;
import ru.sberbank.jd.model.Task;

/**
 * Store task in memory.
 */
public class InMemoryTaskRepository {

    private final Map<String, Task> storage = new HashMap<>();

    public void add(Task task) {
        storage.put(task.id().toString(), task);
    }

    public Task getTaskById(String id) {
        return storage.get(id);
    }

    /**
     * removeTaskById.
     *
     * @param id ID
     * @return task
     */
    public Task deleteTaskById(String id) {
        Task task = getTaskById(id);
        storage.remove(id);
        System.out.println(storage.size());
        return task;
    }
}
