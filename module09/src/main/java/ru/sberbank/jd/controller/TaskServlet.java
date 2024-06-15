package ru.sberbank.jd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import lombok.SneakyThrows;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.HtmlMaker;
import ru.sberbank.jd.repository.InMemoryTaskRepository;
import ru.sberbank.jd.service.TaskService;
import ru.sberbank.jd.service.TaskServiceDeleteImpl;
import ru.sberbank.jd.service.TaskServiceGetImpl;

/**
 * This servlet is used for getting tasks.
 */
@WebServlet(name = "TaskServlet", value = "/task")
public class TaskServlet extends HttpServlet {
    private ObjectMapper objectMapper;
    private ObjectWriter objectWriter;
    private InMemoryTaskRepository taskRepository;
    private TaskService taskService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.objectMapper = new ObjectMapper();
        this.objectWriter = new ObjectMapper().writer();
        taskRepository = new InMemoryTaskRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Task task = getTaskInputFrom(req);
        doFlush(task, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        taskService = new TaskServiceGetImpl(req, taskRepository);
        Task task = taskService.doWork();
        if (task != null) {
            doFlush(task, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        taskService = new TaskServiceDeleteImpl(req, taskRepository);
        Task task = taskService.doWork();
        if (task != null) {
            doFlush(task, resp);
        }
    }

    @SneakyThrows
    private Task getTaskInputFrom(HttpServletRequest req) {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        Task task = objectMapper.readValue(sb.toString(), Task.class);
        task = new Task(task.owner(), task.description());
        taskRepository.add(task);
        return task;
    }

    private void doFlush(Task task, HttpServletResponse response) throws IOException {

        String htmlString = HtmlMaker.makeHtml(objectWriter.writeValueAsString(task));
        response.getOutputStream().write(htmlString.getBytes());
        response.getOutputStream().flush();
    }
}
