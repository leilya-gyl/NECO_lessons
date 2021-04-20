package ru.startandroid.develop.handbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private int category;
    private int position;
    private int[] array_fish = {R.string.fish1, R.string.fish2, R.string.fish3, R.string.fish4, R.string.fish5};
    private int[] array_corm = {R.string.corm1, R.string.corm2, R.string.corm3, R.string.corm4};
    private int[] array_tools = {R.string.tool1, R.string.tool2, R.string.tool3, R.string.tool4};
    private int[] array_story = {R.string.story1, R.string.story2, R.string.story3, R.string.story4};
    private int[] array_advice = {R.string.advice1, R.string.advice2, R.string.advice3, R.string.advice4};
    private int[] array_image_fish = {R.drawable.karp, R.drawable.shchuka, R.drawable.som, R.drawable.osetr, R.drawable.nalim};
    private TextView text_content;
    private ImageView image_content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        image_content = findViewById(R.id.image_content);
        receiveIntent();
    }
    private void receiveIntent(){
        Intent my_intent = getIntent();
        if(my_intent != null){
            category = my_intent.getIntExtra("category", 0);
            position = my_intent.getIntExtra("position", 0);
        }
        switch(category) {
            case 0:
                image_content.setImageResource(array_image_fish[position]);
                text_content.setText(array_fish[position]);
                break;
            case 1:
                text_content.setText(array_corm[position]);
                break;
            case 2:
                text_content.setText(array_tools[position]);
                break;
            case 3:
                text_content.setText(array_story[position]);
                break;
            case 4:
                text_content.setText(array_advice[position]);
                break;
        }
    }
}
