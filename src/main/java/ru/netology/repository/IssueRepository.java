package ru.netology.repository;

import ru.netology.domain.Issue;
import ru.netology.domain.IssuePredicates;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IssueRepository {
    private final List<Issue> items = new ArrayList<>();

    public List<Issue> getAll() {
        return items;
    }

    public Issue getById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Issue removeById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public Issue updateStatusById(int id, boolean status) {
        for (Issue item : items) {
            if (item.getId() == id) {
                item.setOpened(status);
                item.setDateLastUpdate(LocalDate.now());
                return item;
            }
        }
        return null;
    }

    public void add(Issue... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public List<Issue> getAllClosed() {
        return filterBy(IssuePredicates.isOpened(false));
    }

    public List<Issue> getAllOpened() {
        return filterBy(IssuePredicates.isOpened(true));
    }

    public List<Issue> filterBy(Predicate<Issue> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Issue> sortBy(Comparator<Issue> comparator, boolean reverse) {
        List<Issue> temp = new ArrayList<>(items);
        temp.sort(comparator);
        if (reverse) {
            Collections.reverse(temp);
        }
        return temp;
    }
}

