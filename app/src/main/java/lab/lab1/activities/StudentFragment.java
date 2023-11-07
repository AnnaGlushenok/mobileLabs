package lab.lab1.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import lab.lab1.Contract;
import lab.lab1.R;
import lab.lab1.Student;
import lab.lab1.StudentAdapter;
import lab.lab1.presenters.StudentPresenter;

public class StudentFragment extends Fragment implements Contract.View.MainView, Find {
    private ListView listView;
    public Contract.Presenter.MainPresenter presenter;
    private StudentAdapter adapter;
    public Student selectedStudent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        presenter = new StudentPresenter(this);
        listView = view.findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedStudent = (Student) adapterView.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putString("selectedStudent", selectedStudent.toString());
                getParentFragmentManager().setFragmentResult("selectedStudent", bundle);
            }
        });

        presenter.showAll();
        return view;
    }

    @Override
    public void showAllStudents(List<Student> students) {
        adapter = new StudentAdapter(this.getActivity(), students);
        listView.setAdapter(adapter);
    }

    @Override
    public void showStudentsByDepartment(List<Student> students) {
        adapter = new StudentAdapter(this.getActivity(), students);
        listView.setAdapter(adapter);
    }

    @Override
    public void find(String criteria) {
        presenter.onCriteriaEnter(criteria);
    }
}