package com.i4da.easylvl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.Policy;
import com.google.android.vending.licensing.ServerManagedPolicy;

public class EasyLicenseChecker {
    //TODO: Put your app license key.
    private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiLShb1ZrHnf2mJvOeta79/6lbwK3YAj4NRYBYyedwdjvxMr5geN8xnuEHCa+lx4PWs4EEWX9uDHN3EQINTHK91LGd9MNU7tRbd7NrnF0r+msaHznpx0TKj6nkgBP6VZBHDrxRcoaDst4tjYWvmdClO059kWk0Xwxt6RrM9O0XvCyUN5AfyddSfU/R52+3hMzNtBOHJjg8myW8MTCHKR8qjoS0QZW9rDcjBCBc/dIQ7O6rUUvMcgQfH9473fn1PvWBAchjUvX5ZG+Z4lDVlSdQW0s1IC78exCWmfRoHKbIttEk4yr3EIcvo+Bd2g4mLY5nE/EBhS5P4tGmSMn9i5T/wIDAQAB";
    //TODO: Generate your own 20 random bytes, and put them here.
    private static final byte[] SALT = new byte[]{
            -46, 65, 30, -128, -103, -57, 74, -64, 51, 88, -95, -45, 77, -117, -36, -113, -11, 32,
            -64, 89
    };
    private LicenseChecker mChecker = null;
    private Handler mHandler = null;
    private Activity mActivity = null;

    public EasyLicenseChecker(Activity activity, Handler handler) {
        if (activity == null) throw new IllegalArgumentException("activity is null");
        if (handler == null) throw new IllegalArgumentException("handler is null");

        mHandler = handler;
        mActivity = activity;
        String deviceId = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        mChecker = new LicenseChecker(mActivity,
                new ServerManagedPolicy(mActivity, new AESObfuscator(SALT,
                        mActivity.getPackageName(), deviceId)),
                BASE64_PUBLIC_KEY);
    }

    public void start() {
        final AlertDialog waitingDialog = new AlertDialog.Builder(mActivity)
                .setMessage("Verifying License...")
                .setCancelable(false)
                .show();

        mChecker.checkAccess(new LicenseCheckerCallback() {
            public void allow(int policyReason) {
                if (mActivity.isFinishing()) return;

                waitingDialog.dismiss();
            }

            public void dontAllow(int policyReason) {
                if (mActivity.isFinishing()) return;

                waitingDialog.dismiss();
                if (policyReason == Policy.RETRY) {
                    displayTechnicalError("P" + policyReason);
                } else {
                    displayInvalidLicenseError();
                }
            }

            public void applicationError(int errorCode) {
                if (mActivity.isFinishing()) return;

                waitingDialog.dismiss();
                displayTechnicalError("E" + errorCode);
            }
        });
    }

    public void finish() {
        if (mChecker != null) mChecker.onDestroy();
    }

    private void displayTechnicalError(final String reasonCode) {
        showAlertDialog(
                "Error occurred while verifying license. Please restart the application after a while." +
                        "[" + reasonCode + "]",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mActivity.finish();
                    }
                }
        );
    }

    private void displayInvalidLicenseError() {
        showAlertDialog("License is invalid. Please download the application again on the store.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mActivity.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=" +
                                        mActivity.getPackageName())));
                        mActivity.finish();
                    }
                }
        );
    }

    private void showAlertDialog(final String message,
                                 final DialogInterface.OnClickListener listener) {
        mHandler.post(new Runnable() {
            public void run() {
                new AlertDialog.Builder(mActivity)
                        .setMessage(message)
                        .setCancelable(false)
                        .setPositiveButton("OK", listener)
                        .show();
            }
        });
    }
}
