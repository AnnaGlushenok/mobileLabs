package lab.lab1;

import java.util.List;

public interface Contract {
    interface Model {
        List<Student> get();

        void add(Student student);

        void edit(Student oldStudent, Student newStudent);

        void delete(Student student);
    }

    interface View {

        interface MainView {
            void showAllStudents(List<Student> students);

            void showStudentsByDepartment(List<Student> students);
        }

        interface AddView {
            void addStudent();

            void onClose();
        }

        interface EditView {
            void editStudent();

            void onClose();
        }
    }

    interface Presenter {

        interface MainPresenter {
            void showAll();

            void onAddStudentClick();

            void onEditStudentClick(Student student);

            void onDeleteStudentClick(Student student);

            void onStudentsByDepartmentClick(String department);

            void onStudentsByBirthClick(String birth);
        }

        interface AddPresenter {
            void onAddStudent(Student student);
        }

        interface EditPresenter {
            void onEditStudent(Student oldStudent, Student newStudent);
        }
    }
}
