package org.eimc.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 *      Unit testing example 6: StudentTest
 *
 *      Test methods follow the Arrange-Act-Assert (AAA) pattern,
 *      commonly labeled as Given-When-Then:
 *
 *      1. GIVEN (Arrange): Set up the required inputs, mocks, and expected outcomes.
 *      2. WHEN (Act): Execute the method under test.
 *      3. THEN (Assert): Verify the result using assertions (AssertJ).
 * */

class ExampleOneTest {

    private final ExampleOne testExample = new ExampleOne();

    @ParameterizedTest
    @CsvSource({

            "90, A",
            "80, B",
            "70, C",
            "60, D",
            "50, E",
            "30, F"

    })
    void canGetCorrectGrade(int score, String grade) {

        // WHEN
        var actualScore = testExample.getGrade(score);

        // THEN
        assertThat(actualScore).isEqualTo(grade);

    }

    @ParameterizedTest
    @CsvSource({

            "-1",
            "101"

    })
    void willThrowIllegalArgumentExceptionWhenInvalidGrade(int score){

        // WHEN - THEN
        assertThatThrownBy(() -> testExample.getGrade(score))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Score must be between 0 and 100");

    }

    @Test
    void canCountVowels() {

        // GIVEN
        String name = "Charles";

        // WHEN
        var actualVowelCount = testExample.countVowels(name);

        // THEN
        var expectedVowelCount = 2;
        assertThat(actualVowelCount).isEqualTo(expectedVowelCount);

    }

    @Test
    void willReturnZeroForVowelCountWhenNameIsNull() {

        // GIVEN
        String name = null;

        // WHEN
        var actualVowelCount = testExample.countVowels(name);

        // THEN
        var expectedVowelCount = 0;
        assertThat(actualVowelCount).isEqualTo(expectedVowelCount);

    }

    @Test
    void willReturnTrueWhenIsValidStudentId() {

        // GIVEN
        String studentID = "S1234";

        // WHEN
        var actualValidStudentId = testExample.isValidStudentId(studentID);

        // THEN
        assertThat(actualValidStudentId).isTrue();

    }

    @Test
    void willReturnFalseWhenIsNotValidStudentId() {

        // GIVEN
        String studentID = "S1234$";

        // WHEN
        var actualValidStudentId = testExample.isValidStudentId(studentID);

        // THEN
        assertThat(actualValidStudentId).isFalse();

    }

    @Test
    void willReturnFalseWhenStudentIdIsNull() {

        // GIVEN
        String studentID = null;

        // WHEN
        var actualValidStudentId = testExample.isValidStudentId(studentID);

        // THEN
        assertThat(actualValidStudentId).isFalse();

    }

    @Test
    void canCalculateAverageScores() {

        // GIVEN
        var scores = List.of(65,70,80,77,95);

        // WHEN
        var actualAverage = testExample.calculateAverage(scores);

        // THEN
        var expectedAverageScore = 77.4;
        assertThat(actualAverage).isEqualTo(expectedAverageScore);

    }

    @Test
    void canCalculateAverageScoresWhenNull() {

        // GIVEN
        List<Integer> scores = null;

        // WHEN
        var actualAverage = testExample.calculateAverage(scores);

        // THEN
        var expectedAverageScore = 0.0;
        assertThat(actualAverage).isEqualTo(expectedAverageScore);

    }

    @Test
    void canCalculateAverageScoresWhenEmpty() {

        // GIVEN
        List<Integer> scores = List.of();

        // WHEN
        var actualAverage = testExample.calculateAverage(scores);

        // THEN
        var expectedAverageScore = 0.0;
        assertThat(actualAverage).isEqualTo(expectedAverageScore);

    }

    @Test
    void canGenerateUsername() {

        // GIVEN
        String username = "Charles Eimer";

        // WHEN
        var actualUserName = testExample.generateUsername(username);

        // THEN
        var expectedUsername = "ceimer";
        assertThat(actualUserName).isEqualTo(expectedUsername);

    }

    @Test
    void willReturnEmptyStringForNullFullName(){

        // GIVEN
        String username = null;

        // WHEN
        var actualUserName = testExample.generateUsername(username);

        // THEN
        var expectedUsername = "";
        assertThat(actualUserName).isEqualTo(expectedUsername);

    }

    @Test
    void willReturnEmptyStringForIncompleteFullName(){

        // GIVEN
        String username = "Charles";

        // WHEN
        var actualUserName = testExample.generateUsername(username);

        // THEN
        var expectedUsername = "";
        assertThat(actualUserName).isEqualTo(expectedUsername);
    }

    @Test
    void canGetTopStudents() {

        // GIVEN
        List<Student> students = List.of(
                new Student("Charles", 81),
                new Student("Anna", 89),
                new Student("Larry", 66)
        );

        // WHEN
        var threshold = 80;
        var actualTopStudents = testExample.getTopStudents(students, threshold);

        // THEN
        List<Student> expectedTopStudents = List.of(
                new Student("Anna", 89),
                new Student("Charles", 81)
        );

        assertThat(actualTopStudents).isEqualTo(expectedTopStudents);

    }

    @Test
    void topStudentsWillReturnAnEmptyListWhenStudentsAreNull() {

        // GIVEN
        List<Student> students = null;

        // WHEN
        var actualTopStudents = testExample.getTopStudents(students, 50);

        // THEN
        List<Student> testEmptyList = List.of();
        assertThat(actualTopStudents).isEqualTo(testEmptyList);

    }

    @Test
    void canValidateWhenHasDuplicateNames() {

        // GIVEN
        List<Student> studentsList = List.of(
                new Student("Larry", 81),
                new Student("Anna", 89),
                new Student("Larry", 66)
        );

        // WHEN
        var actualHasDuplicateNames = testExample.hasDuplicateNames(studentsList);

        // THEN
        assertThat(actualHasDuplicateNames).isTrue();

    }

    @Test
    void hasDuplicateNamesWillReturnAnEmptyListWhenStudentsAreNull(){

        // GIVEN
        List<Student> students = null;

        // WHEN
        var actualStudentDuplicateName = testExample.hasDuplicateNames(students);

        // THEN
        assertThat(actualStudentDuplicateName).isFalse();

    }

    @Test
    void hasDuplicateNamesWillReturnAnEmptyListWhenStudentsAreEmpty(){

        // GIVEN
        List<Student> students = List.of();

        // WHEN
        var actualStudentDuplicateName = testExample.hasDuplicateNames(students);

        // THEN
        assertThat(actualStudentDuplicateName).isFalse();

    }

    @Test
    void hasDuplicateNamesWillReturnFalseWhenCountIsGreaterThanStudents() {

        // GIVEN
        List<Student> studentsList = List.of(
                new Student("Charles", 81),
                new Student("Anna", 89),
                new Student("Larry", 66),
                new Student("Bob", 50)
        );

        // WHEN
        var actualHasDuplicateNames = testExample.hasDuplicateNames(studentsList);

        // THEN
        assertThat(actualHasDuplicateNames).isFalse();
    }

    @Test
    void canReverseCourses(){

        // GIVEN
        List<String> courses = List.of(
                "Computer Science",
                "Economics",
                "Mathematics"
        );

        // WHEN
        var actualCourses = testExample.reverseCourses(courses);

        // THEN
        List<String> testCoursesReversed = List.of(
                "Mathematics",
                "Economics",
                "Computer Science"
        );

        assertThat(actualCourses).isEqualTo(testCoursesReversed);

    }

    @Test
    void willReturnAnEmptyListWhenCoursesAreNull() {

        // GIVEN
        List<String> courses = null;

        // WHEN
        var actualCoursesReversed = testExample.reverseCourses(courses);

        // THEN
        List<String> expectedEmptyList = List.of();
        assertThat(actualCoursesReversed).isEqualTo(expectedEmptyList);

    }

    @Test
    void hasPassedIsTrueWhenScoreIsOverThreshold() {

        // GIVEN
        var score = 60;

        // WHEN
        boolean actualScore = testExample.hasPassed(score);

        // THEN
        assertThat(actualScore).isTrue();

    }

    @Test
    void hasPassedIsFalseWhenScoreIsUnderThreshold() {

        // GIVEN
        var score = 49;

        // WHEN
        boolean actualScore = testExample.hasPassed(score);

        // THEN
        assertThat(actualScore).isFalse();

    }

    @Test
    void assignsBadgeWhenIsHelpfulIsTrue() {

        // GIVEN
        var isHelpful = true;

        // WHEN
        var actualAssignedBadge = testExample.assignBadge(isHelpful);

        // THEN
        assertThat(actualAssignedBadge).isEqualTo("Star Student");

    }

    @Test
    void assignsBadgeWhenIsHelpfulIsFalse() {

        // GIVEN
        var isHelpful = false;

        // WHEN
        var actualAssignedBadge = testExample.assignBadge(isHelpful);

        // THEN
        assertThat(actualAssignedBadge).isEqualTo("Needs Improvement");

    }

}