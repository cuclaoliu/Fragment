package edu.cuc.stephen.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifeCycleFragment extends Fragment {

    private TextView textView;

    public LifeCycleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life_cycle, container, false);
        textView = (TextView) view.findViewById(R.id.textLifeCycle);
        textView.setText("观察Fragment生命周期\n");
        textView.append("LifeCycleFragment --> onCreateView()，每次创建都会绘制Fragment的组件时调用\n");
        return  view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textView.append("LifeCycleFragment --> onStart()，当启动Fragment时调用\n");
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.append("LifeCycleFragment --> onResume()，当恢复Fragment时调用，onStart之后\n");
    }

    @Override
    public void onPause() {
        super.onPause();
        textView.append("LifeCycleFragment --> onPause()，当暂停Fragment时调用\n");
    }

    @Override
    public void onStop() {
        Log.i("Main", "LifeCycleFragment --> onStop()，当停止Fragment时调用");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Main", "LifeCycleFragment --> onDestroyView()，当销毁Fragment所包含的View组件时调用");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Main", "LifeCycleFragment --> onDestroy()，当销毁Fragment时调用");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("main", "LifeCycleFragment --> onDetach()，当Fragment从Activity中删除时调用，且只调用一次");
        super.onDetach();
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("main", "LifeCycleFragment --> onAttach()，当添加Fragment到Activity时调用，且只调用一次");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //textView.append("LifeCycleFragment --> onCreate()，当创建Fragment时调用，且只调用一次");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.append("LifeCycleFragment --> onActivityCreate()，当Fragment所在的Activity启动完成后调用\n");
    }
}
