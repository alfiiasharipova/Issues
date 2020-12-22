package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparators;
import ru.netology.domain.IssuePredicates;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    IssueRepository issueRepository = new IssueRepository();
    Issue first = new Issue(1, "issue1", "test", LocalDate.parse("2000-09-29"), LocalDate.parse("2000-09-29"), "me", true, Set.of("A", "B"), Set.of("back", "front"), 12);
    Issue second = new Issue(2, "issue2", "test2", LocalDate.parse("2001-09-29"), LocalDate.parse("2001-09-29"), "A", false, Set.of("me"), Set.of("front"), 10);


    @BeforeEach
    void setUp() {
        issueRepository.add(first, second);
    }

    @Test
    void getAllClosed() {
        List<Issue> expected = List.of(second);
        assertEquals(expected, issueRepository.getAllClosed());
    }

    @Test
    void getAllOpened() {
        List<Issue> expected = List.of(first);
        assertEquals(expected, issueRepository.getAllOpened());
    }

    @Test
    void filterByAuthor() {
        String author = "me";
        List<Issue> expected = List.of(first);
        assertEquals(expected, issueRepository.filterBy(IssuePredicates.isAuthor(author)));
    }

    @Test
    void filterByLabels() {
        String[] tags = {"front", "back"};
        List<Issue> expected = List.of(first);
        assertEquals(expected, issueRepository.filterBy(IssuePredicates.hasLabels(tags)));
    }

    @Test
    void filterByAssignees() {
        String assignee = "me";
        List<Issue> expected = List.of(second);
        assertEquals(expected, issueRepository.filterBy(IssuePredicates.hasAssignees(assignee)));
    }

    @Test
    void sortByNew() {
        List<Issue> expected = List.of(second, first);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueDateComparator(), false);
        assertEquals(expected, actual);
    }

    @Test
    void sortByOld() {
        List<Issue> expected = List.of(first, second);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueDateComparator(), true);
        assertEquals(expected, actual);
    }

    @Test
    void sortByMostComments() {
        List<Issue> expected = List.of(first, second);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueCommentsComparator(), true);
        assertEquals(expected, actual);
    }

    @Test
    void sortByLessComments() {
        List<Issue> expected = List.of(second, first);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueCommentsComparator(), false);
        assertEquals(expected, actual);
    }

    @Test
    void sortByNewUpdate() {
        List<Issue> expected = List.of(second, first);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueDateUpdateComparator(), false);
        assertEquals(expected, actual);
    }

    @Test
    void sortByOldUpdate() {
        List<Issue> expected = List.of(first, second);
        List<Issue> actual = issueRepository.sortBy(new IssueComparators.IssueDateUpdateComparator(), true);
        assertEquals(expected, actual);
    }
}