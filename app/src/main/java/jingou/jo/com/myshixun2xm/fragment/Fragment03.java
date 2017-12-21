package jingou.jo.com.myshixun2xm.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dl7.player.media.IjkPlayerView;

import jingou.jo.com.myshixun2xm.R;


/**
 * Created by 杨杰 on 2017/10/25.
 */

public class Fragment03 extends Fragment{
    private IjkPlayerView mPlayerView;
    private Uri mUri;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3, container, false);
        initView();
        return view;
    }

    private void initView() {
        mPlayerView = (IjkPlayerView) view.findViewById(R.id.player_view);
        mUri = Uri.parse("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");

        mPlayerView.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();
    }
}
