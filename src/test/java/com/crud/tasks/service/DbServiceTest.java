package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    public void testGetAllTasks() {

        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "task1", "test1"));
        taskList.add(new Task(2L, "task2", "test2"));

        when(repository.findAll()).thenReturn(taskList);

        //When
        List<Task> taskListFinding = dbService.getAllTasks();

        //Then
        assertEquals(2, taskListFinding.size());
    }

    @Test
    public void testGetTask() {

        //Given
        Task task = new Task(1L, "task1", "test1");
        when(dbService.getTask(1L)).thenReturn(Optional.ofNullable(task));

        //When
        Optional<Task> taskById = dbService.getTask(1L);

        //Then
        assertTrue(taskById.isPresent());
    }

    @Test
    public void testSaveTask() {

        //Given
        Task task = new Task(1L, "task1", "test1");
        when(repository.save(task)).thenReturn(task);

        //When
        Task taskInDb = dbService.saveTask(task);

        //Then
        assertEquals(task.getId(), taskInDb.getId());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task(1L, "task1", "tets1");

        //When
        dbService.deleteTask(1L);

        //Then
        assertFalse(dbService.getTask(1L).isPresent());
    }
}

