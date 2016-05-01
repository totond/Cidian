package scut.cidian.Presenter;

import android.content.Context;

import scut.cidian.Model.fanyi;
import scut.cidian.Model.fanyimodel;
import scut.cidian.View.fanyiView;

/**
 * Created by yany on 2016/4/5.
 */
public class CidianPresenter implements onfanyiListener,ICidianPresenter {
    private fanyimodel fanyimodel;
    private fanyi fy;
    private fanyiView fyV;

    public  CidianPresenter(fanyiView fyV){
        this.fyV = fyV;
        fanyimodel = new fanyimodel();
    }//重构函数，初始化View接口实例和model实例

    public void ModelGetData(String input, Context context){
        fanyimodel.HandleData(input, context, this);
    }//将View层获得的数据传入Model层


    public void onSuccess(String str) {
        fyV.SetInfo(str);
    }//回调函数，调用UI更新

    @Override
    public void onError() {
        fyV.SetError();
    }//回调函数，调用UI输出出错信息
}
