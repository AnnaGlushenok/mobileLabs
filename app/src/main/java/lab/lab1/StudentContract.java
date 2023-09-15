package lab.lab1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class StudentContract extends ActivityResultContract<List<Student>, Boolean> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, List<Student> students) {
        return new Intent(context, MainActivity.class).putExtra("students", (Serializable) students);
    }

    @Override
    public Boolean parseResult(int i, @Nullable Intent intent) {
        return i == Activity.RESULT_OK;
    }
}
