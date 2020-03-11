package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;

import android.widget.Button;

import android.widget.ImageButton;
import android.widget.TextView;

import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech mTTS;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd,btnSubtract,btnDivide,btnMultiply,btnEqual,btnClear,btnBracket,btnDot,btnAllClear;
    TextView tvOutput;
    EditText tvInput;
    ImageButton btnSpeak;
    String process;
    boolean checkBracket=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);


        btnAdd=findViewById(R.id.btnAdd);
        btnSubtract=findViewById(R.id.btnSubtract);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);
        btnClear=findViewById(R.id.btnClear);

        btnAllClear=findViewById(R.id.btnAllClear);
        btnBracket=findViewById(R.id.btnBracket);
        btnDot=findViewById(R.id.btnDot);
        btnEqual=findViewById(R.id.btnEqual);
        btnSpeak=findViewById(R.id.btnSpeak);

        tvInput=findViewById(R.id.tvInput);
        tvOutput=findViewById(R.id.tvOutput);


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result =mTTS.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA||result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","LANGUAGE NOT SUPPORTED");

                    }else{
                        btnEqual.setEnabled(true);
                    }
                }else{
                    Log.e("TTS","INITIALIZATION FIALED");
                }
            }

        });


        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tvInput.getText().toString().equals("")){
                    String value=tvInput.getText().toString();
                    if(value.length()>0){
                        value=value.substring(0,value.length()-1);
                    }
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"+");
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"-");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"/");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"×");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+".");
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(checkBracket){
                process=tvInput.getText().toString();
                tvInput.setText(process+")");
                checkBracket=false;
            }else{
                process=tvInput.getText().toString();
                tvInput.setText(process+"(");
                checkBracket=true;
            }
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 10);
                } else {
                    Toast.makeText(getApplicationContext(),"Your Device Dont support Speech",Toast.LENGTH_SHORT).show();

                }
            }

        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            process=tvInput.getText().toString();
            process=process.replaceAll("×","*");
            process=process.replaceAll("%","/100");
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            String finalresult="";
            try {
                Scriptable scriptable=rhino.initStandardObjects();
                finalresult=rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
            }catch (Exception e) {
                finalresult = "0";
            }
                tvOutput.setText(finalresult);
                speak();
            }


        });


        }

    private void speak(){
        String text=tvOutput.getText().toString();
        mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
    protected void onDestroy() {
        if(mTTS!=null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tvInput.setText(result.get(0));
                }
                break;
        }
    }

}
