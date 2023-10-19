package lab.lab1;

import java.util.ArrayList;
import java.util.List;

public class Model implements Contract.Model {
    private static Contract.Model model;
    private List<Student> students = new ArrayList<Student>() {
        {
            add(new Student("Глушенок", "Анна", "ФАИС", "ИП41", "27.04.2003"));
            add(new Student("Жуков", "Денис", "МТФ", "ИП41", "16.02.2002"));
            add(new Student("Горбанёв", "Рома", "ГЭФ", "ИП41", "08.03.2003"));
            add(new Student("Коваленко", "Настя", "ФАИС", "ИП41", "16.07.2002"));
            add(new Student("Гудойть", "Влад", "МТФ", "ИП41", "31.10.2000"));
            add(new Student("Макеев", "Миша", "МСФ", "ИП41", "12.11.2000"));
            add(new Student("Падалица", "Максим", "ЭФ", "ИП41", "06.09.2001"));
        }
    };

    public static Contract.Model getModel() {
        if (model == null)
            model = new Model();
        return model;
    }

    @Override
    public List<Student> get() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void edit(Student oldStudent, Student newStudent) {
        students.remove(oldStudent);
        students.add(newStudent);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }
}
