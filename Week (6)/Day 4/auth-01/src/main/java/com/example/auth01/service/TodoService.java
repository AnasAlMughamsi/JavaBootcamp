package com.example.auth01.service;

import com.example.auth01.api.ApiException;
import com.example.auth01.model.MyUser;
import com.example.auth01.model.Todo;
import com.example.auth01.repository.AuthRepository;
import com.example.auth01.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InvalidApplicationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final AuthRepository authRepository;


    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getMyTodos(Integer user_id) {
        MyUser myUser=authRepository.findMyUserById(user_id);
        List<Todo> todos=todoRepository.findAllByMyUser(myUser);
        if (todos.isEmpty()){
            throw new ApiException("Empty!");

        }
        return todos;
    }

    public Todo getTodoById(Integer id , Integer auth){
        Todo todo=todoRepository.findTodoById(id);
        if (todo==null){
            throw new ApiException("Todo not Found");
        }
        if (todo.getMyUser().getId() != auth){
            throw new ApiException("Sorry , You do not have the authority to get this Todo!");
        }
        return todo;
    }
    public void addTodo(Integer id, Todo todo) {
        MyUser myUser = authRepository.findMyUserById(id);
        todo.setMyUser(myUser);
        todoRepository.save(todo);
    }

    public void updateTodo(Integer user_id, Integer todo_id, Todo updateTodo) {
        Todo oldTodo = todoRepository.findTodoById(todo_id);
        MyUser myUser = authRepository.findMyUserById(user_id);

        if(oldTodo == null) {
            throw new ApiException("Todo not found");
        } else if (oldTodo.getMyUser().getId() != user_id) {
            throw new ApiException("Sorry, you cant update this list");
        }

        updateTodo.setId(todo_id);
        updateTodo.setMyUser(myUser);
        todoRepository.save(updateTodo);
    }

    public void removeTodo(Integer user_id, Integer todo_id) {
        Todo todo = todoRepository.findTodoById(todo_id);
        if(todo == null) {
            throw new ApiException("Todo not found");
        } else if(todo.getMyUser().getId() != user_id) {
            throw new ApiException("Wrong user id");
        }
        todoRepository.delete(todo);
    }
}