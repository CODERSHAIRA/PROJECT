package com.KK.todoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoController {

	public ToDoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	private TodoService todoService;
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<ToDo> todos =todoService.findByUsername("KK");
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= (String)model.get("name");
		ToDo todo = new ToDo(0, username,"Default Desc", LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username= (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo", method= RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		ToDo todo =todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username= (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}

/*
 <dependency>
	<groupId>org.webjars</groupId>
	<artifactId>bootstrap-datepicker</artifactId>
	<version>1.9.0</version>
</dependency>

<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
 
<fieldset class="mb-3">				
	<form:label path="description">Description</form:label>
	<form:input type="text" path="description" required="required"/>
	<form:errors path="description" cssClass="text-warning"/>
</fieldset>
<fieldset class="mb-3">				
	<form:label path="targetDate">Target Date</form:label>
	<form:input type="text" path="targetDate" required="required"/>
	<form:errors path="targetDate" cssClass="text-warning"/>
</fieldset>
		
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
*/
