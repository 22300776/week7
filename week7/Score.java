import java.util.Scanner;

class Score {
    int count;
    int[][] jumsu;
    int[] sum_student;
    double[] average_student;
    int[] sum_subject;
    double[] average_subject;
    int[] sum_class;
    double[] average_class;

    // 생성자
    public Score(int count) {
        this.count = count;
        jumsu = new int[count][3];
        sum_student = new int[count];
        average_student = new double[count];
        sum_subject = new int[3];
        average_subject = new double[3];
        sum_class = new int[3];
        average_class = new double[3];
    }

    // 점수 입력 및 총점과 평균 계산
    public void getScore() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            System.out.println("학생 " + (i + 1) + "의 점수를 입력하세요 (국어, 영어, 수학 순서로 입력): ");
            for (int j = 0; j < 3; j++) {
                jumsu[i][j] = sc.nextInt();
                sum_student[i] += jumsu[i][j];
                sum_subject[j] += jumsu[i][j];
                sum_class[j] += jumsu[i][j];
            }
            average_student[i] = sum_student[i] / 3.0;
        }
        for (int j = 0; j < 3; j++) {
            average_subject[j] = sum_subject[j] / (double) count;
            average_class[j] = sum_class[j] / (double) count;
        }
    }

    // 학생들의 점수 출력
    public void printScore() {
        System.out.println("학생별 점수:");
        for (int i = 0; i < count; i++) {
            System.out.printf("학생 %d: 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %.2f, 등급: %s\n",
                    (i + 1), jumsu[i][0], jumsu[i][1], jumsu[i][2], sum_student[i], average_student[i], getGrade(average_student[i]));
        }

        System.out.println("\n과목별 총점과 평균:");
        System.out.printf("국어 - 총점: %d, 평균: %.2f\n", sum_subject[0], average_subject[0]);
        System.out.printf("영어 - 총점: %d, 평균: %.2f\n", sum_subject[1], average_subject[1]);
        System.out.printf("수학 - 총점: %d, 평균: %.2f\n", sum_subject[2], average_subject[2]);
    }

    // 특정 학생의 점수 출력
    public void printScore(int num) {
        if (num < 1 || num > count) {
            System.out.println("잘못된 학생 번호입니다.");
            return;
        }
        int idx = num - 1;
        System.out.printf("학생 %d: 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %.2f, 등급: %s\n",
                num, jumsu[idx][0], jumsu[idx][1], jumsu[idx][2], sum_student[idx], average_student[idx], getGrade(average_student[idx]));
    }

    // 과목별 총점과 평균 출력
    public void printScore(int num, String classname) {
        int classIndex = -1;
        switch (classname) {
            case "국어":
                classIndex = 0;
                break;
            case "영어":
                classIndex = 1;
                break;
            case "수학":
                classIndex = 2;
                break;
            default:
                System.out.println("잘못된 과목명입니다.");
                return;
        }

        System.out.printf("%s - 총점: %d, 평균: %.2f\n", classname, sum_class[classIndex], average_class[classIndex]);
    }

    // 평균에 따른 등급 계산
    private String getGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        // 5명의 점수를 다룰 수 있도록 Score 객체 생성
        Score score = new Score(5);

        // 점수 입력 및 총점과 평균 계산
        score.getScore();

        // 학생별 점수, 총점, 평균 출력
        score.printScore();

        // 특정한 1명의 점수, 총점, 평균 출력
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 확인할 학생 번호를 입력하세요 (1 ~ 5): ");
        int studentNum = sc.nextInt();
        score.printScore(studentNum);

        // 과목별 총점과 평균 출력
        System.out.println("총점과 평균을 확인할 과목명을 입력하세요 (국어, 영어, 수학): ");
        String className = sc.next();
        score.printScore(0, className);

        sc.close();
    }
}
