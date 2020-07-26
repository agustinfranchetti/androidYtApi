package agustinfranchetti.example.org;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubmenuActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

        Button btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouTubeStandalonePlayer.createVideoIntent(SubmenuActivity.this, YoutubeActivity.YT_APIP, YoutubeActivity.YT_VIDEO_ID));
                startActivity(intent);
            }
        });

        Button btnPlayList = (Button) findViewById(R.id.btnPlayList);
        btnPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouTubeStandalonePlayer.createVideoIntent(SubmenuActivity.this, YoutubeActivity.YT_APIP, YoutubeActivity.YT_PLAYLIST));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

        /*Intent intent = null;
        switch (view.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.YT_APIP, YoutubeActivity.YT_VIDEO_ID);
                break;

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.YT_APIP, YoutubeActivity.YT_PLAYLIST);
                break;
            default:
        }

        if (intent != null) {
            startActivity(intent);
        }*/


}
