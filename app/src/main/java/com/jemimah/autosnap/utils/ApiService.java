package com.jemimah.autosnap.utils;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Multipart
    @POST("/images/upload-single")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part image);
}
