package ggikko.me.apttwo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import me.ggikko.GgikkoAnnotation;
import me.ggikko.GgikkoMessageHandler;

@GgikkoAnnotation
public class MainActivity extends AppCompatActivity {

    @GgikkoAnnotation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAnnotationMessage();

    }

    private void showAnnotationMessage() {
        GgikkoMessageHandler generatedClass = new GgikkoMessageHandler();
        String message = generatedClass.getMessage();
        // android.support.v7.app.AlertDialog
        new AlertDialog.Builder(this)
                .setPositiveButton("Ok", null)
                .setTitle("Annotation Processor Messages")
                .setMessage(message)
                .show();
    }
}
