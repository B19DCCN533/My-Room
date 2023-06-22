package com.example.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    // khai báo các thành phần giao diện
    EditText edttenedit,edtngaysinhedit,edtcmndedit,edtngaythueedit,edttenphongedit,edtsodienthoaiedit,edttienphongedit
            ,edttiendichvuedit,edttiendienedit,edttiennuocedit,edtghichuedit;
    Button btnxacnhanedit;
    Database editdatabase;
    Intent intent=null;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editdatabase=new Database(this,"thongtinnnN.sqlite",null,1);
        addControl();// gọi hàm ánh xạ đến các thành phần trong giao diện
        addEvent();// gọi hàm xử lý
    }
    private void addEvent(){
        intent =getIntent(); // tạo intent để nhận dữ liệu và chuyển màn hình
        // lấy thông tin phòng từ màn hình trước gửi sang
        RoomInfomation room=(RoomInfomation) intent.getSerializableExtra("info1");
        int mainid=room.getId();
        System.out.println(mainid);
        // thực hiện hiển thị thông tin lên các trường để người dùng chỉnh sửa
        edttenedit.setText(room.getHovaten());
        edtngaysinhedit.setText(room.getNgaysinh());
        edtcmndedit.setText(room.getCmnd());
        edtsodienthoaiedit.setText(room.getSodienthoai());
        edtngaythueedit.setText(room.getNgaythue());
        edttenphongedit.setText(room.getTenphong());
        edttienphongedit.setText(String.valueOf(room.getTienphong()));
        edttiendichvuedit.setText(String.valueOf(room.getTiendichvu()));
        edttiennuocedit.setText(String.valueOf(room.getTiennuoc()));
        edttiendienedit.setText(String.valueOf(room.getTiendien()));
        btnxacnhanedit.setOnClickListener(new View.OnClickListener() {
            // hàm xử lý khi người dùng chọn xác nhận
            @Override
            public void onClick(View view) {
                ContentValues values=new ContentValues();
                // nếu người dùng không điền các trường ký tự thì để mặc định là đang để trống
                if(edttenedit.getText().toString().equals(""))
                {
                    edttenedit.setText("Đang để trống");
                }
                if(edtngaysinhedit.getText().toString().equals(""))
                {
                    edtngaysinhedit.setText("Đang để trống");
                }
                if(edtsodienthoaiedit.getText().toString().equals(""))
                {
                    edtsodienthoaiedit.setText("Đang để trống");
                }
                if(edtcmndedit.getText().toString().equals(""))
                {
                    edtcmndedit.setText("Đang để trống");
                }
                if(edtngaythueedit.getText().toString().equals(""))
                {
                    edtngaythueedit.setText("Đang để trống");
                }
                if(edttenphongedit.getText().toString().equals(""))
                {
                    edttenphongedit.setText("Đang để trống");
                }
                if(edtghichuedit.getText().toString().equals(""))
                {
                    edtghichuedit.setText("Không có ghi chú");
                }
                try {
                    // khi người dùng ấn xác nhận thì sẽ lấy dữ liệu từ phần giao diện và ép kiểu
                    // và lưu vào trong database
                    values.put("Name",edttenedit.getText().toString());
                    values.put("Age",edtngaysinhedit.getText().toString());
                    values.put("Phone",edtsodienthoaiedit.getText().toString());
                    values.put("Cmnd",edtcmndedit.getText().toString());
                    values.put("Ngaythue",edtngaythueedit.getText().toString());
                    values.put("Roomname",edttenphongedit.getText().toString());
                    values.put("Tienphong",Integer.parseInt(edttienphongedit.getText().toString()));
                    values.put("Tiendichvu",Integer.parseInt(edttiendichvuedit.getText().toString()));
                    values.put("Tiendien",Integer.parseInt(edttiendienedit.getText().toString()));
                    values.put("Tiennuoc",Integer.parseInt(edttiennuocedit.getText().toString()));
                    values.put("Note",edtghichuedit.getText().toString());
                    String mid=String.valueOf(mainid);
                    long res=editdatabase.getWritableDatabase().update("thongtintungphonggg1",values,"Id=?",new String[]{mid});
                    if(res>0)
                    {   // nếu lưu dẽ liệu và databse thành công thì in ra thông báo và thêm vào 2 arraylist
                        Toast.makeText(EditActivity.this,"Thanh cong",Toast.LENGTH_SHORT).show();
//                    Intent newin=new Intent(EditActivity.this,ActionActivity.class);
                        String name=edttenedit.getText().toString();
                        String age=edtngaysinhedit.getText().toString();
                        String phone =edtsodienthoaiedit.getText().toString();
                        String cmnd=edtcmndedit.getText().toString();
                        String ngaythue=edtngaythueedit.getText().toString();
                        String tenphong=edttenphongedit.getText().toString();
                        int tienphong=Integer.parseInt(edttienphongedit.getText().toString());
                        int tiendichvu=Integer.parseInt(edttiendichvuedit.getText().toString());
                        int tiendien=Integer.parseInt(edttiendienedit.getText().toString());
                        int tiennuoc=Integer.parseInt(edttiennuocedit.getText().toString());
                        String ghichupedit=edtghichuedit.getText().toString();
                        RoomInfomation sendroom=new RoomInfomation(name,age,phone,cmnd,ngaythue,tenphong,tienphong,tiendichvu,tiendien,tiennuoc,ghichupedit);
                        intent.putExtra("sendinfo",sendroom);// gửi trả dữ liệu về màn hình trước
//                    startActivity(newin);
                        setResult(115,intent);
                        finish();
                    }
                    else
                    {   // nếu không lưu được vào database thì thông báo lưu không thành công
                        Toast.makeText(EditActivity.this,"Khong thanh cong",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException e){
                    // nếu có lỗi xảy ra trong quá trình ép kiểu thì thông báo sai định dạng
                    Toast.makeText(EditActivity.this,"bạn đã nhập sai định dạng",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void addControl() {
        // hàm ánh xạ đến các thành phần giao diện
        edttenedit=(EditText) findViewById(R.id.edttenedit);
        edtngaysinhedit=(EditText) findViewById(R.id.edtngaysinhedit);
        edtsodienthoaiedit=(EditText) findViewById(R.id.edtsodienthoaiedit);
        edtcmndedit=(EditText) findViewById(R.id.edtcmndedit);
        edtngaythueedit=(EditText) findViewById(R.id.edtngaythueedit);
        edttenphongedit=(EditText) findViewById(R.id.edttenphongedit);
        edttienphongedit=(EditText) findViewById(R.id.edttienphongedit);
        edttiendichvuedit=(EditText) findViewById(R.id.edttiendichvuedit);
        edttiendienedit=(EditText) findViewById(R.id.edttiendienedit);
        edttiennuocedit=(EditText) findViewById(R.id.edttiennuocedit);
        btnxacnhanedit=(Button) findViewById(R.id.btnxachnhanedit);
        edtghichuedit=(EditText) findViewById(R.id.edtghichuedit);
    }
}