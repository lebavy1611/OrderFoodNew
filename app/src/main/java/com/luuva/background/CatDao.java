package com.luuva.background;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonArray;
import com.luuva.model.Category;
import com.luuva.model.User;
import com.luuva.orderfood.AndroidLoginController;
import com.luuva.orderfood.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CatDao {
    public ArrayList<Category> getList(){
        final ArrayList<Category> arrCat = new ArrayList<>();
        final String url="https://lebavy1611.000webhostapp.com/getlistcat.php";
        String tag_string_req = "getlistcart";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("json", String.valueOf(response));
                if (response != null) {
                    Category objCat;
                    for (int i=0;i<response.length();i++){
                        try {
                            JSONObject jObj = response.getJSONObject(i);
                            Log.d("jobj: "+i,String.valueOf(jObj));
                            Log.d("id"+i,jObj.getInt("id")+"");
                            objCat = new Category(jObj.getInt("id"), jObj.getString("name_cat"), "R.drawable."+jObj.getString("picture"));
                            Log.d("jobjCat: "+i,objCat.toString());
                            arrCat.add(objCat);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e(TAG, "Login Error: " + error.getMessage());
                //toast("Unknown Error occurred");
                //progressDialog.hide();
            }
        });

        AndroidLoginController.getInstance().addToRequestQueue(jsonArrayRequest, tag_string_req);
        Log.d("length: ", arrCat.size()+"");
        return arrCat;
    }

}
