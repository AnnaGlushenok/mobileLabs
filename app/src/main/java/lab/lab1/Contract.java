package lab.lab1;

import java.util.List;

public interface Contract {
    interface Model {
        List<Student> get();

        void add(Student student);

        void edit(Student student);

        void delete(Student student);
    }

    interface View {// это вью

        interface MainView {
            void showAllStudents( List<Student> students);

            void showStudentsByDepartment();

            void showStudentsByBirth();

            void deleteStudent();
        }

        interface AddView {
            void addStudent();
        }

        interface EditView {
            void editStudent();
        }
    }

    interface Presenter {// а это связь, шота типа BLL

        void onStart();

        void onAddStudentClick();

        void onEditStudentClick();

        void onStudentsByDepartmentClick();

        void onStudentsByBirthClick();
    }
}
