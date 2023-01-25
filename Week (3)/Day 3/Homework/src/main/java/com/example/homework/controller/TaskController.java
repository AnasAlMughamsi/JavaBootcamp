package com.example.homework.controller;


import com.example.homework.api.ApiResponse;
import com.example.homework.pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/vi/tasks")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Task> displayTask() {
        if(tasks.isEmpty()) {
            System.out.println("tasks is empty");
        }
        return tasks;
    }

    @PostMapping("/create")
    public String createTask(@RequestBody Task newTask) {
        tasks.add(newTask);
        return "Task created!";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task updateTask) {
        tasks.set(index, updateTask);
        return "Task Updated!";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "Task Deleted!";
    }


    // method to search by title
    @GetMapping("/get-title/{title}")
    public ArrayList<Task> searchByTitle(@PathVariable String title) {
        ArrayList<Task> matchByTitle = new ArrayList<>();

        for (Task task: tasks) {
            if(task.getTitle().equals(title)) {
                matchByTitle.add(task);
            }
        }
        return matchByTitle;
    }

    // method to change the status
    @PutMapping("/update-status/{index}")
    public String changeStatus(@PathVariable int index) {

        for (Task task: tasks) {
            if(task.getId() == index) {
                if(task.getStatus().equals("done")) {
                    task.setStatus("not done");
                } else {
                    task.setStatus("done");
                }
            }
        }

        return "status changed!";
    }
}
