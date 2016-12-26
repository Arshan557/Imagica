package com.arshan.imagic;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends ActionBarActivity {
    private static final int REQUEST_WRITE_STORAGE = 1;
    private static final int REQUEST_GALLERY = 2;
    int imgHeight, imgWidth;
    ImageView img, img2,camera, gallery, save, share, blank;
    private Bitmap bmp, bmp2;
    private Bitmap operation;
    private RelativeLayout mainRelative;
    private LinearLayout effects;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int GALLERY_IMAGE_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
        img2 = (ImageView) findViewById(R.id.img);
        camera = (ImageView) findViewById(R.id.camera);
        gallery = (ImageView) findViewById(R.id.gallery);
        save = (ImageView) findViewById(R.id.save);
        share = (ImageView) findViewById(R.id.share);
        blank = (ImageView) findViewById(R.id.blank);
        mainRelative = (RelativeLayout) findViewById(R.id.mainRelative);
        effects = (LinearLayout) findViewById(R.id.effects);

        imgHeight = camera.getLayoutParams().height;
        imgWidth = camera.getLayoutParams().width;
    }
    public void buttonClicked(View v){
        Effects effects = new Effects();

        if(v.getId() == R.id.original){
            if (null != bmp) {
                img.setImageBitmap(bmp2);
                bmp = bmp2;
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect1) {
            if (null != bmp) {
                operation = effects.effect1(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect2) {
            if (null != bmp) {
                operation = effects.effect2(bmp, 1 ,40);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect4) {
            if (null != bmp) {
                operation = effects.effect2(bmp, 3 ,66);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect5) {
            if (null != bmp) {
                operation = effects.effect3(bmp, 80);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect7) {
            if (null != bmp) {
                operation = effects.effect4(bmp, 0, 255, 0);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect8) {
            if (null != bmp) {
                operation = effects.effect4(bmp, 0, 0, 255);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect9) {
            if (null != bmp) {
                operation = effects.effect5(bmp, 64);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect10) {
            if (null != bmp) {
                operation = effects.effect5(bmp, 32);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect11) {
            if (null != bmp) {
                operation = effects.effect6(bmp, 50);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect12) {
            if (null != bmp) {
                operation = effects.effect7(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect13) {
            if (null != bmp) {
                operation = effects.effect8(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect14) {
            if (null != bmp) {
                operation = effects.effect9(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect16) {
            if (null != bmp) {
                operation = effects.effect11(bmp, 1.8, 1.8, 1.8);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect17) {
            if (null != bmp) {
                operation = effects.effect12(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect18) {
            if (null != bmp) {
                operation = effects.effect13(bmp, 2);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect19) {
            if (null != bmp) {
                operation = effects.effect14(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect20) {
            if (null != bmp) {
                operation = effects.effect15(bmp);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect23) {
            if (null != bmp) {
                operation = effects.effect18(bmp, 10, 1.5, 0.6, 0.12);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect24) {
            if (null != bmp) {
                operation = effects.effect18(bmp, 10, 0.88, 2.45, 1.43);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect25) {
            if (null != bmp) {
                operation = effects.effect18(bmp, 10, 1.2, 0.87, 2.1);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect28) {
            if (null != bmp) {
                operation = effects.effect20(bmp, Color.CYAN);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect29) {
            if (null != bmp) {
                operation = effects.effect20(bmp, Color.YELLOW);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect30) {
            if (null != bmp) {
                operation = effects.effect20(bmp, Color.GREEN);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.effect31) {
            if (null != bmp) {
                operation = effects.effect21(bmp, 100);
                img.setImageBitmap(operation);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.img) {
            if (null == bmp) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(230, 230);
                camera.setLayoutParams(layoutParams);
                gallery.setLayoutParams(layoutParams);
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if (v.getId() == R.id.camera) {

            boolean hasPermission = (ContextCompat.checkSelfPermission(MainActivity.this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
            if (!hasPermission) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA},
                        REQUEST_WRITE_STORAGE);
            } else {
                // selectImage();
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
            }




        } else if (v.getId() == R.id.gallery) {

            boolean hasPermission = (ContextCompat.checkSelfPermission(MainActivity.this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
            if (!hasPermission) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA},
                        REQUEST_GALLERY);
            } else {
                // selectImage();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select image"), GALLERY_IMAGE_REQUEST_CODE);
            }
        } else if (v.getId() == R.id.save) {
            if (null != bmp) {
                BitmapDrawable abmp = (BitmapDrawable) img.getDrawable();
                bmp = abmp.getBitmap();
                saveImageFile(bmp);
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else if(v.getId() == R.id.share) {
            if (null != bmp) {
                BitmapDrawable abmp = (BitmapDrawable) img.getDrawable();
                bmp = abmp.getBitmap();
                OutputStream out = null;
                File file = new File(Environment.getExternalStorageDirectory().getPath(), "ImagicA");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String filename = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
                try {
                    out = new FileOutputStream(filename);
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                    /**Update image to gallery**/
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, filename);
                    values.put(MediaStore.Images.Media.DESCRIPTION, filename);
                    values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
                    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                    values.put(MediaStore.MediaColumns.DATA, filename);

                    getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                    Uri bmpUri = Uri.parse(filename);
                    final Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    share.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    share.setType("image/png");
                    startActivity(Intent.createChooser(share, "Share via"));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Snackbar snackbar = Snackbar.make(mainRelative, "Choose image from Gallery or Camera", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {



            case REQUEST_WRITE_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //reload my activity with permission granted or use the features what required the permission
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Please allow us to Take picture from your device", Toast.LENGTH_LONG).show();
                }
            }
            break;


            case REQUEST_GALLERY:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //reload my activity with permission granted or use the features what required the permission
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select image"), GALLERY_IMAGE_REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Please allow us to Take picture from your device", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
            BitmapDrawable abmp = (BitmapDrawable) img.getDrawable();
            bmp = abmp.getBitmap();
            bmp2 = bmp;
            Toast.makeText(MainActivity.this,"Apply effects",Toast.LENGTH_LONG).show();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imgHeight, imgWidth);
            camera.setLayoutParams(layoutParams);
            gallery.setLayoutParams(layoutParams);
            blank.setVisibility(View.VISIBLE);
            save.setVisibility(View.VISIBLE);
            share.setVisibility(View.VISIBLE);
            effects.setVisibility(View.VISIBLE);
        } else if (requestCode == GALLERY_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && null != data) {

            if (resultCode == RESULT_OK && data != null && data.getData() != null) {

                Uri uri = data.getData();

                try {
                Bitmap thumbnail_r = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    // Log.d(TAG, String.valueOf(bitmap));
                    //  image.setBackground(null);
                    //  image.setImageBitmap(thumbnail_r);
                    if (thumbnail_r != null) {
                            img.setImageBitmap(thumbnail_r);
                        if (data == null) {
                            //no data present
                            return;
                        }
                        BitmapDrawable abmp = (BitmapDrawable) img.getDrawable();
                        bmp = abmp.getBitmap();
                        bmp2 = bmp;
                        Toast.makeText(MainActivity.this,"Apply effect now",Toast.LENGTH_LONG).show();
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imgHeight, imgWidth);
                        camera.setLayoutParams(layoutParams);
                        gallery.setLayoutParams(layoutParams);
                        blank.setVisibility(View.VISIBLE);
                        save.setVisibility(View.VISIBLE);
                        share.setVisibility(View.VISIBLE);
                        effects.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
         /*   Uri selectedImage = data.getData();
            InputStream imageStream = null;
            try {
                imageStream = getContentResolver().openInputStream(selectedImage);
            } catch (FileNotFoundException e) {
                Toast.makeText(MainActivity.this, "" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
            Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
            img.setImageURI(selectedImage);*/

        }
    }

    public void saveImageFile(Bitmap bitmap) {
        OutputStream out = null;
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "ImagicA");
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            /**Update image to gallery**/
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, filename);
            values.put(MediaStore.Images.Media.DESCRIPTION, filename);
            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.MediaColumns.DATA, filename);

            getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Snackbar snackbar = Snackbar.make(mainRelative, "Image saved to ImagicA folder", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
