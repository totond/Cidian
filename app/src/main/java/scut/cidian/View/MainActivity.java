package scut.cidian.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import scut.cidian.Presenter.CidianPresenter;
import scut.cidian.R;

public class MainActivity extends AppCompatActivity implements fanyiView {
    private CidianPresenter cidianPresenter;
    private EditText et;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findViewById(R.id.btnfanyi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cidianPresenter.ModelGetData(et.getText().toString(), MainActivity.this);
            }
        });
    }

    public void init() {
        cidianPresenter = new CidianPresenter(this);
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.tv);
    }//初始化

    @Override
    public void SetError() {
        tv.setText("查询不成功，请检查网络");
    }//输出出错信息

    public void SetInfo(String str) {
        tv.setText(str);
    }//输出翻译信息


}
