package com.example.paintingvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        //그림의 투표수를 저장할 변수를 선언 및 초기화
        for (int i = 0; i < voteCount.length; i++)
            voteCount[i] = 0;
        //9개의 이미지뷰 버튼 객체 배열
        ImageView image[] = new ImageView[9];
        //9개의 이미지뷰 버튼 id 배열
        Integer imageId[] = {R.id.iv1, R.id.iv2,R.id.iv3, R.id.iv4,R.id.iv5, R.id.iv6,R.id.iv7, R.id.iv8,R.id.iv9};

        //문자열 그림 제목 배열
        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };

        for (int i = 0; i < imageId.length; i++) {
            final int index; //꼭 필요!
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]); //배열된 이미지뷰를 ID 대입
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이미지 클릭 시
                    //투표수 증가
                    voteCount[index]++;
                    // 클릭시 나오는 메세지에 이미지뷰 이름 + 득표수 보여주기 :보여질 글자 간격 잘 맞추기
                    Toast.makeText(getApplicationContext(),imgName[index] + " : 총 " + voteCount[index] + " 표",Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VoteResult.class); //메인.this대신 getApplicationContext() 써도 무방
                intent.putExtra("VoteCount", voteCount); //정수형,
                intent.putExtra("ImageName",imgName); //문자열 넘김
                startActivity(intent); // 보내기
            }
        });

    }
}