package com.example.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TinhtienActivity extends AppCompatActivity {
    // khai báo các thành phần giao diện
    EditText edtsonuocfee,edtngaytaodon,edttienphongfee,edttiendichvufee,edttiendienfee;
    TextView edttenfee,edttenphongfee;
    Button btntinhtien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhtien);
        addControl();// gọi hàm ánh xạ đến các thành phần trong giao diện
        addEvent();// gọi hàm xử lý
    }

    private void addEvent() {
        // lấy dữ liệu được chuyển sang từ màn hình trước
        Intent gettotal=getIntent();
        RoomInfomation getRoom= (RoomInfomation) gettotal.getSerializableExtra("roomtotalfee");
        String name=getRoom.getHovaten().toString();
        String roomname=getRoom.getTenphong().toString();
        int tienphong=getRoom.getTienphong();
        int tiendichvu=getRoom.getTiendichvu();
        int tiendien=getRoom.getTiendien();
        int tiennuoc=getRoom.getTiennuoc();
        // hiển thị một số thông tin phòng
        edttenfee.setText(name);
        edttenphongfee.setText(roomname);
        edttienphongfee.setText(String.valueOf(tienphong));
        edttiendichvufee.setText(String.valueOf(tiendichvu));
        btntinhtien.setOnClickListener(new View.OnClickListener() { // xử lý khi người dùng ấn nút tính tiền
            @Override
            public void onClick(View view) {
                Intent intentgive=new Intent(TinhtienActivity.this,ThanhToanActivity.class);
                // lấy dữ liệu người dùng điền vào
                String tennguoithue=edttenfee.getText().toString();
                String tenphong=edttenphongfee.getText().toString();
                String ngaytao=edtngaytaodon.getText().toString();
                try{
                    // ép kiểu và tính tiền
                    int tienphongthanhtoan=Integer.parseInt(edttienphongfee.getText().toString());
                    int tiendichvuthanhtoan=Integer.parseInt(edttiendichvufee.getText().toString());

                    int tiendienthanhtoan=tiendien*Integer.parseInt(edttiendienfee.getText().toString());

                    int tiennuocthanhtoan=tiennuoc*Integer.parseInt(edtsonuocfee.getText().toString());
                    // tạo đối tượng thông tin phòng với thông tin thanh toán để chuyển qua màn hình kế tiếp
                    RoomInfomation sendtt=new RoomInfomation(tennguoithue,tenphong,tienphongthanhtoan,tiendichvuthanhtoan,tiendienthanhtoan,tiennuocthanhtoan,ngaytao);
                    intentgive.putExtra("thongtinthanhtoan",sendtt);
                    startActivity(intentgive); // chuyển sang màn hình thanh toán
                }
                catch (NumberFormatException e){
                    // nếu không ép kiểu được thì bắt lỗi và in ra thông báo
                    Toast.makeText(TinhtienActivity.this,"bạn đã nhập sai định dạng",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void addControl() {
        // hàm ánh xạ đến các thành phần giao diện
        edttenfee=(TextView) findViewById(R.id.txttenfee);
        edttenphongfee=(TextView) findViewById(R.id.edttenphongfee);
        edttienphongfee= (EditText) findViewById(R.id.edttienphongfee);
        edttiendichvufee= (EditText) findViewById(R.id.edttiendichvufee);
        edttiendienfee= (EditText) findViewById(R.id.edttiendienfee);
        edtsonuocfee=(EditText) findViewById(R.id.edttiennuocfee);
        //edttongtienfee=(TextView)findViewById(R.id.edttongtienfee);
        edtngaytaodon=(EditText) findViewById(R.id.ngaytaodonfee);
        btntinhtien=(Button) findViewById(R.id.btntinhtien);
    }
}