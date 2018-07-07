/**
 * This file was generated by the Jeddict
 */
package ch.zhaw.mobileeng.abetterliving.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * @author Raphael Fuchs
 */
@Data
@Entity
@Table(name = "TASKS")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskID;

    @Basic
    private String title;

    @Basic
    private String note;

    @Basic
    private Integer priority;

    @Basic
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date requiredTime;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date dueDate;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date creationDate;

    @Basic
    private Boolean status;

    @ManyToOne
    private Lists list;

    @ManyToOne
    private Users owner;

    @ManyToOne
    @JoinColumn(name = "PROJECT_LISTID")
    private Lists project;

    @ManyToMany
    @JoinTable(name = "TASKS_USERS", inverseJoinColumns = {
        @JoinColumn(name = "USERSES_USERID")})
    private List<Users> userses;

    /*public Long getTaskID() {
        return this.TaskID;
    }

    public void setTaskID(Long TaskID) {
        this.TaskID = TaskID;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getNote() {
        return this.Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Integer getPriority() {
        return this.Priority;
    }

    public void setPriority(Integer Priority) {
        this.Priority = Priority;
    }

    public LocalTime getRequiredTime() {
        return this.RequiredTime;
    }

    public void setRequiredTime(LocalTime RequiredTime) {
        this.RequiredTime = RequiredTime;
    }

    public LocalDateTime getDueDate() {
        return this.DueDate;
    }

    public void setDueDate(LocalDateTime DueDate) {
        this.DueDate = DueDate;
    }

    public LocalDateTime getCreationDate() {
        return this.CreationDate;
    }

    public void setCreationDate(LocalDateTime CreationDate) {
        this.CreationDate = CreationDate;
    }

    public Integer getStatus() {
        return this.Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }

    public Lists getList() {
        return this.list;
    }

    public void setList(Lists list) {
        this.list = list;
    }

    public Users getOwner() {
        return this.owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public Lists getProject() {
        return this.project;
    }

    public void setProject(Lists project) {
        this.project = project;
    }

    public List<Users> getUserses() {
        if (userses == null) {
            userses = new ArrayList<>();
        }
        return this.userses;
    }

    public void setUserses(List<Users> userses) {
        this.userses = userses;
    }

    public void addUserse(Users userse) {
        getUserses().add(userse);
        userse.getTaskses().add(this);
    }

    public void removeUserse(Users userse) {
        getUserses().remove(userse);
        userse.getTaskses().remove(this);
    }*/
}
