package com.codingclubcet.romeojuliet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {
    int[][] mat=new int[3][3];
    int[][] fmat=new int[3][3];
    Button[][] b=new Button[3][3];
    Boolean clicked=false;
    int p=0,q=0,temp;
    private Camera camera;
    private boolean isFlashOff=true;
    private boolean hasFlash;
    Camera.Parameters params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        hasFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!hasFlash) {
            // device doesn't support flash
            // Show alert message and close the application
            AlertDialog alert = new AlertDialog.Builder(MyActivity.this).create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, your device doesn't support flash light!");
            alert.setButton(0,"OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                }
            });
            alert.show();
            return;
        }
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++) {
                mat[i][j] = i * 3 + j + 1;
                fmat[j][i] = i * 3 + j + 1;
            }

        b[0][0]=(Button)findViewById(R.id.button);
        b[0][1]=(Button)findViewById(R.id.button1);
        b[0][2]=(Button)findViewById(R.id.button2);
        b[1][0]=(Button)findViewById(R.id.button3);
        b[1][1]=(Button)findViewById(R.id.button4);
        b[1][2]=(Button)findViewById(R.id.button5);
        b[2][0]=(Button)findViewById(R.id.button6);
        b[2][1]=(Button)findViewById(R.id.button7);
        b[2][2]=(Button)findViewById(R.id.button8);
        b[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[0][0];
                    mat[0][0]=mat[p][q];
                    mat[p][q]=temp;
                    b[0][0].setText(""+mat[0][0]);
                    b[p][q].setText(""+mat[p][q]);
                    clicked=false;
                    sum();
                    Check();
                }
                else{
                    clicked=true;
                    p=0;
                    q=0;
                }
            }
        });
        b[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[0][1];
                    mat[0][1]=mat[p][q];
                    mat[p][q]=temp;
                    b[0][1].setText("" + mat[0][1]);
                    b[p][q].setText(""+mat[p][q]);
                    clicked=false;
                    Check();
                    sum();
                }
                else{
                    clicked=true;
                    p=0;
                    q=1;
                }
            }
        });
        b[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[0][2];
                    mat[0][2]=mat[p][q];
                    mat[p][q]=temp;
                    b[0][2].setText("" + mat[0][2]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=0;
                    q=2;
                }
            }
        });
        b[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[1][0];
                    mat[1][0]=mat[p][q];
                    mat[p][q]=temp;
                    b[1][0].setText(""+mat[1][0]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=1;
                    q=0;
                }
            }
        });
        b[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[1][1];
                    mat[1][1]=mat[p][q];
                    mat[p][q]=temp;
                    b[1][1].setText(""+mat[1][1]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=1;
                    q=1;
                }
            }
        });
        b[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[1][2];
                    mat[1][2]=mat[p][q];
                    mat[p][q]=temp;
                    b[1][2].setText(""+mat[1][2]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=1;
                    q=2;
                }
            }
        });
        b[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[2][0];
                    mat[2][0]=mat[p][q];
                    mat[p][q]=temp;
                    b[2][0].setText(""+mat[2][0]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=2;
                    q=0;
                }
            }
        });
        b[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked) {
                    temp = mat[2][1];
                    mat[2][1]=mat[p][q];
                    mat[p][q]=temp;
                    b[2][1].setText(""+mat[2][1]);
                    b[p][q].setText(""+mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                }
                else{
                    clicked=true;
                    p=2;
                    q=1;
                }
            }
        });
        b[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    temp = mat[2][2];
                    mat[2][2] = mat[p][q];
                    mat[p][q] = temp;
                    b[2][2].setText("" + mat[2][2]);
                    b[p][q].setText("" + mat[p][q]);
                    sum();
                    Check();
                    clicked=false;
                } else {
                    clicked = true;
                    p = 2;
                    q = 2;
                }
            }
        });

    }
    public void sum(){
        TextView t=(TextView)findViewById(R.id.textView);
        int sum=0;
        for(int i=0;i<3;i++) {
            sum=sum+mat[i][0]*100+mat[i][1]*10+mat[i][2];
        }
        t.setText(""+sum);
    }

    public void Check(){
        for(int i=0;i<3;i++)
            for (int j = 0; j < 3; j++)
                if (mat[i][j] != fmat[i][j]) {
                    turnOffFlash();
                    return;
                }
        getCamera();
        turnOnFlash();
    }
    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (RuntimeException e) {
                Log.e("Camera Error. Failed to Open. Error: ", e.getMessage());
            }
        }
    }
    private void turnOnFlash() {
        if (isFlashOff) {
            if (camera == null || params == null) {
                return;
            }
            // play sound

            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOff = false;
        }


    }
    private void turnOffFlash() {
        if (!isFlashOff) {
            if (camera == null || params == null) {
                return;
            }
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOff = true;
            if (camera != null) {
                camera.release();
                camera = null;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id==R.id.action_settings||super.onOptionsItemSelected(item);
    }
}
