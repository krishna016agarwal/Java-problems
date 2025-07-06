import java.util.*;

public class priorityQueue {
    static class Student implements Comparable<Student> {
        int rank;
        String name;

        public Student(int rank, String name) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(new Student(12, "A"));
        q.add(new Student(121, "B"));
        q.add(new Student(2, "C"));
        q.add(new Student(102, "D"));
        while(!q.isEmpty()){
            System.out.println(q.peek().name+"-->"+q.peek().rank);
            q.remove();
        }
    }

}
