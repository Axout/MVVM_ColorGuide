package ru.axout.mvvm_colorguide.network;


import android.content.Context;
import retrofit2.Callback;
import retrofit2.Response;

public class Call {

    private retrofit2.Call<FlowerResponse> call;
    private Delegate delegate;

    public Call(Context context, Delegate delegate) {
        this.delegate = delegate;
    }

    public void execute() {
        ICall callInterface = Api.getClient().create(ICall.class);
        call = callInterface.getAllFlowers();
        call.enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(retrofit2.Call<FlowerResponse> call, Response<FlowerResponse> response) {
                int statusCode = response.code();
                if (statusCode == Config.RESP_OK) delegate.onSuccess(response.body());
                else delegate.onFailure("On failure - " + statusCode);
            }

            @Override
            public void onFailure(retrofit2.Call<FlowerResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
            }
        });
    }

    public interface Delegate {
        void onSuccess(FlowerResponse flowerResponse);
        void onFailure(Object t);
    }
}
