package alvianosi.viewpagesource;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConnectInternetTask c1;

    static TextView myText;
    static TextView text;
    String website;
    static ImageView myImage;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.resultText);
        text = (TextView) findViewById(R.id.webAddr);

        myConnManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        if(myInfo != null && myInfo.isConnected()){
            Toast.makeText(this, "AWESOME!", Toast.LENGTH_SHORT).show();
            c1 = new ConnectInternetTask(this);
            website=("http://"+text.getText());
            c1.execute(website);
            Toast.makeText(this, "Alamat ini adalah: "+website, Toast.LENGTH_SHORT).show();
            //c1.execute("http://www.google.com");
        }
        else{
            Toast.makeText(this, "BOLLOCKS, THE INTERNET IS DOWN!", Toast.LENGTH_SHORT).show();
        }
    }
}
