package com.example.auth01.controller;

import com.example.auth01.dto.Response;
import com.example.auth01.model.MyUser;
import com.example.auth01.model.Todo;
import com.example.auth01.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.status(200).body(todoService.getAllTodos());
    }

    @GetMapping("/my-todos")
    public ResponseEntity getMyTodos(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(todoService.getMyTodos(myUser.getId()));
    }
    @GetMapping("/{id}")
    public ResponseEntity getTodoById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id){
        return ResponseEntity.status(200).body(todoService.getTodoById(id, myUser.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity addTodo(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo) {
        todoService.addTodo(myUser.getId(), todo);
        return ResponseEntity.status(200).body(new Response("Todo added", 201));
    }

    @PutMapping("/update/{to_id}")
    public ResponseEntity updateTodo(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer to_id) {

        return ResponseEntity.status(200).body(new Response("updated added", 201));
    }

    @DeleteMapping("/delete/{todo_id}")
    public ResponseEntity deleteTodo(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todo_id) {
        todoService.removeTodo(myUser.getId(), todo_id);
        return ResponseEntity.status(200).body(new Response("Todo deleted!", 200));
    }
}
