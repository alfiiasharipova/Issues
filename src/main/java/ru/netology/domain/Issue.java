package ru.netology.domain;

import java.time.LocalDate;
import java.util.Set;

public class Issue {
    private final int id;
    private String name;
    private String description;
    private LocalDate dateOfCreation;
    private LocalDate dateLastUpdate;
    private String authorName;
    private boolean isOpened;
    private Set<String> assignees;
    private Set<String> labels;
    private int numberOfComments;

    public Issue(int id, String name, String description, LocalDate dateOfCreation, LocalDate dateLastUpdate, String authorName, boolean isOpened, Set<String> assignees, Set<String> labels, int numberOfComments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateLastUpdate = dateLastUpdate;
        this.authorName = authorName;
        this.isOpened = isOpened;
        this.assignees = assignees;
        this.labels = labels;
        this.numberOfComments = numberOfComments;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(LocalDate dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public Set<String> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<String> assignees) {
        this.assignees = assignees;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
