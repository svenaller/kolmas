package ee.ut.www.kolmas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button btnTakePhoto;
    ImageView takenPhoto;
    private static final int CAM_REQUEST = 1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakePhoto = (Button) findViewById(R.id.btnTakePhoto);
        takenPhoto = (ImageView) findViewById(R.id.takenPhoto);
        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAM_REQUEST) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            takenPhoto.setImageBitmap(thumbnail);
        }
    }

    public void pressbutton(View v) {
        TextView text = (TextView) findViewById(R.id.text);
        if (text.getText() == "One") {
            text.setText("Two");
        } else {
            text.setText("One");
        }
    }

    class btnTakePhotoClicker implements Button.OnClickListener
    {
        public void onClick(View v) {
            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraintent, CAM_REQUEST);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
