package lab.lab1;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model implements Contract.Model {
    private static Contract.Model model;
    private File file;
    private List<Student> students = new ArrayList<>();
//    private List<Student> students = new ArrayList<Student>() {
//        {
//            add(new Student("Глушенок", "Анна", "ФАИС", "ИП41", "27.04.2003"));
//            add(new Student("Жуков", "Денис", "МТФ", "ИП41", "16.02.2002"));
//            add(new Student("Горбанёв", "Рома", "ГЭФ", "ИП41", "08.03.2003"));
//            add(new Student("Коваленко", "Настя", "ФАИС", "ИП41", "16.07.2002"));
//            add(new Student("Гудойть", "Влад", "МТФ", "ИП41", "31.10.2000"));
//            add(new Student("Макеев", "Миша", "МСФ", "ИП41", "12.11.2000"));
//            add(new Student("Падалица", "Максим", "ЭФ", "ИП41", "06.09.2001"));
//        }
//    };

    public static Contract.Model getModel(File file) {
        if (model == null)
            model = new Model(file);
        return model;
    }

    private Model(File file) {
        this.file = file;
    }

    private List<Student> readFile() {
        List<Student> students = new ArrayList<>();
        try (Scanner scan = new Scanner(new FileReader(new File(file, "students.txt")))) {
            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(" ");
                students.add(new Student(line[0], line[1], line[2], line[3], line[4]));
            }
        } catch (FileNotFoundException e) {
            Log.e("File", "File not found");
        }
        return students;
    }

    private void write(List<Student> students) {
        try (FileWriter fw = new FileWriter(new File(file, "students.txt"))) {
            for (Student student : students)
                fw.write(student.toString() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> get() {
        return readFile();
    }

    @Override
    public void add(Student student) {
        students = readFile();
        students.add(student);
        write(students);
    }

    @Override
    public void edit(Student oldStudent, Student newStudent) {
        students = readFile();
        students.remove(oldStudent);
        students.add(newStudent);
        write(students);
    }

    @Override
    public void delete(Student student) {
        students = readFile();
        students.remove(student);
        write(students);
    }
}
