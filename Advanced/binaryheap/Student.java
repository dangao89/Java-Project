package binaryheap;

/**
 * The class represents a student with a name and a score. It implements the
 * Comparable<Student> interface to allow comparison of students based on their
 * score.
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    /**
     * Constructs a student with the specified name and score.
     *
     * @param name The name of the student
     * @param score The score of the student
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns the name of this student.
     *
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the score of this student.
     *
     * @return The student's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Compares this student to another student based on their score. The
     * comparison is done in ascending order of the score.
     *
     * @param next The next student to compare this student to
     * @return A negative integer, zero, or a positive integer as this student's
     * score is less than, equal to, or greater than the specified student's
     * score
     */
    @Override
    public int compareTo(Student next) {
        return Integer.compare(this.score, next.score);
    }

    /**
     * Returns a string representation includes the student's name and score of
     * this student.
     *
     * @return A string representation of this student
     */
    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}
