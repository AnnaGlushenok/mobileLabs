package lab.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private List<Student> students;

    public StudentAdapter(@NonNull Context context, List<Student> students) {
        super(context, R.layout.card, students);
        this.students = students;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);

        Student student = students.get(position);
        TextView name = convertView.findViewById(R.id.student_name);
        TextView mark = convertView.findViewById(R.id.student_mark);

        name.setText(student.getName());
        mark.setText(String.valueOf(student.getMark()));
        return convertView;
    }
}
