import { DateTime } from "ionic-angular/umd";
import { Lists } from "./Lists";
import { Users } from "./Users";

export interface Task {
    taskID: number;
    title: string;
    note: string;
    priority: number;
    requiredTime: DateTime;
    dueDate: Date;
    creationDate: number;
    status: number;
    list: Lists;
    projects: Lists;
    owner: Users;
}



/*export class TaskImpl implements Task {
    id: number;
    name: string;
    done: boolean;
    creationDate: Date;
    dueDate: Date;
    durationInMinutes: number;
    project: Project;
    context: Context;
}
*/