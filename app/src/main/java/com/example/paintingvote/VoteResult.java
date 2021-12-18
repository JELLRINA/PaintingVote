package com.example.paintingvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount"); //정수형 ,
        String[] imageName = intent.getStringArrayExtra("ImageName"); //문자열 받고 배열로 저장

        //이미지를 배열 선언
        Integer imageFileld[]  = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 };

        //우승그림 선언 대입
        TextView tvTop = (TextView) findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView) findViewById(R.id.ivTop);
        int maxEntry = 0; //최대 값
        //i값이 최대값보다 클동안 반복
        for (int i = 0; i < voteResult.length; i++){
            if(voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]); //결과 이름
        ivTop.setImageResource(imageFileld[maxEntry]); //결과 이미지

        //9개의 tv, rbar 객체 배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        //9개의 tv,rbar id배열
        Integer tvID[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        //tv, rbar 개체 찾기
        for(int i = 0; i < voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        // tv, rbar에 넘겨 받은 값을 반영
        for (int i = 0; i < voteResult.length; i++){
            tv[i].setText(imageName[i]); //
            rbar[i].setRating((float) voteResult[i]); //별점 결과값
        }
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}