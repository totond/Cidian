package scut.cidian.Presenter;

import android.content.Context;

/**
 * Created by yany on 2016/4/5.
 */
public interface ICidianPresenter {
    //将View层获得的数据传入Model层
    void ModelGetData(String input, Context context);
}
