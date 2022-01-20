package ru.buran9.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button mainTrueButton;
    private Button mainFalseButton;
    private Button mainNextButton;
    private TextView mainQuestionTextview;
    private int questionCurrentIndex =0;
    List<Question> questionBank = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionBank.add(new Question(R.string.question_1, true));
        questionBank.add(new Question(R.string.question_2, true));
        questionBank.add(new Question(R.string.question_3, false));
        questionBank.add(new Question(R.string.question_4, false));
        questionBank.add(new Question(R.string.question_5, true));

        mainFalseButton = (Button) findViewById(R.id.button_main_false);
        mainTrueButton = (Button) findViewById(R.id.button_main_true);
        mainNextButton = (Button) findViewById(R.id.button_main_next);
        mainQuestionTextview = (TextView) findViewById(R.id.textview_main_question);
        mainQuestionTextview.setText(questionBank.get(questionCurrentIndex).getResTextId());

        mainNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionCurrentIndex = (questionCurrentIndex + 1) % questionBank.size();
                updateQuestion();
            }
        });

        mainTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mainFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

    }

    private void updateQuestion() {
        int questionId = questionBank.get(questionCurrentIndex).getResTextId();
        mainQuestionTextview.setText(questionId);
    }

    private void checkAnswer(boolean userPressTrue) {
        boolean answerTrueFalse = questionBank.get(questionCurrentIndex).isAnswerTrueFalse();

        int msgResId = 0;
        if (userPressTrue == answerTrueFalse) {
            msgResId = R.string.toast_correct;
        } else {
            msgResId = R.string.toast_incorrect;
        }

        Toast.makeText(MainActivity.this, msgResId, Toast.LENGTH_SHORT).show();

    }
}