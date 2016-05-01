package scut.cidian.Presenter;

import scut.cidian.Model.fanyi;

/**
 * Created by yany on 2016/4/6.
 */
public interface onfanyiListener {
    //成功时的回调
    void onSuccess(String str);
    //失败时候的回调
    void onError();
}
