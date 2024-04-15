package KnouJava;

// 출석 과제 강의록 pdf 파일 - 9 page, 46 ~ 49 page 참고
// TODO : 자바 인스턴스 변수, 클래스 변수, 지역변수 차이 확인 (2024.04.16 jbh)
// 참고 URL - https://hstory0208.tistory.com/entry/Java%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%B3%80%EC%88%98-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-%EB%B3%80%EC%88%98-%EC%A7%80%EC%97%AD-%EB%B3%80%EC%88%98%EB%9E%80

// 접근 제어자가 생략된 class (Circle, Cylinder)는 같은 패키지에 있는 다른 클래스에서 사용 가능(패키지 접근 수준)
// class에 속한 접근 제어자가 생략된 데이터 필드(인스턴스 변수)는 같은 패키지에 있는 다른 클래스에서 사용 가능(패키지 접근 수준)

// 원 클래스 
class Circle {
    int r;   // 반지름

    public Circle(int a) {      // 3. Circle 클래스 생성자 호출(실행)
        r = a;                  // 4. Circle 클래스에 속하는 데이터 필드(인스턴스 변수) r에 파라미터 a 할당 
    }

    // 인스턴스 메소드 - 원의 넓이 구하기 
    // 원의 넓이 = 반지름 * 반지름 * 3.14 
    public double getArea() {   // 13. Circle 클래스에 속하는 인스턴스 메소드 "getArea" 실행
        return r * r * 3.14;    // 14. 원의 넓이(r * r * 3.14) 리턴
    }
}

// 원통 클래스
class Cylinder {
    Circle c;  // 밑면(원)
    int h;     // 높이

    public Cylinder(Circle a, int b) {   // 7. Cylinder 클래스 생성자 호출(실행)
        c = a;                           // 8. Cylinder 클래스에 속하는 데이터 필드(인스턴스 변수) c에 파라미터 a 할당 
        h = b;                           // 9. Cylinder 클래스에 속하는 데이터 필드(인스턴스 변수) h에 파라미터 b 할당 
    }

    // 인스턴스 메소드 - 원통 부피 구하기 
    // 원통 부피 = 원의 넓이 * 높이 
    public double getVolume() {          // 11. Cylinder 클래스에 속하는 인스턴스 메소드 "getVolume" 실행
        return c.getArea() * h;          // 12. Circle 클래스에 속하는 인스턴스 메소드 "getArea" 호출
                                         // 15. 원통 부피 리턴 (원통 부피 = Circle 클래스 인스턴스 메소드 "getArea" 실행 결과로 리턴 받은 값(원의 넓이) * h(높이))
    }
}

// 원통 부피 구하기 클래스
public class CylinderVolume {
    public static void main(String args[]) {                   // 1. 메소드 "main" 시작
        Circle c = new Circle(10);                           // 2. Circle 클래스 객체 c 생성
        int h = 20;                                            // 5. int형 변수 h에 값 20 할당 
        Cylinder cy = new Cylinder(c, h);                      // 6. Cylinder 클래스 객체 cy 생성 
        System.out.println("원통 부피 : " + cy.getVolume());    // 10. Cylinder 클래스 객체 cy에 속한 인스턴스 메소드 "getVolume" 호출
                                                               // 16. 메서드 "System.out.println" 호출 -> Cylinder 클래스 객체 cy의 부피(원통 부피 = 원의 넓이 * 높이) 값 "6280.0" 출력 
    }
}
