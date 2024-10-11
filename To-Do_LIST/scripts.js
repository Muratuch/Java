// Get tasks from localStorage or initialize an empty array
let tasks = JSON.parse(localStorage.getItem('tasks')) || [];

// Function to display tasks on load
window.onload = function() {
    displayTasks();
};

// Function to add a new task
function addTask() {
    let taskInput = document.getElementById("taskInput").value.trim();
    let deadlineDateInput = document.getElementById("deadlineDateInput").value; // Get deadline date input
    let deadlineTimeInput = document.getElementById("deadlineTimeInput").value; // Get deadline time input
    if (taskInput) {
        const newTask = { 
            description: taskInput, 
            completed: false, 
            deadline: `${deadlineDateInput} ${deadlineTimeInput}` // Combine date and time
        };
        tasks.push(newTask);
        saveTasks();
        displayTasks();
    } else {
        alert("Please enter a task.");
    }
    document.getElementById("taskInput").value = ""; // Clear input field
    document.getElementById("deadlineDateInput").value = ""; // Clear deadline date field
    document.getElementById("deadlineTimeInput").value = ""; // Clear deadline time field
}

// Function to display tasks
function displayTasks() {
    let taskList = document.getElementById("taskList");
    taskList.innerHTML = ""; // Clear list
    tasks.forEach((task, index) => {
        let listItem = document.createElement("li");
        listItem.className = task.completed ? "completed" : "";

        // Task description
        let taskText = document.createElement("span");
        taskText.textContent = task.description;
        taskText.onclick = () => toggleComplete(index); // Toggle completion
        
        // Deadline display
        let deadlineText = document.createElement("div");
        deadlineText.className = "deadline"; // Use div for deadline
        deadlineText.textContent = task.deadline ? `Due: ${task.deadline}` : ""; // Display deadline

        // Delete button
        let deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.className = "delete";
        deleteButton.onclick = () => deleteTask(index); // Delete task
        
        // Append elements to list item
        listItem.appendChild(taskText);
        listItem.appendChild(deadlineText); // Append deadline div to list item
        listItem.appendChild(deleteButton);
        taskList.appendChild(listItem);
    });
}

// Function to toggle task completion
function toggleComplete(index) {
    tasks[index].completed = !tasks[index].completed;
    saveTasks();
    displayTasks();
}

// Function to delete a task
function deleteTask(index) {
    tasks.splice(index, 1);
    saveTasks();
    displayTasks();
}

// Function to save tasks to localStorage
function saveTasks() {
    localStorage.setItem('tasks', JSON.stringify(tasks));
}
