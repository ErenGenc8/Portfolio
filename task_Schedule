#include <iostream>
#include <vector>
#include <string>
using namespace std;

struct Date {
    int day;
    int month;
    int year;

    bool isValid() const {
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Check for leap year
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            return day <= 29;
        }

        return day <= daysInMonth[month - 1];
    }

    string toString() const {
        return to_string(day) + "/" + to_string(month) + "/" + to_string(year);
    }
};

struct Task {
    int id;
    string title;
    string description;
    Date dueDate;
};

class TaskScheduler {
private:
    vector<Task> tasks;
    int nextId;

public:
    TaskScheduler() : nextId(1) {}

    void addTask() {
        Task newTask;
        newTask.id = nextId++;

        cout << "Enter Task Title: ";
        cin.ignore();
        getline(cin, newTask.title);

        cout << "Enter Task Description: ";
        getline(cin, newTask.description);

        bool validDate = false;
        while (!validDate) {
            cout << "Enter Task Due Date (day month year): ";
            cin >> newTask.dueDate.day >> newTask.dueDate.month >> newTask.dueDate.year;

            if (newTask.dueDate.isValid()) {
                validDate = true;
            } else {
                cout << "Invalid date. Please try again.\n";
            }
        }

        tasks.push_back(newTask);
        cout << "Task Added Successfully!\n";
    }

    void viewTasks() {
        if (tasks.empty()) {
            cout << "No tasks to display.\n";
            return;
        }

        cout << "Scheduled Tasks:\n";
        for (const auto &task : tasks) {
            cout << "-------------------------\n";
            cout << "Task ID: " << task.id << "\n";
            cout << "Title: " << task.title << "\n";
            cout << "Description: " << task.description << "\n";
            cout << "Due Date: " << task.dueDate.toString() << "\n";
        }
        cout << "-------------------------\n";
    }

    void deleteTask() {
        if (tasks.empty()) {
            cout << "No tasks to delete.\n";
            return;
        }

        int id;
        cout << "Enter Task ID to delete: ";
        cin >> id;

        for (auto it = tasks.begin(); it != tasks.end(); ++it) {
            if (it->id == id) {
                tasks.erase(it);
                cout << "Task Deleted Successfully!\n";
                return;
            }
        }
        cout << "Task ID not found.\n";
    }

    void menu() {
        int choice;

        do {
            cout << "\nTask Scheduler Menu:\n";
            cout << "1. Add Task\n";
            cout << "2. View Tasks\n";
            cout << "3. Delete Task\n";
            cout << "4. Exit\n";
            cout << "Enter your choice: ";
            cin >> choice;

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    cout << "Exiting Task Scheduler. Goodbye!\n";
                    break;
                default:
                    cout << "Invalid choice. Please try again.\n";
                    break;
            }
        } while (choice != 4);
    }
};

int main() {
    TaskScheduler scheduler;
    scheduler.menu();

    return 0;
}
