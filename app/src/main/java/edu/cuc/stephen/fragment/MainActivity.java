package edu.cuc.stephen.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private Fragment lastFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getFragmentManager();
        lastFragment = fragmentManager.findFragmentById(R.id.fragmentStatic);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i){
            case R.id.radioButtonStatic:
                Fragment staticFragment = fragmentManager.findFragmentById(R.id.fragmentStatic);
                if (lastFragment != staticFragment) {
                    fragmentManager.popBackStack();
                }
                lastFragment = staticFragment;
                break;
            case R.id.radioButtonDynamic:
                DynamicFragment dynamicFragment = new DynamicFragment();
                if (lastFragment != dynamicFragment) {
                    fragmentTransaction.replace(R.id.frame, dynamicFragment);
                    fragmentTransaction.addToBackStack("Dynamic Fragment");
                    fragmentTransaction.commit();
                }
                lastFragment = dynamicFragment;
                break;
            case R.id.radioButtonLifeCycle:
                LifeCycleFragment lifeCycleFragment = new LifeCycleFragment();
                if(lastFragment != lifeCycleFragment){
                    fragmentTransaction.replace(R.id.frame, lifeCycleFragment);
                    fragmentTransaction.addToBackStack("Lifecycle Fragment");
                    fragmentTransaction.commit();
                }
                lastFragment = lifeCycleFragment;
                break;
            case R.id.radioButtonComm:
                break;
            default:
                break;
        }
    }
}
