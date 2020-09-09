import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { FormControl } from '@angular/forms';
import { ITodo } from '../ITodo';
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss'],
})
export class TodoComponent implements OnInit {
  todoList: ITodo[] = [];
  inputControl = new FormControl();
  constructor(private todoService: TodoService) {}

  ngOnInit(): void {}
  toggleTodo(i) {}
  addTodo() {}
  deleteTodo() {}
}
