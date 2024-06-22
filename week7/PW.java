import java.util.Random; 
import java.util.Scanner; 

class MakePW {
    private Random random;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // 생성자
    public MakePW() {
        random = new Random();
    }

    // 길이만 주어진 경우 단일 암호 문자열 생성 및 출력
    public void make(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        System.out.println("생성된 비밀번호: " + password.toString());
    }

    // 길이와 개수가 주어진 경우 여러 개의 암호 문자열 생성 및 출력
    public void make(int length, int amount) {
        for (int i = 0; i < amount; i++) {
            StringBuilder password = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int index = random.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }
            System.out.println("생성된 비밀번호 " + (i+1) + ": " + password.toString());
        }
    }

    public static void main(String[] args) {
        MakePW makePw = new MakePW();
        Scanner sc = new Scanner(System.in);

        // 테스트 1: 단일 암호 문자열 생성
        System.out.println("원하는 비밀번호의 길이: ");
        int length = sc.nextInt();
        makePw.make(length);

        // 테스트 2: 여러 개의 암호 문자열 생성
        System.out.println("원하는 비밀번호의 길이와 개수: ");
        length = sc.nextInt();
        int amount = sc.nextInt();
        makePw.make(length, amount);

        sc.close();
    }
}
