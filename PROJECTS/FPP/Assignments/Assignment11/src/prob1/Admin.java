package prob1;

import java.util.*;

public class Admin {
	public static HashMap<Key, Student> processStudents(List<Student> students) {
		HashMap<Key, Student> map = new HashMap<>();
		for (Student student : students) {
			Key key = new Key(student.getFirstName(), student.getLastName());
			map.put(key, student);
		}
		return map;
	}

	public static double computeAverageGPA(HashMap<Key, Student> maps) {
		if (maps.isEmpty())
			return 0.0;

		double totalGPA = 0.0;
		for (Student student : maps.values()) {
			totalGPA += student.getGpa();
		}
		return totalGPA / maps.size();
	}
}
