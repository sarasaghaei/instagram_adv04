package ir.sarasaghaei.instagram_adv04.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ir.sarasaghaei.instagram_adv04.R;

public class MoreBottomSheetFragment extends BottomSheetDialogFragment {

    TextView tv_report,tv_notifpost,tv_copylink,tv_share,tv_unfollow,tv_mute;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_bottomsheet =  inflater.inflate(R.layout.fragment_more_bottomsheet , null);
        tv_report = view_bottomsheet.findViewById(R.id.tv_report);
        tv_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_report.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tv_notifpost = view_bottomsheet.findViewById(R.id.tv_notifpost);
        tv_notifpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_notifpost.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tv_copylink = view_bottomsheet.findViewById(R.id.tv_copylink);
        tv_copylink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_copylink.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tv_share = view_bottomsheet.findViewById(R.id.tv_share);
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_share.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tv_unfollow = view_bottomsheet.findViewById(R.id.tv_unfollow);
        tv_unfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_unfollow.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tv_mute = view_bottomsheet.findViewById(R.id.tv_mute);
        tv_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), tv_mute.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return view_bottomsheet;

    }


}
