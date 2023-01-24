package com.example.springday03.controller;

import com.example.springday03.api.ApiResponse;
import com.example.springday03.pojo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/vi/todos")
public class TodoController {

    ArrayList<Todo> todos = new ArrayList<>();

    @GetMapping("/getTodos") // called endpoints
    public ArrayList<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/addTodo")
    public ApiResponse creatTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return new ApiResponse("Todo has been added!");
    }

    @PutMapping("/update/{index}")
    public String updateTodo(@PathVariable int index, @RequestBody Todo updateTitle) {
        todos.set(index, updateTitle);
        return "Todo updated!";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTodo(@PathVariable int index) {
        todos.remove(index);
        return "Todo deleted!";
    }
}
