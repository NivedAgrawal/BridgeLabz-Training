public class StudentMarks {

    public static int[][] generateMarks(int n) {
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = (int)(Math.random() * 51 + 50); // Physics
            marks[i][1] = (int)(Math.random() * 51 + 50); // Chemistry
            marks[i][2] = (int)(Math.random() * 51 + 50); // Maths
        }
        return marks;
    }

    public static double[][] calculatePercentage(int[][] marks) {
        double[][] result = new double[marks.length][3]; // total, avg, percent
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] getGrade(double[][] percent) {
        String[] grades = new String[percent.length];
        for (int i = 0; i < percent.length; i++) {
            double p = percent[i][2];
            if (p >= 90) grades[i] = "A";
            else if (p >= 75) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 40) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] marks, double[][] perc, String[] grade) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t%.0f\t%.2f\t%.2f\t%s\n",
                    marks[i][0], marks[i][1], marks[i][2],
                    perc[i][0], perc[i][1], perc[i][2], grade[i]);
        }
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5);
        double[][] perc = calculatePercentage(marks);
        String[] grade = getGrade(perc);
        displayScorecard(marks, perc, grade);
    }
}
