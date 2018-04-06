package com.luuva.orderfood;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.luuva.adapter.UserAdapter;
import com.luuva.model.User;

import java.util.ArrayList;
public class UserFragment extends Fragment {
    ListView lvItem;
    ArrayList<User> dsUser;
    UserAdapter userAdapter;
    TextView tvTT;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        tvTT = view.findViewById(R.id.btnInformation);

        lvItem = view.findViewById(R.id.lvItem);
        dsUser = new ArrayList<>();

        dsUser.add(new User("Lịch sử", R.drawable.icon_1));
        dsUser.add(new User("Yêu thích", R.drawable.icon_2));
        dsUser.add(new User("PayNow", R.drawable.icon_3));
        dsUser.add(new User("Điạ chỉ", R.drawable.icon_4));
        dsUser.add(new User("Hoá đơn", R.drawable.icon_5));
        dsUser.add(new User("Mời bạn bè", R.drawable.icon_6));
        dsUser.add(new User("Góp ý", R.drawable.icon_7));
        dsUser.add(new User("Chính sách quy định", R.drawable.icon_8));
        dsUser.add(new User("Cài đặt", R.drawable.icon_9));

        userAdapter = new UserAdapter(getActivity(),R.layout.user_item,dsUser);
        lvItem.setAdapter(userAdapter);
        tvTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"Test",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),UserInformation.class) ;
                startActivity(intent);
            }
        });
        return view;
    }
    public void thongTin(View view){
        Intent intent = new Intent(view.getContext(),UserInformation.class) ;
        startActivity(intent);
    }
}
