package mvp.com.main.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huang_jin on 2017/10/12.
 * 实现Parcelable序列化传递对象步骤：
 * 1、将实体数据写进Parcel对象容器中
 *    将Bean类实现Parcelable接口，实现两个抽象方法
 *      writeToParcel(Parcel in,int a):将实体数据写进Parcel容器中
 *      describeContents()：描述传递的内容
 * 2、从Parcel容器中获取实体数据
 *     创建静态实例Parcelable.Creator接口的静态实例对象，复写两个抽象方法：
 *     createFromParcel(Parcel in)
 *     newArray(int i)
 */

public class User implements Parcelable{
    private String name;
    private String password;

    public User(){}

    public User(Parcel in){
        name =  in.readString();
        password = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //--------------------------------parcelable---------------------------------------

    //内部实现一个Creator创建器接口
    private static final Creator<User> CREATOR = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {//实现从Parcel中获取读取数据得值
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    @Override
    public int describeContents() {
        //描述内容
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //将数据写进一个Parcel对象中
         parcel.writeString(name);
         parcel.writeString(password);
    }
}
