package com.example.myroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThanhToanActivity extends AppCompatActivity {
    // khai báo các thành phần giao diện
    EditText edttenthanhtoan,edttenphongthanhtoan,edtngaylamdon,edttienphongthanhtoan,edttiendienthanhtoan,edttiendichvuthanhtoan,edttiennuocthanhtoan,edtghichuthanhtoan;
    TextView txtthanhtoan;
    Button btnthanhtoan,btnxuathoadon,btnguitinnhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        addControl();// gọi hàm ánh xạ đến các thành phần trong giao diện
        addEvent();// gọi hàm xử lý
        verity(ThanhToanActivity.this);
        btnxuathoadon.setOnClickListener(new View.OnClickListener() {
            // hàm xử lý khi người dùng nhấn nút chụp màn hình
            @Override
            public void onClick(View view) {
                // thực hiện chụp màn hình và in ra thông báo
                takeScreenshot(getWindow().getDecorView().getRootView(),"result");
                Toast.makeText(ThanhToanActivity.this,"Đã lưu ảnh vào thư mục Files,vào thư mục Files rồi chọn thư mục Download để tìm ảnh",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addEvent() {
        // lấy thông tin từ màn hình trước
        Intent receive=getIntent();
        RoomInfomation rece= (RoomInfomation) receive.getSerializableExtra("thongtinthanhtoan");
        // tạo form và hiển thị thông tin
        edtngaylamdon.setText(rece.getNgaytao());
        edttenthanhtoan.setText(rece.getHovaten());
        edttenphongthanhtoan.setText(rece.getTenphong());
        edttienphongthanhtoan.setText(String.valueOf(rece.getTienphong()));
        edttiendichvuthanhtoan.setText(String.valueOf(rece.getTiendichvu()));
        edttiendienthanhtoan.setText(String.valueOf(rece.getTiendien()));
        edttiennuocthanhtoan.setText(String.valueOf(rece.getTiennuoc()));
        // ép kiểu dữ liệu nhận được và tính tổng tiền cần thanh toán
        int total=Integer.parseInt(edttienphongthanhtoan.getText().toString())+Integer.parseInt(edttiendichvuthanhtoan.getText().toString())+
                Integer.parseInt(edttiendienthanhtoan.getText().toString())+Integer.parseInt(edttiennuocthanhtoan.getText().toString());
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hiển thị tổng số tiền cần thanh toán khi nhấn nút tính tiền
                txtthanhtoan.setText(String.valueOf(total));
            }
        });
        btnguitinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khi người dùng nhấn nút gửi tin nhắn chương trình sẽ ép kiểu các dữ liệu thanh toán
                Intent intent=new Intent(ThanhToanActivity.this,SendMessageActivity.class);
                int tienphongphaidong=Integer.parseInt(edttienphongthanhtoan.getText().toString());
                int tiendienphaidong=Integer.parseInt(edttiendienthanhtoan.getText().toString());
                int tiennuocphaidong=Integer.parseInt(edttiennuocthanhtoan.getText().toString());
                int tiendichvuphaidong=Integer.parseInt(edttiendichvuthanhtoan.getText().toString());
                if(txtthanhtoan.getText().toString().equals(""))
                {
                    txtthanhtoan.setText("đã xảy ra lỗi");
                }// nếu tính toán sai thì in ra lỗi
                int tongtien=Integer.parseInt(txtthanhtoan.getText().toString()); // ép kiểu tổng tiền cần thanh toán về int
                // chuyển các thông tin thanh toán vào intent để gửi sang màn hình gửi tin nhắn
                intent.putExtra("tong",tongtien);
                intent.putExtra("dien",tiendienphaidong);
                intent.putExtra("dichvu",tiendichvuphaidong);
                intent.putExtra("nuoc",tiennuocphaidong);
                intent.putExtra("tienphong",tienphongphaidong);
                startActivity(intent);// chuyển sang màn hình gửi tin nhắn
            }
        });
    }
    private static File takeScreenshot(View view, String fileName)
    {       // hàm xử lý chức năng chụp màn hình
            Date date=new Date();
            CharSequence format=android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss",date);
            try {
                String dirPath= Environment.getExternalStorageDirectory()+"/result";
                File fileDir=new File(dirPath);
                if(!fileDir.exists())
                {
                    boolean mkdir=fileDir.mkdir();
                }
                String path=Environment.getExternalStorageDirectory()+"/Download/"+ Calendar.getInstance().getTime().toString() +".jpeg";
                view.setDrawingCacheEnabled(true);
                Bitmap bitmap= Bitmap.createBitmap(view.getDrawingCache());
                view.setDrawingCacheEnabled(false);
                File imageFile=new File(path);
                FileOutputStream fileOutputStream=new FileOutputStream(imageFile);
                int quality=100;
                bitmap.compress(Bitmap.CompressFormat.JPEG,quality,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return imageFile;
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
    // thực hiện xin các quyền từ máy của người dùng
    private static final int REQUEST_EXTERNAL_STORAGE=1;
    private  static String[] PERMISSION_STORAGE={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    public static void verity(Activity activity)
    {
        int permission=ActivityCompat.checkSelfPermission(activity,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permission!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity,PERMISSION_STORAGE,REQUEST_EXTERNAL_STORAGE);
        }
    }
    private void addControl() {
        // hàm ánh xạ tới các thành phần giao diện
        edttenthanhtoan=(EditText) findViewById(R.id.tennguoithuethanhtoan);
        edttenphongthanhtoan=(EditText) findViewById(R.id.tenphongthanhtoan);
        edtngaylamdon=(EditText) findViewById(R.id.ngayxuatdonthanhtoan);
        edttienphongthanhtoan=(EditText) findViewById(R.id.tienphongthanhtoan);
        edttiendienthanhtoan=(EditText) findViewById(R.id.tiendienthanhtoan);
        edttiennuocthanhtoan=(EditText) findViewById(R.id.tiennuocthanhtoan);
        edttiendichvuthanhtoan=(EditText) findViewById(R.id.tiendichvuthanhtoan);
        edtghichuthanhtoan=(EditText) findViewById(R.id.ghichuthanhtoan);
        txtthanhtoan=(TextView) findViewById(R.id.tongtienphaithanhtoan);
        btnthanhtoan=(Button) findViewById(R.id.btnthanhtoan);
        btnxuathoadon=(Button) findViewById(R.id.xuathoadon);
        btnguitinnhan=(Button) findViewById(R.id.guitinnhansms);
    }
}