package ru.netology.domain;

import java.util.Comparator;

public class IssueComparators {
    public static class IssueDateComparator implements Comparator<Issue> {

        @Override
        public int compare(Issue o1, Issue o2) {
            return o2.getDateOfCreation().compareTo(o1.getDateOfCreation());
        }
    }

    public static class IssueCommentsComparator implements Comparator<Issue> {

        @Override
        public int compare(Issue o1, Issue o2) {
            return o1.getNumberOfComments() - o2.getNumberOfComments();
        }
    }

    public static class IssueDateUpdateComparator implements Comparator<Issue> {

        @Override
        public int compare(Issue o1, Issue o2) {
            return o2.getDateLastUpdate().compareTo(o1.getDateLastUpdate());
        }
    }
}
