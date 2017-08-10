package com.example.welcome.editbox_with_eye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
/*
* Created by neha
* We have two ways for achieving this task:-
* 1. To make a custom edit box with right drawable.
* 2. To use image button(for eye) with edit box.
*/
public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private EditText editText;
    private CustomEditBox editBox;
    private static boolean flag =false;
    private static boolean flag2 =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first way:-
        usingCustomEditBox();
        //second way:-
        usingImageButton();
    }

    public void usingImageButton(){
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        editText = (EditText) findViewById(R.id.editText3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2){
                    imageButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.cey));
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    flag2 = false;
                }
                else {
                    imageButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.ope));
                    editText.setTransformationMethod(new PasswordTransformationMethod());
                    flag2 = true;
                }
                editText.setSelection(editBox.getText().length());
            }
        });
    }
    public void usingCustomEditBox(){
        editBox = (CustomEditBox) findViewById(R.id.editText);
        editBox.setDrawableClickListener(new CustomEditBox.DrawableClickListener() {

            public void onClick(DrawablePosition target) {
                switch (target) {
                    case LEFT:

                        break;
                    case RIGHT:
                        if(flag){
//                            editBox.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            editBox.setTransformationMethod(null);
                            editBox.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.cey, 0);
                            flag = false;
                        }
                        else {
                            editBox.setTransformationMethod(new PasswordTransformationMethod());
                            editBox.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ope, 0);
                            flag = true;
                        }
                        editBox.setSelection(editBox.getText().length());
                        break;
                    default:
                        break;
                }
            }

        });

    }
}
