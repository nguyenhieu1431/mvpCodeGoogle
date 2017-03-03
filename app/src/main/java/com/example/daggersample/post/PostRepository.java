package com.example.daggersample.post;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.net.HttpHeaders.USER_AGENT;

/**
 * Created by Admin on 03/02/17.
 */

public class PostRepository implements PostDataSource {
    private static PostRepository INSTANCE;
    private PostDataSource mPostRemoteDataSource;
    private PostDataSource mPostLocalDataSource;
    private boolean mCacheIsDirty = false;

    private PostRepository(PostDataSource postRemoteDataSource, PostDataSource postLocalDataSource) {
        mPostRemoteDataSource = checkNotNull(postRemoteDataSource);
        mPostLocalDataSource = checkNotNull(postLocalDataSource);
    }

    public static PostRepository makeInstance(PostDataSource postRemoteDataSource, PostDataSource postLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new PostRepository(postRemoteDataSource, postLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getPosts(final CallBack callBack) {
        AsyncTask<String, String, String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String url = params[0];

                try {
                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                    // optional default is GET
                    con.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    return response.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                Type listType = new TypeToken<List<Post>>() {
                }.getType();
                List<Post> yourList = new Gson().fromJson(s, listType);

                callBack.onSuccess(yourList);
            }
        };
        asyncTask.execute("https://jsonplaceholder.typicode.com/posts");
    }

    public void refreshData() {
        mCacheIsDirty = true;
    }
}
