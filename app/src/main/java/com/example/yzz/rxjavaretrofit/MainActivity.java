package com.example.yzz.rxjavaretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.yzz.rxjavaretrofit.beans.City;
import com.example.yzz.rxjavaretrofit.beans.CityBean;
import com.example.yzz.rxjavaretrofit.beans.UploadFileBean;
import com.example.yzz.rxjavaretrofit.network.CallBack;
import com.example.yzz.rxjavaretrofit.util.RxUtil;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.button:
                App.getInstance().CreateApiRequest().getPrivinceList("")
                        .flatMap(new Function<CityBean, ObservableSource<City>>() {
                            //转换
                            @Override
                            public ObservableSource<City> apply(@NonNull CityBean cityBean) throws Exception {
                                List<City> city = cityBean.getDataList();
                                return Observable.fromIterable(city);
                            }
                        })
                        .filter(new Predicate<City>() {
                            //过滤
                            @Override
                            public boolean test(@NonNull City city) throws Exception {
                                if (city.getItemName().equals("北京市")) {
                                    return true;
                                }
                                return false;
                            }
                        })
                        .compose(RxUtil.<City>applySchedulers())
                        .subscribe(new CallBack<City>(MainActivity.this, false) {
                            @Override
                            public void onSuccess(City city) {
                                super.onSuccess(city);
                                textview.setText(city.toString());
                            }
                        });
                break;
            case R.id.button2:
                File file = new File("/storage/emulated/0/uniterich/images/compress/cert_face.jpg");
                RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), body);
                String descriptionString = "hello, this is description speaking";
                RequestBody description =
                        RequestBody.create(
                                MediaType.parse("multipart/form-data"), descriptionString);
                App.getInstance().CreateApiRequest().upFile(description, part)
                        .compose(RxUtil.<UploadFileBean>applySchedulers())
                        .subscribe(new CallBack<UploadFileBean>(MainActivity.this, false) {
                            @Override
                            public void onSuccess(UploadFileBean uploadFileBean) {
                                super.onSuccess(uploadFileBean);
                                Log.i("yzz", "uploadFileBean==" + uploadFileBean.getFilePath());
                            }
                        });
                break;
            case R.id.button3:
                break;
            default:
                break;

        }
    }
}
