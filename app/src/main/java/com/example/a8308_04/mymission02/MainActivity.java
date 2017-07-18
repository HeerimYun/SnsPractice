package com.example.a8308_04.mymission02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //요소 선언
    Button btnSend, btnClose;
    TextView tv; //글자수
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //MainActivity extends AppCompatActivity 덕분에 사용가능

        //ui 요소 가져오기
        btnSend = (Button) findViewById(R.id.btnSend);
        btnClose = (Button) findViewById(R.id.btnClose);
        tv = (TextView) findViewById(R.id.textView1);
        edt = (EditText) findViewById(R.id.editText);

        //버튼 리스너(this) 두개
        btnSend.setOnClickListener(this); // 클래스가 리스너 인터페이스를 상속받아야함 (클래스 이름 뒤에 implements View.OnClickListener 추가)
        btnClose.setOnClickListener(this);

        //text와쳐 객체 생성
        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { //글자 화면 찍히기 전

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { //글자 바뀌는 중

            }

            @Override
            public void afterTextChanged(Editable editable) { //글자 다 찍힌 이우
                int strlen = editable.toString().length();
                if (strlen >= 0) {
                    tv.setText(Integer.toString(strlen));
                }
            }
        };

        edt.addTextChangedListener(tw); //위에 텍스트와쳐 객체를 리스너에 넘겨줌 : 실제 글자가 바뀔때 실행

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //onClick, 스위치문으로 버튼 아이디로 구분, 코드
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:
                Toast.makeText(getApplicationContext(), edt.getText().toString(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btnClose:
                finish();
                break;
        }
    }

    //옵션메뉴 - 이거는 다음 프로젝트

}
