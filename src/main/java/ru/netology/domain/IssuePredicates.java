package ru.netology.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public class IssuePredicates {
    public static Predicate<Issue> isAuthor(String author) {
        return issue -> issue.getAuthorName().equals(author);
    }

    public static Predicate<Issue> hasLabels(String... labels) {
        return issue -> issue.getLabels().containsAll(Arrays.asList(labels));
    }

    public static Predicate<Issue> hasAssignees(String... assignees) {
        return issue -> issue.getAssignees().containsAll(Arrays.asList(assignees));
    }

    public static Predicate<Issue> isOpened(Boolean isOpened) {
        return issue -> issue.isOpened() == isOpened;
    }
}
