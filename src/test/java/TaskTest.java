import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTopicMatches() {
        Meeting meeting = new Meeting(3, "Шрифты для табличек", "Офис", "10:00");

        boolean actual = meeting.matches("Шрифты для табличек");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingProjectMatches() {
        Meeting meeting = new Meeting(3, "Шрифты для табличек", "Офис", "10:00");

        boolean actual = meeting.matches("Офис");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNoMatches() {
        Meeting meeting = new Meeting(3, "Шрифты для табличек", "Офис", "10:00");

        boolean actual = meeting.matches("Огурцы");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить продукты");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить продукты");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Помидоры");

        Assertions.assertFalse(actual);
    }

}