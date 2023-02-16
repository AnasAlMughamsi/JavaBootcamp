package com.example.auth01;

import com.example.auth01.model.MyUser;
import com.example.auth01.model.Todo;
import com.example.auth01.repository.AuthRepository;
import com.example.auth01.repository.TodoRepository;
import com.example.auth01.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {


    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Mock
    AuthRepository authRepository;

    MyUser myUser;
    Todo todo1, todo2, todo3;
    List<Todo> todoList;


    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"majd","123","Admin", null);
        todo1=new Todo (null,"Test 1", "todo1", myUser);
        todo2=new Todo(null,"Test 1", "todo1", null);
        todo3=new Todo(null,"Test 1", "todo1", myUser);

        todoList=new ArrayList<>();
        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);
    }

    @Test
    public void getAllTodoTest() {
        when(todoRepository.findAll()).thenReturn(todoList);
        List<Todo> todos = todoService.getAllTodos();
        Assertions.assertEquals(3, todos.size());
        verify(todoRepository, times(1)).findAll();
    }
}
