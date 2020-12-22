package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CRUDTest {
    Issue first = new Issue(1, "issue1", "test", LocalDate.parse("2000-09-29"), LocalDate.parse("2000-09-29"), "me", true, Set.of("A", "B"), Set.of("back", "front"), 12);
    Issue second = new Issue(2, "issue2", "test2", LocalDate.parse("2001-09-29"), LocalDate.parse("2001-09-29"), "A", false, Set.of("me"), Set.of("front"), 10);

    @Nested
    public class Empty {
        IssueRepository issueRepository = new IssueRepository();

        @Test
        void createIfEmpty() {
            issueRepository.add(first);
            assertEquals(issueRepository.getAll().size(), 1);
        }

        @Test
        void readIfEmpty() {
            assertEquals(0, issueRepository.getAll().size());
        }

        @Test
        void updateIfEmpty() {
            assertNull(issueRepository.updateStatusById(1, false));
        }

        @Test
        void deleteIfEmpty() {
            assertNull(issueRepository.removeById(1));
        }
    }

    @Nested
    public class SingleItem {
        IssueRepository issueRepository = new IssueRepository();

        @BeforeEach
        void setUp() {
            issueRepository.add(first);
        }

        @Test
        void createIfSingleItem() {
            issueRepository.add(second);
            assertEquals(issueRepository.getAll().size(), 2);
        }

        @Test
        void readSingleItemIfIdExist() {
            assertEquals(first, issueRepository.getById(1));
        }

        @Test
        void readSingleItemIfIdNotExist() {
            assertNull(issueRepository.getById(2));
        }

        @Test
        void updateByIdCloseIfSingleItem() {
            issueRepository.updateStatusById(1, false);
            assertFalse(issueRepository.getById(1).isOpened());
        }

        @Test
        void updateByIdOpenIfSingleItem() {
            issueRepository.getById(1).setOpened(false);
            issueRepository.updateStatusById(1, true);
            assertTrue(issueRepository.getById(1).isOpened());
        }

        @Test
        void deleteSingleItemIfIdExist() {
            issueRepository.removeById(1);
            assertEquals(0, issueRepository.getAll().size());
        }

        @Test
        void deleteSingleItemIfIdNotExist() {
            assertNull(issueRepository.removeById(2));
        }

    }

    @Nested
    public class MultipleItems {
        IssueRepository issueRepository = new IssueRepository();

        @BeforeEach
        void setUp() {
            issueRepository.add(first, second);
        }

        @Test
        void createIfMultipleItems() {
            issueRepository.add(second);
            assertEquals(issueRepository.getAll().size(), 3);
        }

        @Test
        void readIfMultipleItems() {
            List<Issue> expected = List.of(first, second);
            assertEquals(expected, issueRepository.getAll());
        }

        @Test
        void readItemIfIdExist() {
            assertEquals(first, issueRepository.getById(1));
        }

        @Test
        void readItemIfIdNotExist() {
            assertNull(issueRepository.getById(3));
        }

        @Test
        void updateByIdCloseIfMultipleItems() {
            issueRepository.updateStatusById(1, false);
            assertFalse(issueRepository.getById(1).isOpened());
        }

        @Test
        void updateByIdOpenIfMultipleItems() {
            issueRepository.updateStatusById(2, true);
            assertTrue(issueRepository.getById(2).isOpened());
        }

        @Test
        void deleteItemIfIdExist() {
            issueRepository.removeById(2);
            assertEquals(first, issueRepository.getById(1));
        }

        @Test
        void deleteItemIfIdNotExist() {
            assertNull(issueRepository.removeById(3));
        }
    }
}
