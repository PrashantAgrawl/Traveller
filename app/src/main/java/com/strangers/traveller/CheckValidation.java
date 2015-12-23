package com.strangers.traveller;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Bhantu Prashant on 26-09-2015.
 */
public class CheckValidation {

    public CheckValidation(){

    }
    private final String TAG = "Check";


    // VALID EMAIL
    public static boolean isValidEmail(CharSequence target) {
        if (target==null)
            return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    // NAME
    public boolean check_name( Context context,String uname) {

        if (TextUtils.isEmpty(uname)) {
            Log.d(TAG, "name Validation");
            return false;
        }
        else
            return true;
    }

    // EMAIL
    public boolean check_email( Context context,String email) {

        if (TextUtils.isEmpty(email) || !isValidEmail(email)){
            Log.d(TAG, "email Validation");
            return false;
        }
        else
            return true;
    }

    //PASSWORD
    public boolean check_passwd( Context context,String passwd) {
        if (((TextUtils.isEmpty(passwd) || (passwd.length() < 6)))) {
            Log.d(TAG, "password Validation");
            return false;
        } else
            return true;
    }

    //CONFIRM PASSWORD
    public boolean check_confirm( Context context,String passwd,String confirm) {

        if ((((TextUtils.isEmpty(confirm) || confirm.length() < 6)))) {
            Log.d(TAG,"confirm Validation");
            return false;
        }
        else if (!(passwd.equals(confirm))) {
            return false;
        }
        else
            return true;
    }

    public boolean check_phone( Context context,String phone) {

        if (phone.length()==10) {
            int i,flag=0;
            for(i=0;i<10;i++)
            {
                if(phone.charAt(i)>='0' && phone.charAt(i)<='9')
                    continue;
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                Log.d(TAG, "phone Validation");
                return false;
            }
            return true;
        }
        else
            return false;
    }
    public boolean check_dob( Context context,String dob) {

        if(TextUtils.isEmpty(dob)){
            Log.d(TAG, "dob Validation");
            return false;
        } else
            return true;
    }
}

