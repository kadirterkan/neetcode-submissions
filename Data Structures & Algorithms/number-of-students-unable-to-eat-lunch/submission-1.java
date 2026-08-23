class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<Integer>();

        for (int i = 0; i < students.length; i++) {
            student.add(students[i]);
        }
        
        for (int i = 0, j = 0; i < sandwiches.length;) {
            Integer stud = student.poll();
            if (sandwiches[i] == stud) {
                i++;
                j = 0;
            } else {
                j++;
                student.add(stud);
                if (j == student.size()) {
                    break;
                }
            }
        }

        return student.size();
    }
}