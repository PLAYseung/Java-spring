package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;
    // 변수가 하나더 있으면 안된다

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multipliedCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multipliedCreditAndCourseGrade)
                .sum();
        // 위의 코드와 같음
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multipliedCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
