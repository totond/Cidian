package scut.cidian.Model;

import android.content.Context;

import scut.cidian.Presenter.onfanyiListener;

/**
 * Created by yany on 2016/4/5.
 */
public interface Ifanyimodel {
    void HandleData(String input,Context context,onfanyiListener listener);
    String fanyiToString(fanyi fy);
}
