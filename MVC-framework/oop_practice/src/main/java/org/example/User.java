package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) { // 상위 인터페이스 의존 : 의존성을 낮춰 테스트를 하기 좋게 만들어 줌
//        as-is
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

//      to-be
        String password = passwordGenerator.generatePassword();
        /*
        - 비밀번호는 최소 8자 이상 12자 이하
        */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
