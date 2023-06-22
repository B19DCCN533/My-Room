package com.example.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThongtinActivity extends AppCompatActivity {
    // khai báo các thành phần giao diện
    TextView edttentt,edtghichutt,edtngaysinhtt,edtcmndtt,edtngaythuett,edttenphongtt,edtsodienthoaitt,edttienphongtt,edttiendichvutt,edttiendientt,edttiennuoctt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        addControls(); // gọi hàm ánh xạ đến các thành phần trong giao diện
        addEvent();// gọi hàm xử lý
    }

    private void addEvent() {
        Intent intent1=getIntent(); // tạo intent để nhận thông tin phòng được gửi sang
        // lấy thông tin phòng từ màn hình trước gửi sang
        RoomInfomation room=(RoomInfomation) intent1.getSerializableExtra("info");
        // hiển thị các thông tin của phòng
        edttentt.setText(room.getHovaten());
        edtngaysinhtt.setText(room.getNgaysinh());
        edtcmndtt.setText(room.getCmnd());
        edtsodienthoaitt.setText(room.getSodienthoai());
        edtngaythuett.setText(room.getNgaythue());
        edttenphongtt.setText(room.getTenphong());
        edttienphongtt.setText(String.valueOf(room.getTienphong()));
        edttiendichvutt.setText(String.valueOf(room.getTiendichvu()));
        edttiennuoctt.setText(String.valueOf(room.getTiennuoc()));
        edttiendientt.setText(String.valueOf(room.getTiendien()));
        edtghichutt.setText(room.getGhichu());

    }

    private void addControls() {
        // hàm ánh xạ đến các thành phần giao diện
        edttentt= (TextView) findViewById(R.id.edthotentt);
        edtngaysinhtt= (TextView) findViewById(R.id.edtngaysinhtt);
        edtcmndtt= (TextView) findViewById(R.id.edtcmndtt);
        edtngaythuett= (TextView) findViewById(R.id.edtngaythuett);
        edtsodienthoaitt= (TextView) findViewById(R.id.edtsodienthoaitt);
        edttenphongtt=(TextView) findViewById(R.id.edttenphongtt);
        edttienphongtt=(TextView) findViewById(R.id.edttienphongtt);
        edttiendichvutt=(TextView) findViewById(R.id.edtdichvutt);
        edttiennuoctt=(TextView) findViewById(R.id.edttiennuoctt);
        edttiendientt=(TextView) findViewById(R.id.edttiendientt);
        edtghichutt=(TextView) findViewById(R.id.edtghichutt);
    }
}