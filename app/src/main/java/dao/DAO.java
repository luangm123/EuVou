package dao;

import android.app.Activity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public abstract class DAO {

    private static final String QUERY_KEY = "query";

    protected Activity activity;

    public DAO(Activity activity){

        setCurrentActivity(activity);
    }

    protected String executeQuery(String query){

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(QUERY_KEY, query));

        Consult consult = new Consult(params, this.currentActivity());

        String result = consult.execute();

        return result;
    }

    private void setCurrentActivity(Activity activity){

        this.activity = activity;
    }

    private Activity currentActivity(){

        return this.activity;
    }
}