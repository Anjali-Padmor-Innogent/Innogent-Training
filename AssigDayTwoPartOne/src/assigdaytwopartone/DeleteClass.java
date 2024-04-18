package assigdaytwopartone;

import static assigdaytwopartone.Test.classList;
import static assigdaytwopartone.Test.studentList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteClass {

    static int zeroId = 0;

    public static String deleteClass() {
        Map<Integer, Integer> studentsByClassId = new HashMap<Integer, Integer>();
        classList.stream().forEach(c -> {
            studentsByClassId.put(c.getId(), 0);
        });
        studentList.stream().forEach(c -> {
            studentsByClassId.put(c.getClass_id(), studentsByClassId.getOrDefault(c.getClass_id(), 0) + 1);
        });
        for (java.util.Map.Entry<Integer, Integer> e : studentsByClassId.entrySet()) {
            if (e.getValue().equals(0)) {
                zeroId = e.getKey();
            }
        }
        classList = classList.stream().filter(c -> c.getId() != zeroId).collect(Collectors.toList());
        if (zeroId != 0) {
            return "Class Deleted";
        }
        return "CLass Not Deleted";
    }
}
