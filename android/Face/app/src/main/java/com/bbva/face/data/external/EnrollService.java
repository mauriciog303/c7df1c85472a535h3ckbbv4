package com.bbva.face.data.external;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EnrollService implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;

    public EnrollService(Context context) {
        this.context = context;

    }

    public void callService(String customerId, String imageBase64) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://34.70.200.167:8080/api/customerBiometrics/enrollCustomer/createEnroll";
        JSONObject data = new JSONObject();
        try {
            data.put("customerId", customerId.trim().toUpperCase());
            data.put("src_img", imageBase64);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, data, this, this);
        queue.add(jsonRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        response.toString();
    }
}
