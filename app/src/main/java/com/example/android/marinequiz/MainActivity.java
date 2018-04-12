package com.example.android.marinequiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    /**
     * The method is called when you press the "Submit Your Answers" button
     */
    public void submitAnswers(View view) {

        int points = 0;

        //Question 1
        RadioButton radioButton_q1 = findViewById (R.id.optionB_q1);
        boolean firstQuestionCorrect = radioButton_q1.isChecked ();
        if (firstQuestionCorrect) {
            points += 1;
        }
        //Question 2
        RadioButton radioButton_q2 = findViewById (R.id.optionC_q2);
        boolean secondQuestionCorrect = radioButton_q2.isChecked ();
        if (secondQuestionCorrect) {
            points += 1;
        }

        //Question 3 - in order to get a point in Question 3,  three particular boxes has to be checked
        CheckBox checkAns1_q3 = findViewById (R.id.checkbox1_q3);
        boolean thirdQuestionAnswer1 = checkAns1_q3.isChecked ();
        CheckBox checkAns2_q3 = findViewById (R.id.checkbox2_q3);
        boolean thirdQuestionAnswer2 = checkAns2_q3.isChecked ();
        CheckBox checkAns3_q3 = findViewById (R.id.checkbox3_q3);
        boolean thirdQuestionAnswer3 = checkAns3_q3.isChecked ();
        CheckBox checkAns4_q3 = findViewById (R.id.checkbox4_q3);
        boolean thirdQuestionAnswer4 = checkAns4_q3.isChecked ();
        CheckBox checkAns5_q3 = findViewById (R.id.checkbox5_q3);
        boolean thirdQuestionAnswer5 = checkAns5_q3.isChecked ();
        CheckBox checkAns6_q3 = findViewById (R.id.checkbox6_q3);
        boolean thirdQuestionAnswer6 = checkAns6_q3.isChecked ();
        CheckBox checkAns7_q3 = findViewById (R.id.checkbox7_q3);
        boolean thirdQuestionAnswer7 = checkAns7_q3.isChecked ();
        if (thirdQuestionAnswer2 && thirdQuestionAnswer3 && thirdQuestionAnswer6 && !thirdQuestionAnswer1 && !thirdQuestionAnswer4 && !thirdQuestionAnswer5 && !thirdQuestionAnswer7) {
            points = points + 1;
        }

        //Question 4
        RadioButton radioButton_q4 = findViewById (R.id.optionC_q4);
        boolean forthQuestionCorrect = radioButton_q4.isChecked ();
        if (forthQuestionCorrect) {
            points += 1;
        }

        //Question 5
        EditText fifthAnswer = findViewById (R.id.q5_answer);
        String fifthAnswerText = fifthAnswer.getText ().toString ();
        if (fifthAnswerText.equals ("")) {
            Toast.makeText (getApplicationContext (), getString (R.string.noFifthAnswer), Toast.LENGTH_LONG).show ();
            return;
        } else if ((fifthAnswerText.equals ("Pacific")) || ((fifthAnswerText.equals ("Pacific Ocean")))) {
            points += 1;
        }

        //Question 6
        RadioButton radioButton_q6 = findViewById (R.id.optionA_q6);
        boolean sixthQuestionCorrect = radioButton_q6.isChecked ();
        if (sixthQuestionCorrect) {
            points += 1;
        }

        //Showing the result to the user
        displayScore (points);
    }

    /**
     * This method displays the result and its message to the user.
     *
     * @param score User's result
     */
    private void displayScore(int score) {

        String strScore = String.valueOf (score);
        String message = getString (R.string.yourScoreIs) + strScore + getString (R.string.outOf6);

        if (score == 0) message += getString (R.string.score_zero);

        if (score == 1 || score == 2 || score == 3) message += getString (R.string.score_low);

        if (score == 4 || score == 5) message += getString (R.string.score_notBad);

        if (score == 6) message += getString (R.string.score_six);

        Toast.makeText (getApplicationContext (), message, Toast.LENGTH_LONG).show ();

    }


}
