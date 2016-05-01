package scut.cidian.Model;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import scut.cidian.Presenter.onfanyiListener;
import scut.cidian.Model.Ifanyimodel;


public class fanyimodel implements Ifanyimodel{
    private fanyi fy = new fanyi();
    public void HandleData(String input,Context context,final onfanyiListener listener){
        //使用Volley框架来实现异步从网络的有道API获取翻译数据
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest("http://fanyi.youdao.com/openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q="+input, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                //用Gson方式解析获得的json字符串
                Gson gson = new Gson();
                fy = gson.fromJson(s.trim(),fy.getClass());
                //回调监听器的函数
                listener.onSuccess(fanyiToString(fy));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError();
            }
        });
        mQueue.add(stringRequest);
    }
    public String fanyiToString(fanyi fy){
        //处理解析后的json数据，转成UI输出的字符串
        String strexplain = "解释：";
        String strphonetic = "发音：";
        String strweb = "网络释义：";
        if (fy.basic == null){return "你所查找的还没有准确翻译";}
        for (int i = 0; i<fy.basic.explains.length; i++){
            strexplain +=fy.basic.explains[i]+"\n";
            if (i != fy.basic.explains.length-1 )
            {strexplain +="\t\t\t\t";}
        }
        strphonetic += fy.basic.phonetic +"\n";
        for (int i = 0; i<fy.web.size(); i++){
            for(int j = 0; j<fy.web.get(i).value.length;j++)
            {
                strweb += fy.web.get(i).value[j]+",";
            }
            strweb += fy.web.get(i).key+"\n";
            strweb += "\t\t\t\t\t\t\t";
        }
        return strexplain+"\n"+strphonetic+"\n"+strweb;
    }

}
