package skillbox.amkiri.module5.hw2.todolist;

import java.util.LinkedList;
import java.util.List;

public class ToDoList {

    private LinkedList<String> todo = new LinkedList<>();

    public ToDoList() {
        todo.add("tododo");
        todo.add("nothing");
    }

    public List<String> list() {
        return todo;
    }

    public void add(String task, int pos) {
        if (pos >= todo.size()) {
            todo.add(task);
        } else if (pos <= 0) {
            todo.addFirst(task);
        } else {
            todo.add(pos, task);
        }
    }

   public void edit(String task, int pos) {
        if (pos >= 0 && pos < todo.size()) {
            todo.set(pos, task);
        } else {
            add(task, pos);
        }
    }

    public void delete(int pos) {
        if (pos >= 0 && pos < todo.size()) {
            todo.remove(pos);
        }
    }

}
