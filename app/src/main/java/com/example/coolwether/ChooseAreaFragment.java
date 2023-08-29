package com.example.coolwether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author 作者: mac
 * @date 日期: 2023/8/29
 * @Description: 选择地区碎片
 */

public class ChooseAreaFragment extends Fragment {


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  /**
   * 查询全国所有的省， 优先从数据库查询， 如果没有查询到在去服务器上查询
   */
  private void queryProvinces() {

  }
}
