package com.example.text_to_speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech mTTS;
    private EditText mEditText;
    private Button mButtonSpeak;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonSpeak=findViewById(R.id.button_speak);
         mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result =mTTS.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA||result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","LANGUAGE NOT SUPPORTED");

                    }else{
                        mButtonSpeak.setEnabled(true);
                    }
                }else{
                    Log.e("TTS","INITIALIZATION FIALED");
                }
            }

        });

         mEditText=findViewById(R.id.edit_text);
         mButtonSpeak.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 speak();
             }
         });
    }
    private void speak(){
        String text=mEditText.getText().toString();
        mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onDestroy() {
        if(mTTS!=null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }


}
