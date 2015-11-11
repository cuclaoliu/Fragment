package edu.cuc.stephen.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StaticFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Layout布局文件转换成View对象
        //参数1, resource，Fragment需要加载的布局文件
        //参数2, root，加载Layout的父ViewGroup
        //参数3, attactRoot，不返回
        View view = inflater.inflate(R.layout.fragment_static, container, false);
        final TextView textView = (TextView) view.findViewById(R.id.textStatic);
        Button button = (Button) view.findViewById(R.id.buttonStatic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("文本内容已修改");
                Toast.makeText(getActivity(), "静态加载按钮点击", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
