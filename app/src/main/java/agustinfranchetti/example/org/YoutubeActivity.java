package agustinfranchetti.example.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "YoutubeActivity";
    static final String YT_APIP = new String(String.valueOf(R.string.YT_API));
    static final String YT_VIDEO_ID = "WTsmIbNku5g";
    static final String YT_PLAYLIST = "PLOzDu-MXXLliO9fBNZOQTBDddoA3FzZUo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_youtube);
        //ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.activity_youtube);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(layout);

        /*Button button1 = new Button(this);
        button1.setLayoutParams(new ConstraintLayout.LayoutParams(300, 80));
        button1.setText("button added");
        layout.addView(button1);*/
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(YT_APIP, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is " + provider.getClass().toString());
        Toast.makeText(this, "YT player inicializado correctamente", Toast.LENGTH_LONG).show();

        if (wasRestored){
            youTubePlayer.cueVideo(YT_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
        }else{
            String errorMessage = String.format("Error al Inicializar Reproductor (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show();
        }
    }
}