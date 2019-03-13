package ch02.Array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student: name = %s, score = %d", this.name, this.score);
    }

    public static void main(String[] args) {

        Array<Student> stus = new Array<>();
        stus.addLast(new Student("小狮子", 80));
        stus.addLast(new Student("卡卡大狮子", 90));
        stus.addLast(new Student("小小狮子", 100));
        System.out.println(stus);
    }
}

