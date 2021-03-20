package com.togapp.samplefrgment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // mainFragment는 XML파일에 <Fragment>로 추가되어 있기 때문에 id를 찾아와야한다.
        // Activity 클래스에 있는것을 사용할수 없다 (기존에 사용하던 방법으로는 안된다)
        // -> FragmentManager를 사용해 findFragmentById() 메서드를 사용해 찾는다.
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        // 메뉴 프래그먼트는 new 연산자로 새로운 객체를 만들어 변수에 할당한다.
        menuFragment = new MenuFragment();


    }

    public void onFragmentChanged(int index){

        // 메인 액티비티에서 프래그먼트를 사용하려면
        // getFragmentManager()를 호출해 매니저 객체를 참조해야한다.
        // public FragmentManager getFragmentManager()
        // 프래그먼트 매니저는 프개르먼트를 추가, 삭제, 교체 등의 작업을 해주는데
        // 프래그먼트를 변경할 때 오류가 생기면 다시 원래 상태로 돌릴 수 있어야 해서 트랜잭션을 사용한다.
        // 트랜잭션 객체는 beginTransaction() 메서드를 호출하면 시작
        // commit()하면 실행

        if (index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
        } else if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();

        }
    }

}