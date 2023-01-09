package hello.core.singletone;

public class SingletonService {

    // 자기 자신을 내부에 가지고 있는데 static
    // 클래스 레벨로 올라가기 static 영역에 때문에 1개만 존재
    /*
    * 자기 자신을 생성해서 instance에 넣는다
    * */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    /*
    * 생성하는 것을 막기 위한 private 생성자
    * */
    private SingletonService(){
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
