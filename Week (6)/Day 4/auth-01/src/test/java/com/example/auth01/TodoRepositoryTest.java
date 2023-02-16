package com.example.auth01;

import com.example.auth01.model.MyUser;
import com.example.auth01.model.Todo;
import com.example.auth01.repository.AuthRepository;
import com.example.auth01.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    AuthRepository authRepository;
    Todo todo1,todo2,todo3;

    List<Todo> todosList;
    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(null,"Test" , "12345" , "USER" , null);
        todo1 = new Todo(null , "todo1", "Hello1" , myUser );
        todo2 = new Todo(null , "todo2", "body2" , myUser );
        todo3 = new Todo(null, "todo3", "body3" , myUser );
        authRepository.save(myUser);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

//        todosList=new ArrayList<>();
//
//        todosList.add(todo1);
//        todosList.add(todo2);
//        todosList.add(todo3);

    }

    @Test
    public void findTodoByIdTest() {
//        todoRepository.save(todo1);
        Todo todo = todoRepository.findTodoById(todo1.getId());
        Assertions.assertThat(todo).isEqualTo(todo1);
    }


    @Test
    public void findAllByMyUserTesting(){
//        todoRepository.save(todo1);
//        todoRepository.save(todo2);
//        todoRepository.save(todo3);
        List<Todo> todos= todoRepository.findAllByMyUser(myUser);
        Assertions.assertThat(todos.get(0).getMyUser().getId()).isEqualTo(myUser.getId());
    }
}
