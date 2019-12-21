package com.example.quizzapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzActivity extends AppCompatActivity {
    private Button btntrue1;
    private Button btnfalse1;
    private TextView askQuestion;
    private  TextView score;
    private  TextView textViewNumQuestion;;
    private int numQuestion = 1;
    //permet d'avoir la fonction random donc les valeurs aléatoires
    private static  int indice=(int)(Math.random()*7);
    private  int s=0;
    //permet de creer un tableau de question
    private Question[] questions=new Question[]{
            new Question(false,R.string.q1),
            new Question(true,R.string.q2),
            new Question(false,R.string.q3),
            new Question(true, R.string.q4),
            new Question(false, R.string.q5),
            new Question(false, R.string.q6),
            new Question(false, R.string.q7),
    };
    //fonction de lire les réponses et de passer à une autre réponse
    private void lire_Reponse(boolean reponse_envoye ){
        //permet de recuperer la reponse de la question
        boolean reponse=questions[indice].isRerponse();
        //comparaison entre la reponse envoyé et la reponse correcte
        if(reponse==reponse_envoye){
            s++;
            Toast.makeText(QuizzActivity.this, "correct", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(QuizzActivity.this, "incorrect", Toast.LENGTH_LONG).show();

        }
        indice=(int)(Math.random()*7);
        askQuestion.setText(questions[indice].getQuestion());
        score.setText("score:"+s);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        this.btntrue1= (Button) findViewById(R.id.btntrue1);
        //Permet de récupérer un id associé à une vue
        this.btnfalse1= (Button) findViewById(R.id.btnfalse1);
        this.askQuestion=findViewById(R.id.askQuestion);
        this.score=findViewById(R.id.score);
        textViewNumQuestion = (TextView) findViewById(R.id.tvNumQuestion);

       //affiche le score

        score.setText("Score:"+s);
        //affiche question
        askQuestion.setText(questions[indice].getQuestion());
        textViewNumQuestion.setText("Question " + numQuestion + "/10"

        );
        numQuestion++;


        //permet de déclencher une autre acivité par un simple clic
        btntrue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lire_Reponse(true);
                if(numQuestion <= 10)
                {

                    textViewNumQuestion.setText("Question " + numQuestion + "/10");
                    numQuestion++;
                }
                else {
                    askQuestion.setText("QUIZZ terminé");
                    AlertDialog dialog = new AlertDialog.Builder(QuizzActivity.this)
                            .setTitle("Jeu termine")
                            .setNegativeButton("Ok", null)
                            .create();
                    dialog.show();
                }

            }
        });
        btnfalse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lire_Reponse(false);
                if(numQuestion <= 10)
                {

                    textViewNumQuestion.setText("Question " + numQuestion + "/10");
                    numQuestion++;
                }
                else {
                    askQuestion.setText("QUIZZ terminé");
                    AlertDialog dialog = new AlertDialog.Builder(QuizzActivity.this)
                            .setTitle("Felitation")
                            .setNegativeButton("Ok", null)
                            .create();
                    dialog.show();
                }

            }
        });







    }}