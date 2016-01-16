package com.psw.park.apidemoempty;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/*
*     주요 class의 사용법을 예제로 돌려본다.
*     가능한 MainActivity class에 몰아서 구현했다.
*     코딩하기 편할 수는 있어도 가독성은 나쁘다.
*     java에서 class 별로 나누어야 하는 이유를 몸소 느끼게 하기위해서 이렇게 만들었다.
*
* */
public class MainActivity extends AppCompatActivity {
    ListView lstMain = null;
    ArrayList lst    =  new <String>ArrayList();

    ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListView();
    }

    // ListView를 화면에 구성한다.
    public void setListView(){
        lstMain = (ListView) findViewById(R.id.listview);

        // Android에서 제공해주는 템플릿으로 ArrayAdapter를 만들고 setAdapter()로 lstMain과
        // 연동한다.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lst);
        lstMain.setAdapter(adapter);

        // 리스트에 보여줄 항목을 String 배열로 선언
        String [] EXAMPLES = {
                "File",
                "SharedPrefernece",
                "Log",
                "serializable",
                "Enviroment",
                "assets",
                "Handler",
                "AsyncTask"
        };

        // EXAMPLES 리스트의 항목을 ListView에 추가한다.
        for(int i = 0; i < EXAMPLES.length;i++){
            addListItem(EXAMPLES[i]);
        }

        lstMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 리스트를 클릭했을 때, 몇 번째인지 알려준다.
                doAction(position);
            }
        });

    }

    // 선택된 리스트에 맞는 메소드를 호출한다.
    void doAction(int nIndex){
        switch (nIndex){
            case 0:
                break;

            default:
                doNothing();
        }
    }

    // ListView에 Item을 저장하고 리스트화면을 갱신한다.
    public void addListItem(String sMessage){
        lst.add(sMessage);

        // 화면을 갱신한다. -> 항목이 많을 때는 상당히 느려지는 원인임.
        // 일반적으로는 모든 항목을 Add 한 후에 한번 갱신하는 구조가 좋다.
        adapter.notifyDataSetChanged();
    }

    /*
    *
    * 여기서 부터 Example을 실행하는 메소드를 구현하도록 하자!!
    *
    * */
    private void doNothing() {
    }
}