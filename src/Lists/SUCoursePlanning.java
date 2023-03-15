package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SUCoursePlanning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lessons = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));

        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];

            switch (command) {
                case "Add":
                    if (!lessons.contains(lessonTitle)) {
                        lessons.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!lessons.contains(lessonTitle)) {
                        lessons.add(index, lessonTitle);
                    }
                    break;

                case "Remove":
                    if (lessons.contains(lessonTitle)) {
                        int indexToRemove = lessons.indexOf(lessonTitle);
                        lessons.remove(indexToRemove);
                        if (indexToRemove < lessons.size() && lessons.get(indexToRemove).endsWith("-Exercise")) {
                            lessons.remove(indexToRemove);
                        }
                    }
                    break;
                case "Swap":
                    String secondLessonTitle = tokens[2];
                    if (lessons.contains(lessonTitle) && lessons.contains(secondLessonTitle)) {
                        int firstIndex = lessons.indexOf(lessonTitle);
                        int secondIndex = lessons.indexOf(secondLessonTitle);
                        swapLessons(lessons, firstIndex, secondIndex);
                    }
                    break;
                case "Exercise":
                    int indexToInsert = lessons.indexOf(lessonTitle);
                    if (indexToInsert != -1) {
                        String exercise = lessonTitle + "-Exercise";
                        if (indexToInsert + 1 < lessons.size() && !lessons.get(indexToInsert + 1).endsWith("-Exercise")) {
                            lessons.add(indexToInsert + 1, exercise);
                        } else if (indexToInsert + 1 == lessons.size()) {
                            lessons.add(exercise);
                        }
                    } else {
                        lessons.add(lessonTitle);
                        lessons.add(lessonTitle + "-Exercise");
                    }
                    break;

                default:
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }
    }
    private static void swapLessons(List<String> lessons, int firstIndex, int secondIndex) {
        String firstLesson = lessons.get(firstIndex);
        String secondLesson = lessons.get(secondIndex);
        lessons.set(firstIndex, secondLesson);
        lessons.set(secondIndex, firstLesson);

        if (firstIndex + 1 < lessons.size() && lessons.get(firstIndex + 1).endsWith("-Exercise")) {
            String firstLessonExercise = lessons.get(firstIndex + 1);
            lessons.remove(firstIndex + 1);
            lessons.add(secondIndex + 1, firstLessonExercise);
        }

        if (secondIndex + 1 < lessons.size() && lessons.get(secondIndex + 1).endsWith("-Exercise")) {
            String secondLessonExercise = lessons.get(secondIndex + 1);
            lessons.remove(secondIndex + 1);
            lessons.add(firstIndex + 1, secondLessonExercise);
        }
    }


}
