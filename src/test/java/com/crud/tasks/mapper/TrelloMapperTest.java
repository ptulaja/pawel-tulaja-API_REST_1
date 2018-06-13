package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    private TrelloMapper trelloMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToList() {

        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "list1", false));
        trelloListDto.add(new TrelloListDto("2", "list2", true));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals(2, trelloLists.size());
        assertEquals(trelloListDto.get(0).getName(), trelloLists.get(0).getName());
    }

    @Test
    public void testMapToBoards() {

        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1", "board1", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(1, trelloBoard.size());
        assertEquals(trelloBoardDto.get(0).getName(), trelloBoard.get(0).getName());
    }

    @Test
    public void testMapToCard() {

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "description card1", "pos", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
    }

    @Test
    public void testMapToListDto() {

        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "list1", false));
        trelloList.add(new TrelloList("2", "list2", true));

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);

        //Then
        assertEquals(2, trelloListDto.size());
        assertEquals(trelloList.get(0).getName(), trelloListDto.get(0).getName());
    }

    @Test
    public void testMapToTask() {

        //Given
        TaskDto taskDto = new TaskDto(1L, "task1", "test1");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(), task.getId());
    }

    @Test
    public void testMapToTaskDto() {

        //Given
        Task task = new Task(1L, "task1", "test1");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(task.getId(), taskDto.getId());
    }

    @Test
    public void testMapToTaskDtoList() {

        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "task1", "test1"));
        taskList.add(new Task(2L, "task2", "test2"));

        //When
        List<TaskDto>taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        assertEquals(2, taskDtoList.size());
        assertEquals(taskList.get(0).getId(), taskDtoList.get(0).getId());
    }
}
