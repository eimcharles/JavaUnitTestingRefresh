package org.eimc.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsExample {

    /// Get letter grade
    public String getGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }

        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        if (score >= 50) return "E";
        return "F";
    }

    /// Count vowels in a name
    public int countVowels(String name) {
        if (name == null) return 0;
        return (int) name.toLowerCase()
                ///  Convert char to ASCII value
                .chars()
                ///  Check if the character c is contained inside the String
                .filter(c -> "aeiou".indexOf(c) >= 0)
                /// Increment the count for each letter that meets the filter condition
                .count();
    }

    /// Validate student ID format (e.g., S1234)
    public boolean isValidStudentId(String studentId) {
        return studentId != null && studentId.matches("S\\d{4}");
    }

    /// Calculate average score
    public double calculateAverage(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;
        return scores
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                ///  if no result is found return 0.0
                .orElse(0.0);
    }

    /// Generate username from full name
    public String generateUsername(String fullName) {
        /// Check if string is null or just a single word
        if (fullName == null || !fullName.contains(" ")) return "";

        ///  Split the string on one or more spaces
        String[] parts = fullName.trim().split("\\s+");

        ///  returns first letter + lastname to lower case
        return (parts[0].charAt(0) + parts[1]).toLowerCase();
    }

    /// Get students who scored above a certain threshold
    public List<Student> getTopStudents(List<Student> students, int threshold) {
        if (students == null) return List.of();
        return students.stream()
                ///  Filter students scores by passed threshold
                .filter(s -> s.score() >= threshold)
                ///  Sort them by highest to lowest scores
                .sorted((a, b) -> Integer.compare(b.score(), a.score()))
                .toList();
    }

    /// Check if a list of names has duplicates (case-insensitive)
    public boolean hasDuplicateNames(List<Student> students) {
        if (students == null || students.isEmpty()) return false;

        return students.stream()
                .map(s -> s.name().toLowerCase())
                ///  Remove duplicate names
                .distinct()
                ///  Ensure the count is less than students list
                .count() < students.size();
    }

    /// Reverse course list
    public List<String> reverseCourses(List<String> courses) {
        if (courses == null) return new ArrayList<>();
        List<String> copy = new ArrayList<>(courses);
        Collections.reverse(copy);
        return copy;
    }

    /// Check if student passed
    public boolean hasPassed(int score) {
        return score >= 50;
    }

    /// Assign behavior badge
    public String assignBadge(boolean isHelpful) {
        return isHelpful ? "Star Student" : "Needs Improvement";
    }

}
