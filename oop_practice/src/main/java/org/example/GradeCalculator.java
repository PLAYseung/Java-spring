package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;


    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /*
    요구사항
    • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
    • MVC패턴(Model-View-Controller) 기반으로 구현한다.
    • 일급 컬렉션 사용
        - 리스트 형태로된(Course를 여러개 가진) 정보만 인스턴스 변수로 가지는 클래스
        - 여러개의 정보를 가진 클래스
        - 수정이 발생 했을 때 해당 메소드 하나만 수정 하면 모두 적용 가능
    */

    /*
     * 핵심포인트
     */
    //- 이수한 과목 전달하여 평균학점 계산 요청 → 학점 계산기
                                                //    → (학점수×교과목 평점)의 합계 → 과목(코스) 일급 콜렉션
                                                //    → 수강신청 총 학점 수        → 과목(코스) 일급 콜렉션
    public double calculateGrade() {
        // (학점수×교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade =  courses.multipliedCreditAndCourseGrade();
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            // 여러 군대에서 사용된다면 수정이 필요할 때 모두 수정 해야한다 -> 응집도가 낮다 -> Course에서 수행하는게 좋다?
////            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//            // 응집도가 높아져 한 곳만 수정해도 된다 -> 변화에 유연하게 대응 가능
//            multipliedCreditAndCourseGrade += course.multipliedCreditAndCourseGrade();
//        }

        // 수강 신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
//        int totalCompletedCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();

        return totalMultipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
