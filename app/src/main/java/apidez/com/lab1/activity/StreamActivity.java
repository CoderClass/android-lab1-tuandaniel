package apidez.com.lab1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import apidez.com.lab1.R;
import apidez.com.lab1.adapter.PostAdapter;
import apidez.com.lab1.utils.Data;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class StreamActivity extends AppCompatActivity {
    private ListView lvPost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        lvPost = (ListView) findViewById(R.id.lvPost);
        lvPost.setAdapter(new PostAdapter(this, Data.posts()));
    }
}
